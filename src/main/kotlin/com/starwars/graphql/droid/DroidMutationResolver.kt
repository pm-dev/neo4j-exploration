package com.starwars.graphql.droid

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.starwars.data.model.Character
import com.starwars.data.model.Droid
import com.starwars.data.model.Episode
import org.neo4j.ogm.session.Session
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*

@Component
class DroidMutationResolver(
        val session: Session
) : GraphQLMutationResolver {

    @Transactional
    fun createDroid(
            name: String,
            primaryFunction: String,
            friendIds: Set<Long>,
            appearsIn: EnumSet<Episode>
    ): Droid {
        val droid = Droid(
                primaryFunction = primaryFunction,
                name = name,
                appearsIn = appearsIn,
                createdAt = Instant.now())
        val friends = session.loadAll(Character::class.java, friendIds)
        droid.friends.addAll(friends)
        session.save(droid)
        return droid
    }
}
