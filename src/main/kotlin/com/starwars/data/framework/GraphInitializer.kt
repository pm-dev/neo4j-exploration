package com.starwars.data.framework

import com.starwars.data.model.Droid
import com.starwars.data.model.Episode
import com.starwars.data.model.Human
import org.neo4j.ogm.session.Session
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*


@Component
class ApplicationStartup(
        val session: Session
) : ApplicationListener<ApplicationReadyEvent> {

    @Transactional
    override fun onApplicationEvent(event: ApplicationReadyEvent) {

        val now = Instant.now()

        val lukeSkywalker = Human(
                name = "Luke Skywalker",
                homePlanet = "Tatooine",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                createdAt = now)

        val darthVader = Human(
                name = "Darth Vader",
                homePlanet = "Tatooine",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                createdAt = now)

        val hanSolo = Human(
                name = "Han Solo",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                homePlanet = null,
                createdAt = now)

        val leiaOrgana = Human(
                name = "Leia Organa",
                homePlanet = "Alderaan",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                createdAt = now)

        val wilhuffTarkin = Human(
                name = "Wilhuff Tarkin",
                appearsIn = EnumSet.of(Episode.newHope),
                homePlanet = null,
                createdAt = now)

        val c3po = Droid(
                name = "C-3PO",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                primaryFunction = "Protocol",
                createdAt = now)

        val aretoo = Droid(
                name = "R2-D2",
                appearsIn = EnumSet.of(Episode.newHope, Episode.jedi, Episode.empire),
                primaryFunction = "Astromech",
                createdAt = now)

        lukeSkywalker.friends.addAll(listOf(hanSolo, leiaOrgana, c3po, aretoo))
        darthVader.friends.add(wilhuffTarkin)
        hanSolo.friends.addAll(listOf(leiaOrgana, aretoo))
        leiaOrgana.friends.addAll(listOf(c3po, aretoo))
        c3po.friends.add(aretoo)

        listOf(
                lukeSkywalker,
                hanSolo,
                leiaOrgana,
                c3po,
                aretoo,
                wilhuffTarkin,
                darthVader).forEach { session.save(it) }

        println("Loaded Starwars Data")
    }
}
