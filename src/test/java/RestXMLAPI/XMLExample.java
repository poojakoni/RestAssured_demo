package RestXMLAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.element.NodeChildren;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLExample {

	@Test
	public void test() {
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";

		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		System.out.println(response.getBody().asString());
		
		NodeChildren allbooks = response.then().extract().path("bookstore.book.title");
		
		System.out.println(allbooks);
		System.out.println("first book " + allbooks.get(0));
		System.out.println("first book " + allbooks.get(1));
		
		System.out.println("first book laguage " + allbooks.get(0).getAttribute("lang"));
		System.out.println("second book laguage " + allbooks.get(1).getAttribute("lang"));
		
		
				 
		}
	}

