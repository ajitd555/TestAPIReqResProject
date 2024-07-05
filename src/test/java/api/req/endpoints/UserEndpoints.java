package api.req.endpoints;

import static io.restassured.RestAssured.*;


import org.apache.logging.log4j.core.appender.routing.Route;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.req.endpoints.*;
import api.req.payload.Userres;

public class UserEndpoints {
	
	public static Response registrUsers(Userres payload)
	{
		Response resp= given().contentType(ContentType.JSON)
				.body(payload)
				.post(Routes.regitsrUser);
		
		return resp;
	}
	
	public static Response deleteUser(String id)
	{
		       Response res=given()
		    		        .pathParam("id", id)    
		    		        
				      .when()
				       .delete(Routes.deleteUser);
			return res;
	}

}
