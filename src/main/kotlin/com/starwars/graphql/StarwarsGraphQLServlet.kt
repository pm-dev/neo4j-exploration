package com.starwars.graphql

import com.coxautodev.graphql.tools.SchemaParser
import com.starwars.graphql.character.CharacterQueryResolver
import com.starwars.graphql.droid.DroidMutationResolver
import com.starwars.graphql.droid.DroidQueryResolver
import com.starwars.graphql.droid.DroidTypeResolver
import com.starwars.graphql.human.HumanQueryResolver
import com.starwars.graphql.human.HumanTypeResolver
import graphql.execution.batched.BatchedExecutionStrategy
import graphql.servlet.SimpleGraphQLServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.stereotype.Component

@Component
class StarwarsGraphQLServletRegistrationBean(
        characterQueryResolver: CharacterQueryResolver,
        humanTypeResolver: HumanTypeResolver,
        humanQueryResolver: HumanQueryResolver,
        droidTypeResolver: DroidTypeResolver,
        droidQueryResolver: DroidQueryResolver,
        droidMutationResolver: DroidMutationResolver
): ServletRegistrationBean<SimpleGraphQLServlet>(SimpleGraphQLServlet(
        SchemaParser.newParser()
                .file("starwars.graphqls")
                .resolvers(
                        characterQueryResolver,
                        humanTypeResolver,
                        humanQueryResolver,
                        droidTypeResolver,
                        droidQueryResolver,
                        droidMutationResolver)
                .build().makeExecutableSchema(),
        BatchedExecutionStrategy()), "/graphql")
