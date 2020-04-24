package RestAssuredTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Body_Data_Validation {
	
	@Test
	public void bodyDataValidation()
	{
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city/";
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Ludhiana");

		Assert.assertEquals(response.body().asString().contains("Ludhiana"), true);
		System.out.println(response.body().asString());
		
	}

}
