package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletRequestEmployee {
	
			@Test
		public void test1() {
			

			RestAssured.baseURI = "http://localhost:3000";
			RequestSpecification request = RestAssured.given();
			
			
			Response response = request.delete("employees/8");
			
			System.out.println(response.getBody().asString());
			
			int responsecode =response.getStatusCode();
			Assert.assertEquals(404,responsecode);
			
			System.out.println(response.getStatusCode());
	}}

