package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void test1() {
		

		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		
		
		Response response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"Rohan\",\r\n"
						+ "    \"salary\": \"9000\"\r\n"
						+ "}")
				.put("employees/3");
		
		System.out.println(response.getBody().asString());
		
		int responsecode =response.getStatusCode();
		Assert.assertEquals(200,responsecode);
		
		System.out.println(response.getStatusCode());
}}
