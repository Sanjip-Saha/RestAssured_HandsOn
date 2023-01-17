package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequestDemo {

	@Test
	public void Postdetails() {
		RestAssured.baseURI ="https://reqres.in/api/users";
		
		HashMap data = new HashMap();
		data.put("email", "ssemail.com");
		data.put("first_name", "Sanjip");
		data.put("last_name", "Saha");
		
		Response res =
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all()
			.assertThat().body("id", is(notNullValue()))
			.body("createdAt", is(notNullValue()))
			.extract().response();
		
		String jsonres= res.asString();
		System.out.println("Response:" +jsonres);
//		Assert.assertEquals(jsonres.contains("Record Added Successfully"), true);
	}
}
