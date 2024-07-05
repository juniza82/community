package com.company.community.config.datasource

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ModelMapperConfig {

    @Bean
    fun modelMapper() = ModelMapper().apply {
        configuration.setFieldMatchingEnabled(true)
        configuration.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        configuration.setMatchingStrategy(MatchingStrategies.STRICT)
        configuration.setAmbiguityIgnored(true)
    }
}