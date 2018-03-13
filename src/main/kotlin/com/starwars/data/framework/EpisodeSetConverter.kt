package com.starwars.data.framework

import com.starwars.data.model.Episode
import org.neo4j.ogm.typeconversion.AttributeConverter
import java.util.*

class EpisodeSetConverter: AttributeConverter<EnumSet<Episode>, Set<String>> {

    override fun toGraphProperty(value: EnumSet<Episode>): Set<String> =
            value.map { it.name }.toHashSet()

    override fun toEntityAttribute(value: Set<String>): EnumSet<Episode> =
            if(value.isEmpty()) EnumSet.noneOf(Episode::class.java) else EnumSet.copyOf(value.map { Episode.valueOf(it) })
}
