package com.starwars.graphql.droid

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.starwars.data.model.Droid
import graphql.schema.DataFetchingEnvironment
import org.neo4j.ogm.session.Session
import org.springframework.stereotype.Component

@Component
class DroidQueryResolver(
       val session: Session
): GraphQLQueryResolver {

    fun droid(name: String, environment: DataFetchingEnvironment): Droid? =
            session.loadAll(Droid::class.java).find { it.name == name }
}
