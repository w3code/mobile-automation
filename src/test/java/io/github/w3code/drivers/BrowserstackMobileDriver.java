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
            return new URL(browserstack.hubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", browserstack.user());
        desiredCapabilities.setCapability("browserstack.key", browserstack.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", browserstack.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", browserstack.device());
        desiredCapabilities.setCapability("os_version", browserstack.osVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", browserstack.project());
        desiredCapabilities.setCapability("build", browserstack.build());
        desiredCapabilities.setCapability("name", browserstack.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
