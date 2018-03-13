package com.starwars.data.model

import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import java.time.Instant
import java.util.*

@NodeEntity(label = "Droid")
class Droid(
        @Property(name = "primaryFunction") var primaryFunction: String,
        name: String,
        appearsIn: EnumSet<Episode>,
        createdAt: Instant
) : Character(
        name = name,
        appearsIn = appearsIn,
        createdAt = createdAt
)
