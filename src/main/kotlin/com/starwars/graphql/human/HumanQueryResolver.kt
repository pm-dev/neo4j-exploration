package com.starwars.graphql.human

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.starwars.data.model.Human
import graphql.schema.DataFetchingEnvironment
import org.neo4j.ogm.session.Session
import org.springframework.stereotype.Component

@Component
class HumanQueryResolver(
        val session: Session
) : GraphQLQueryResolver {

    fun human(name: String, environment: DataFetchingEnvironment): Human? =
            session.loadAll(Human::class.java).find { it.name == name }

}
