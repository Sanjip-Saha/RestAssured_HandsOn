package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GetRequestDemo {
	
	@Test
	public void Getdetails() {
		RestAssured.baseURI ="https://demoqa.com/utilities/weather/city";
		RestAssured.basePath ="/Kolkata";
		given()
		.when()
			.get()
		.then()
			.statusCode(200)
			.log().body()
			.assertThat().body("City", equalTo("Kolkata"));
	}
}
