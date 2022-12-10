package RestAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getrequestwithparameter {
	
	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification request = RestAssured.given();
		
		Response response = request.param("id", 2).get("employees");
		
		System.out.println(response.getBody().asString());
		
		System.out.println(response.headers().toString());			//print headers

		
		String ResponseBody =response.getBody().asString();
		Assert.assertTrue(ResponseBody.contains("David"));			// it checking david there or no string 

	  //or we can use below  path 
		
		JsonPath jpath = response.jsonPath();
		List<String>names=jpath.get("name");//print name
		System.out.println("the name is :"  + names.get(0));
		
		Assert.assertEquals(names.get(0),"David");
		
	
		JsonPath jpath1 = response.jsonPath();
		List<Integer>salary=jpath1.get("salary"); //print his salary
		System.out.println("the salary is :"  + salary.get(0));
		
		Assert.assertEquals(salary.get(0),"5000");
		
		
			}
		
		
		
	
	}
	
	
	
