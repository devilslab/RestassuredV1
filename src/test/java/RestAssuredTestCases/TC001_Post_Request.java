package RestAssuredTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/*
 * Program to send POST request 
 * URL = "http://restapi.demoqa.com/customer"
 * Parameter need to passed to the request in the JSON format
 * validate success code is  201
 * "SuccessCode": "OPERATION_SUCCESS",
    "Message": "Operation completed successfully"
 */

public class TC001_Post_Request {

	@Test
	public void registration()
	{

		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		//Request payload//
		JSONObject requestParameter = new JSONObject();

		requestParameter.put("name", "sirji");
		requestParameter.put("salary", "80000");
		requestParameter.put("age", "32");
		


		httpRequest.header("Content-Type","application/json");

		//Attaching the data to the request//
		httpRequest.body(requestParameter.toJSONString());

		//register is the function name to who we calling & sending data using POST//
		Response response = httpRequest.post("/create");
		//printing the response body//
		System.out.println("Response body "+response.getBody().asString());
		//validation of the response code //
		Assert.assertEquals(200, response.getStatusCode());
		//Printing the Response code //
		System.err.println("Response code is "+response.getStatusCode());

		//Fetching the success code from Json bod format & Validating the Success code //
		Assert.assertEquals("success", response.jsonPath().get("status"));
	Assert.assertEquals(response.getBody().asString().contains("sirji"), true);
		System.out.println("status is "+response.jsonPath().get("status"));



	}

}
