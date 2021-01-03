package tests.api.privat24;

import io.restassured.http.ContentType;
import org.apache.logging.log4j.core.Core;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import tests.api.BaseApiTest;

import static io.restassured.RestAssured.given;

public class PrivatATMs extends BaseApiTest {

    //https://api.privatbank.ua/p24api/infrastructure?json&atm&address=&city=

    @Test
    public void checkJsonATMAPI() {
        given()
                .spec(this.reqSpec)
                .queryParam("json")
                .queryParam("atm")
                .queryParam("address", "")
                .queryParam("city", "Киев")
                .contentType(ContentType.JSON)

                .when()
                .get("/infrastructure")

                .then()
                .spec(this.resSpec)
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("devices.placeUa", CoreMatchers.hasItem("Гiпермаркет Ашан"))
                .and()
                .body("devices.fullAddressEn", CoreMatchers.hasItem("Ukraine,city Kyiv,street Akademika Krzhyzhanovskoho,building 3,Housing 2"))
                .and()
                .body("devices.type", CoreMatchers.notNullValue());

    }


}
