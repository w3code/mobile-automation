package io.github.w3code.helpers;

import static io.github.w3code.drivers.BrowserstackMobileDriver.browserstack;
import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(browserstack.user(), browserstack.key())
                .when()
                .get(browserstack.apiUrl() + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
