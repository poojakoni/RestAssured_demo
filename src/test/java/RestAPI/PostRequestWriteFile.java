package RestAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWriteFile {
	@Test
	public void test1() throws IOException {
		
	//byte[]datafile = Files.readAllBytes(Paths.get("data.json"));       or below one
		
		File datafile =new File("data.json");

		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		
		
		Response response = request
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(datafile)
							.post("employees/create");
		
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(201, responseCode);
	}

}
