package io.github.w3code.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("apiUrl")
    String apiUrl();

    @Key("hubUrl")
    String hubUrl();

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
