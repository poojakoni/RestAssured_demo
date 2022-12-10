package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	
	@Test       //using testNG and creating class
	public void test1() {
		
		
Map<String,Object> MapObj = new HashMap<String,Object>();
		
		MapObj.put("name", "anitha");
		MapObj.put("salary", "7500");
		RestAssured.given()
					.baseUri("http://localhost:3000/")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.when()
					.put("employees/5") //put request
					.then()
					.log()
					.all()
					.statusCode(200);
					
					
}
}