package com.starwars.data.model

import com.starwars.data.framework.EpisodeSetConverter
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship
import org.neo4j.ogm.annotation.Relationship.UNDIRECTED
import org.neo4j.ogm.annotation.typeconversion.Convert
import java.time.Instant
import java.util.*

@NodeEntity
abstract class Character(
        @Property(name = "name") var name: String,
        @Property(name = "appearsIn") @Convert(EpisodeSetConverter::class) var appearsIn: EnumSet<Episode>,
        @Relationship(type = "friends", direction = UNDIRECTED) var friends: MutableSet<Character> = HashSet(),
        createdAt: Instant
) : Node(
        createdAt = createdAt
)
