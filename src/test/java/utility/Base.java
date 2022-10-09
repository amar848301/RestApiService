package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	public static RequestSpecification request;
	
	public void initilizeService(String key, String value) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\config\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		
		RestAssured.baseURI = prop.getProperty("uri");
		RequestSpecification req = new RequestSpecBuilder().addQueryParam(key, value).addHeader("Content-Type", "application/json").build();
		request = RestAssured.given().spec(req);
	}
}
