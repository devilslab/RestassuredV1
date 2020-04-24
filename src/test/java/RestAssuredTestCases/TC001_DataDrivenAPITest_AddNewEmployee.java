package RestAssuredTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_DataDrivenAPITest_AddNewEmployee {
	
	
	@Test(dataProvider ="employeeData")
	public void postNewEmployee(String ename,  String esalary, String eage )
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject JObject = new JSONObject();
		
		JObject.put("name", ename);
		JObject.put("salary", esalary);
		JObject.put("age", eage);
		
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(JObject.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/create");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Code : "+response.getStatusCode());
		
		String responseBody = response.body().asString();
		
		System.out.println(ename +" " + esalary+ " " +eage) ;
		Assert.assertEquals(responseBody.contains(ename),true);
		
		System.out.println(responseBody);
	
	}
	
	@DataProvider(name="employeeData")
	public String[][] getData()
	{
		String data[][] ={{"tina","3300", "18"},
				{"mina","5000", "26",}
				
		};
		
		return(data);
	}

}
