package restAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequestDemo {

	@Test
	public void Deletedata() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/2";
		
		Response res =
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.log().all()
			.assertThat().body("status", equalTo("success"))
			.extract().response();
		
		String jsonres = res.asString();
		Assert.assertEquals(jsonres.contains("Successfully! Record has been deleted"), true);
	}
}
