package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

public abstract class BaseApiTest {

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;

    @Before
    public void setSpecs() {
        reqSpec = new RequestSpecBuilder()
                //.setBaseUri("https://api.privatbank.ua/p24api")
                .log(LogDetail.ALL)
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

}
