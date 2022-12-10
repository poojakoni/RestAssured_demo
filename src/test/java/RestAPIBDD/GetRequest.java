package RestAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {

	@Test       //using testNG and creating class
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/")
					.get("employees") //print all employees
					.then()
					.log()//print
					.all()
					.statusCode(200);
					
	}
	
	
	
	@Test       //using testNG and creating class
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/")
					.get("employees/18") //id;18 anitha name matches or no like that
					.then()
					.log()
					.all()
					.statusCode(200)
					.body("name", Matchers.equalTo("anitha"));
		
		
	}
	@Test       //using testNG and creating class
	public void test3() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/")
					.get("employees") 
					.then()
					.log()
					.body()
					.statusCode(200)
					.body("[0].name", Matchers.equalTo("Pankaj")); //giving index number to match name
	}

}
