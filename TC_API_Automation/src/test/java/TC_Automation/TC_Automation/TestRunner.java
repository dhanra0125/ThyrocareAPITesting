package TC_Automation.TC_Automation;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class TestRunner 
{

	static String BaseURL;
	static String APIKEY;
	static String[] TestData = new String[5];

	/*
	 * @BeforeMethod
	 * 
	 * @SuppressWarnings("resource") public String[] GetExcelData(int TestCaseID)
	 * throws IOException {
	 * 
	 * FileInputStream fs = new FileInputStream("C:\\Users\\4482E\\Desktop\\New folder\\TESTDATA.xlsx");
	 * XSSFWorkbook workbook = new XSSFWorkbook(fs); XSSFSheet sheet =
	 * workbook.getSheet("API");
	 * 
	 * TestData[0]=sheet.getRow(TestCaseID).getCell(2).toString();
	 * TestData[1]=sheet.getRow(TestCaseID).getCell(3).toString();
	 * TestData[2]=sheet.getRow(TestCaseID).getCell(4).toString();
	 * 
	 * System.out.println(TestData);
	 * 
	 * return TestData;
	 * 
	 * }
	 */

	@SuppressWarnings("resource")
	@Test void POSTAPIVerification() throws IOException, ParseException 
	{
			

		FileInputStream fs = new FileInputStream("C:\\Users\\4482E\\Desktop\\New folder\\TESTDATA.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("API");

		TestData[0]=sheet.getRow(1).getCell(2).toString();
		TestData[1]=sheet.getRow(1).getCell(3).toString();
		TestData[2]=sheet.getRow(1).getCell(4).toString();
		System.out.println(TestData[2]);

		RestAssured.baseURI=TestData[0];
		System.out.println(TestData[0]);
		
		RequestSpecification Getrequest = RestAssured.given(); 
		
		JSONParser testobj = new JSONParser();
		
		JSONObject RequestBody = (JSONObject) testobj.parse(TestData[2]);
		
		Getrequest.header("Content-Type","application/json");
		
		Getrequest.body(RequestBody.toString());
		

		Response response = Getrequest.request(Method.POST);
		
		ResponseBody resobj =  response.getBody();

		//APIKEY= response.jsonPath().get("apiKey");

		System.out.println(resobj.asString());

	}


}


