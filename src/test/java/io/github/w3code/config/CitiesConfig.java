package io.github.w3code.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/cities.properties"})
public interface CitiesConfig extends Config {
    @Key("departureCity")
    String departureCity();

    @Key("arrivalCity")
    String arrivalCity();
}
