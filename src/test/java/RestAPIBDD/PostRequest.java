package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
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
					.post("employees/create") //to create :posy
					.then()
					.log()//printing
					.all()
					.statusCode(201)     //to check and print status code
					.body("name", Matchers.equalTo("anitha"))	; //to match or verify name
	}
}
