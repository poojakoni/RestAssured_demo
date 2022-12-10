package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {
		@Test
		public void test1() {
			

			RestAssured.baseURI = "http://localhost:3000";
			RequestSpecification request = RestAssured.given();
			
			
			Response response = request
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body("{\r\n"
							+ "    \"salary\": \"5000\"\r\n"
							+ "}")
					.patch("employees/3");
			
			System.out.println(response.getBody().asString());
			
			int responsecode =response.getStatusCode();
			Assert.assertEquals(200,responsecode);
			
			System.out.println(response.getStatusCode());
	}}
