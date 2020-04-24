package RestAssuredTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/*
 * Program to get the header from given URI 
 * 
 * 
 */
public class TC001_Get_HeaderValidation {

	@Test
	public void validateHeader()
	{
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Ludhiana");
		
		System.out.println(response.getBody().asString());
		
		System.out.println("Content Type:"+response.getHeader("Content-Type"));
		System.out.println("Content Type:"+response.getHeader("Content-Encoding"));
		
		
		
	}
}
