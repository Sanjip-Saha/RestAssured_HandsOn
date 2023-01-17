package restAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutRequestDemo {
	
	@Test
	public void Updatedata() {
		
		RestAssured.baseURI ="https://reqres.in/api/users";
		RestAssured.basePath = "/2";
		
		HashMap data = new HashMap();
		data.put("Name", "Ajit");
		data.put("email", "ajitemail.com");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all()
			.assertThat().body("updatedAt", is(notNullValue()));
			
	}
}
