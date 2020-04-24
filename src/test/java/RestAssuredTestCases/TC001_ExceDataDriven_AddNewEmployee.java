package RestAssuredTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.readExcelUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_ExceDataDriven_AddNewEmployee {
	

	String filePath = System.getProperty("user.dir")+"\\Data\\DataSheet.xls";

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
		
		
		String responseBody = response.body().asString();
		
		Assert.assertEquals(responseBody.contains(ename),true);
		Assert.assertEquals(responseBody.contains(esalary),true);
		Assert.assertEquals(responseBody.contains(eage),true);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Code : "+response.getStatusCode());
		
		System.out.println(responseBody);
	
	}
	
	@DataProvider(name="employeeData")
	public String[][] getData()
	{
		
		int rowNum = readExcelUtility.getRowNum(filePath, "Sheet1");
		int colNum = readExcelUtility.getColnum(filePath, "Sheet1", 1);
		String[][] data = new String[rowNum][colNum];
		
		for(int i = 1; i<= rowNum; i++)
		{
			for (int j= 0 ;j< colNum;j++)
			{
				data[i-1][j] = readExcelUtility.readData(filePath, "Sheet1" ,i ,j);
			}
		}
		return(data);
	}

	
	
}
