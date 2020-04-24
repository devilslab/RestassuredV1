package RestAssuredTestCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_ReadingAllHeaders {

	@Test
	public void getAllHeader()
	{


		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

		RequestSpecification httpRespose = RestAssured.given();

		Response response = httpRespose.request(Method.GET,"/Ludhiana");


		System.out.println("Printing all the Headers");
		Headers allHeaders = response.headers();

		for(Header headers :   allHeaders)
		{
			System.out.println("Header Name:" +headers.getName()+ "   |   "+ "Headers Value:"+ headers.getValue());
		}


	}


}
