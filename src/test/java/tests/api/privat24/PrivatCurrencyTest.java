package tests.api.privat24;

import io.restassured.filter.log.LogDetail;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tests.api.BaseApiTest;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.XML;

@RunWith(Parameterized.class)
public class PrivatCurrencyTest extends BaseApiTest {

    //https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5

    private String type;
    private String id;
    private String path;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> result = new ArrayList<>();
        Object[] xml11 = new Object[3];
        xml11[0] = "xml";
        xml11[1] = "11";
        xml11[2] = "exchangerates.row.exchangerate.@ccy";
        Object[] xml5 = new Object[3];
        xml5[0] = "xml";
        xml5[1] = "11";
        xml5[2] = "exchangerates.row.exchangerate.@ccy";
        Object[] json11 = new Object[3];
        json11[0] = "json";
        json11[1] = "11";
        json11[2] = "ccy";
        Object[] json5 = new Object[3];
        json5[0] = "json";
        json5[1] = "11";
        json5[2] = "ccy";
        result.add(xml5);
        result.add(xml11);
        result.add(json11);
        result.add(json5);
        return result;
    }

    public PrivatCurrencyTest(String type, String id, String path) {
        this.type = type;
        this.id = id;
        this.path = path;
    }

    @Test
    public void checkJsonCurrencyAPI() {
        given()
                .spec(this.reqSpec)
                //.queryParam("json")
                .queryParam(this.type)
                .queryParam("exchange")
                .queryParam("coursid", this.id)
                .baseUri("https://api.privatbank.ua/p24api")
/*                .log()
                .all(true)*/
                .when()
                .get("/pubinfo")
                .then()
                .spec(this.resSpec)
/*                .log()
                //.all(true)
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200);*/
                .assertThat()
                //.body("ccy", CoreMatchers.hasItem("USD")); //for json format
                .body(this.path, CoreMatchers.hasItem("USD")); //for xml format
/*                .and()
                .extract()
                .xmlPath()
                .getList("exchangerates.row.exchangerate.@ccy");
        result.forEach(System.out::println);*/
    }

    //Template FOR POST method!!!!!!!!
/*    @Test
    public void checkJsonCurrencyAPIPOST() {
        Map<String, Object> body = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        body.put("status", "active");
        data.put("key", "value");
        body.put("data", data);

        List<String> result = given()
                .spec(this.reqSpec)
                .queryParam("xml")
                .queryParam("exchange")
                .queryParam("coursid", 5)
                .body(body)
                .contentType(XML)
                .when()
                .post("/pubinfo")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("exchangerates.row.exchangerate.@ccy", CoreMatchers.hasItem("USD")) //for xml format
                .and()
                .extract()
                .xmlPath()
                .getList("exchangerates.row.exchangerate.@ccy");
        result.forEach(System.out::println);
    }*/

}
