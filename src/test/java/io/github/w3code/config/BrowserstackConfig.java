package io.github.w3code.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstackApiUrl")
    String browserstackApiUrl();

    @Key("browserstackHubUrl")
    String browserstackHubUrl();

    @Key("browserstackUser")
    String browserstackUser();

    @Key("browserstackKey")
    String browserstackKey();

    @Key("browserstackApp")
    String browserstackApp();

    @Key("browserstackDevice")
    String browserstackDevice();

    @Key("browserstackOsVersion")
    String browserstackOsVersion();

    @Key("browserstackProject")
    String browserstackProject();

    @Key("browserstackBuild")
    String browserstackBuild();

    @Key("browserstackName")
    String browserstackName();
}
