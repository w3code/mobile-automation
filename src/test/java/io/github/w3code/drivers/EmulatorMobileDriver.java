package io.github.w3code.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.github.w3code.config.EmulatorConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.w3code.utils.FileUtils.getAbsolutePath;

public class EmulatorMobileDriver implements WebDriverProvider {
    public static EmulatorConfig emulator = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    public static URL getEmulatorUrl() {
        try {
            return new URL(emulator.hubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", emulator.deviceName());
        desiredCapabilities.setCapability("version", emulator.version());
        desiredCapabilities.setCapability("platformName", emulator.platformName());
        desiredCapabilities.setCapability("locale", emulator.locale());
        desiredCapabilities.setCapability("language", emulator.language());
        desiredCapabilities.setCapability("appPackage", emulator.appPackage());
        desiredCapabilities.setCapability("appActivity", emulator.appActivity());
        desiredCapabilities.setCapability("app", getAbsolutePath(emulator.app()));
        desiredCapabilities.setCapability("appium:appWaitForLaunch", false);

        return new AndroidDriver(getEmulatorUrl(), desiredCapabilities);
    }
}
