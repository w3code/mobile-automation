package io.github.w3code.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.github.w3code.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static BrowserstackConfig browserstack = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstack.browserstackHubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", browserstack.browserstackUser());
        desiredCapabilities.setCapability("browserstack.key", browserstack.browserstackKey());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", browserstack.browserstackApp());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", browserstack.browserstackDevice());
        desiredCapabilities.setCapability("os_version", browserstack.browserstackOsVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", browserstack.browserstackProject());
        desiredCapabilities.setCapability("build", browserstack.browserstackBuild());
        desiredCapabilities.setCapability("name", browserstack.browserstackName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
