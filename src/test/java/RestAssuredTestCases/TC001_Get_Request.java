package RestAssuredTestCases;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


/*
 This is basic program to get the weather condition for a City.
 This program will use "GET" protocol along with City as parameter.
 this program will assert if the return value is 200.
 this program will print status code.
 */


public class TC001_Get_Request {

	@Test
	public void getWeatherDetails()
	{

		//setting up the Base URI//
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city/";


		//Request Object//
		RequestSpecification httpRequest = RestAssured.given();

		//Response Object//
		Response response = httpRequest.request(Method.GET, "/Ludhiana");

		String  responseBody = response.getBody().asString();

		System.out.println(responseBody);


		// verifying if the status code is as per our expectations//
		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("The status code is: "+response.getStatusCode());
		System.out.println("The status Line is: "+response.getStatusLine());

	}

}
