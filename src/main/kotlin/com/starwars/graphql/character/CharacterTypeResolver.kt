package com.starwars.graphql.character

import com.starwars.data.model.Character
import com.starwars.data.model.Episode

interface CharacterTypeResolver {

    fun getId(character: Character): Long = character.id ?: -1
    fun getName(character: Character): String = character.name
    fun getAppearsIn(character: Character): Set<Episode> = character.appearsIn
    fun getFriends(character: Character): Set<Character> = character.friends
    fun getSecondDegreeFriends(character: Character, limit: Int?): Set<Character> {
        val firstDegree = character.friends
        val secondDegree = mutableSetOf<Character>()
        firstDegree.forEach { secondDegree.addAll(it.friends) }
        secondDegree.removeAll(firstDegree)
        secondDegree.remove(character)
        return secondDegree
    }
}
