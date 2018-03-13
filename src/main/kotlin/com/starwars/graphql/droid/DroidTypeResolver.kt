package com.starwars.graphql.droid

import com.coxautodev.graphql.tools.GraphQLResolver
import com.starwars.graphql.character.CharacterTypeResolver
import com.starwars.data.model.Droid
import org.springframework.stereotype.Component

@Component
class DroidTypeResolver: CharacterTypeResolver, GraphQLResolver<Droid> {

    fun getPrimaryFunction(droid: Droid) = droid.primaryFunction

    // These redundant overrides are necessary for graphql.tools
    fun getId(node: Droid) = super.getId(node)
    fun getName(character: Droid) = super.getName(character)
    fun getAppearsIn(character: Droid) = super.getAppearsIn(character)
    fun getFriends(character: Droid) = super.getFriends(character)
    fun getSecondDegreeFriends(character: Droid, limit: Int?) = super.getSecondDegreeFriends(character, limit)
}
