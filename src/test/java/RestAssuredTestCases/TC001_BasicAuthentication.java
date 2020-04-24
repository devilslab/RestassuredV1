package RestAssuredTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * This program contact with the API wi th valid username password
 */

public class TC001_BasicAuthentication {

	@Test
	public void authentication()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

		

		//Sending username & Password to API//
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		//Sending credentials to API//
		RestAssured.authentication = authScheme;
		
		
		RequestSpecification httpRequest = RestAssured.given();

		Response respone = httpRequest.request(Method.GET,"/");

		Assert.assertEquals(respone.getStatusCode(), 200);
		System.out.println("Status Code : " + respone.getStatusCode());
		//System.out.println("Response Body" +respone.getBody().asString());
		System.out.println("FaultId : "+ respone.jsonPath().get("FaultId").toString());
		System.out.println("Fault :  " +respone.jsonPath().get("Fault").toString());






	}

}
