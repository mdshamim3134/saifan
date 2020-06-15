package allBasic;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class Rast {
	
	RequestSpecification request;
	Response rs;
	int port=444;
	@Test
	public void rest() throws InterruptedException {
	request=RestAssured.given();
	Builder coo=new Cookie.Builder("");
	coo.setMaxAge(0);
	coo.setComment("");
	coo.setPath("");
	request.port(port).cookie("").when().get("");
	request.contentType(ContentType.JSON);
	
    
	JSONObject json=new JSONObject();
	json.put("uname", "num");
	json.put("email", "num1");
	json.put("uname", "num2");
	json.put("email", "num3");
	json.put("email", "num40");
	
	request.body(json.toString());
	 rs=request.post("http://dummy.restapiexample.com/api/v1/create");
	
	Thread.sleep(2000);
	int code=rs.getStatusCode();
	System.out.println("status code is :"+code);
	 String body=rs.getBody().asString();
	 System.out.println("body is:"+body);
Cookies co=	rs.getDetailedCookies();
	co.getValue("");
Cookie k=rs.getDetailedCookie("");
k.getMaxAge();
k.getName();
k.getPath();



	}
	
	

}
