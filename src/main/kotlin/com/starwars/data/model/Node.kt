package com.starwars.data.model

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import java.time.Instant

@NodeEntity
abstract class Node(
        @Property(name = "id") @Id @GeneratedValue var id: Long? = null,
        @Property(name = "createdAt") var createdAt: Instant
) {

    override fun hashCode(): Int = id?.hashCode() ?: super.hashCode()

    override fun equals(other: Any?): Boolean = id != null && other != null && other is Node && id == other.id
}
