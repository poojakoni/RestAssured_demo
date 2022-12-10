package RestGitHub;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo_usingTocken {

	
	@Test
	
	public void test1() {
		
		
		File datafile = new File("data1.json");
		
			
			RestAssured.given()
						.auth()
						.oauth2("abc") //git token need to give here
						.baseUri("https://api.github.com")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(datafile)//in file kept all data to create git repo
						.when()
						.post("user/repos")//creating repo
						.then()
						.log()
						.all()
						.statusCode(201) ;
	}
}
