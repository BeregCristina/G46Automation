package tests.api.nova_poshta;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Before;
import org.junit.Test;
import tests.api.BaseApiTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class NPSearchSettlements extends BaseApiTest {

    private final static String API_KEY = "[ВАШ КЛЮЧ]";

    private Map<String, Object> reqBody = new HashMap<>();

    @Before
    public void setReqBody(){
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("CityName", "київ");
        methodProperties.put("Limit", 5);

        reqBody.put("apiKey", API_KEY);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "searchSettlements");
        reqBody.put("methodProperties", methodProperties);

    }


    @Test
    public void checkSettlements(){
        given()
                .spec(this.reqSpec)
                .baseUri("http://testapi.novaposhta.ua/v2.0")
                .body(this.reqBody)
                .contentType(ContentType.JSON)

                .when()
                .post("/json/Address/searchSettlements/")

                .then()
                .spec(this.resSpec)
                .assertThat()
                .body(matchesJsonSchema(new File("C:\\Users\\khber\\IdeaProjects\\G46Automation\\src\\test\\resources\\validators\\np_address_schema.json")));
    }
}
