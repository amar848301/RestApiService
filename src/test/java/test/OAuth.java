package test;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.Base;

public class OAuth extends Base {
	
	public static int client_id;
	public static String access_token;
	
	@Test
	public void oauthToken() throws IOException
	{
		initilizeService("uid", "9988776655");
		Response resp = utility.Base.request.post("/oauth");
		String response = resp.asString();
		
		JsonPath js = new JsonPath(response);
		client_id = js.getInt("client_id");
		access_token = js.get("access_token");
		System.out.println("client_id : " +client_id+ "\n" + "access_token : " +access_token);
	}
}
