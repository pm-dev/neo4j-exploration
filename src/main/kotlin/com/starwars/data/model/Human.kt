package com.starwars.data.model

import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import java.time.Instant
import java.util.*

@NodeEntity(label = "Human")
class Human(
        @Property(name = "homePlanet") var homePlanet: String?,
        name: String,
        appearsIn: EnumSet<Episode>,
        createdAt: Instant
) : Character(
        name = name,
        appearsIn = appearsIn,
        createdAt = createdAt
)
