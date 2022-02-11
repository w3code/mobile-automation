package io.github.w3code.tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class flightSearchTests extends TestBase {

    @Test
    void ticketSearchTest() {
        step("Taping the Skip button", () ->
                $(byClassName("android.widget.TextView")).click());

        step("Entering the departure city", () -> {
            $(MobileBy.id("ru.aviasales:id/searchFrom")).click();
            $(MobileBy.id("ru.aviasales:id/editTextMessage")).sendKeys(cities.departureCity());
            $(MobileBy.id("ru.aviasales:id/searchToButtonView")).click();
        });

        step("Entering the arrival city", () -> {
            $(MobileBy.id("ru.aviasales:id/searchTo")).click();
            $(MobileBy.id("ru.aviasales:id/editTextMessage")).sendKeys(cities.arrivalCity());
            $(MobileBy.id("ru.aviasales:id/searchToButtonView")).click();
        });

        step("Taping the Date button", () ->
                $(MobileBy.id("ru.aviasales:id/firstDateText")).click());

        step("Selecting current month ", () ->
                $(MobileBy.id("ru.aviasales:id/tvMonthChoose")).click());

        step("Taping the Apply button", () ->
                $(MobileBy.id("ru.aviasales:id/btnApply")).click());

        step("Checking is cheapest offer exist", () ->
                $(MobileBy.id("ru.aviasales:id/contentRecycler")).
                        $(MobileBy.id("ru.aviasales:id/cheapestOfferView")).should(exist));
    }
}
