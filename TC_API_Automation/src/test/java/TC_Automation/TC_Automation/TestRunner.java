package TC_Automation.TC_Automation;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestRunner {

	static String VelsoURL ="https://velso.thyrocare.cloud";
	static String APIKEY;


	@SuppressWarnings("unchecked")
	@Test
	void GetAccessToken()
	{
		//Specify The Base URL
		RestAssured.baseURI=VelsoURL+"/api/Login/Login";
		RequestSpecification Getrequest = RestAssured.given();		
		JSONObject RequestBody = new JSONObject();	

		RequestBody.put("UserName","9004844180");
		RequestBody.put("Password","123456");
		RequestBody.put("userType","DSA");
		RequestBody.put("portalType","DSA");

		Getrequest.header("Content-Type","application/json");

		Getrequest.body(RequestBody.toJSONString());

		Response response = Getrequest.request(Method.POST);

		APIKEY= response.jsonPath().get("apiKey");

		System.out.println(APIKEY);

	}



}


