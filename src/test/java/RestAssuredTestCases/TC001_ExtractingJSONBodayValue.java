package RestAssuredTestCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_ExtractingJSONBodayValue {
	@Test
	public void extractBodyValue()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET,"/Ludhiana");
		
		JsonPath jasonPath = response.jsonPath();
		
		//for(HashMap  allBody : jasonPath)
		Assert.assertEquals("Ludhiana", jasonPath.get("City"));
		System.out.println("The "+jasonPath.get("City").toString()+"is the city");
		
		



	}

}
