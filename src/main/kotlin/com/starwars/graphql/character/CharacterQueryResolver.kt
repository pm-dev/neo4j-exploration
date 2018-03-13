package com.starwars.graphql.character

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.starwars.data.model.Character
import com.starwars.data.model.Human
import graphql.schema.DataFetchingEnvironment
import org.neo4j.ogm.session.Session
import org.springframework.stereotype.Component

@Component
class CharacterQueryResolver(
        val session: Session
) : GraphQLQueryResolver {

    fun hero(environment: DataFetchingEnvironment): Character =
            session.loadAll(Human::class.java).find { it.name == "Luke Skywalker" }!!

    fun character(name: String, environment: DataFetchingEnvironment): Character? =
            session.loadAll(Character::class.java).find { it.name == name }
}
