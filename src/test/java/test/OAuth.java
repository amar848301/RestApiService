package test;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.Base;

public class OAuth {
	
	@Test
	public void oauthToken() throws IOException
	{
		Base base = new Base();
		base.initilizeService("uid", "9988776655");
		Response resp = utility.Base.request.post("/oauth");
		String response = resp.asString();
		
		
		JsonPath js = new JsonPath(response);
		System.out.println("client_id : " +js.getInt("client_id")+ "\n" + "access_token : " +js.get("access_token"));
	}
}
