package api.req.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import api.req.endpoints.UserEndpoints;
import api.req.payload.Userres;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CreateUserTest {

	Userres user= new Userres();
	UserEndpoints userend;
	
	@BeforeClass
	public void setup()
	{
		user.setEmail("eve.holt@reqres.in");
		user.setPassword("pistol");
	}
	
	@Test(priority = 1)
	public void registeruser(ITestContext context)
	{
		Response resp=UserEndpoints.registrUsers(user);
		resp.then().log().all();
		int statuscode= resp.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		String body= resp.getBody().toString();
		String id=resp.jsonPath().get("id").toString();
		String token= resp.jsonPath().get("token");
		//System.out.println("Token"+token);
		//System.out.println(resp.jsonPath().get("id").toString());
		
	//	JSONObject json = new JSONObject(resp.toString());
		
		context.setAttribute("userid", id);
		
		
	}
	
	@Test(priority=2)
	public void deletedata(ITestContext context)
	{
		String id=(String) context.getAttribute("userid");
		Response resp=UserEndpoints.deleteUser(id);
		Assert.assertEquals(resp.getStatusCode(), 204);
		
	}
}
