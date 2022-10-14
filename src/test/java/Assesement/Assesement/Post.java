package Assesement.Assesement;

import java.io.File;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Unit test for simple App.
 */
public class Post {

	@Test
	public void postmethod() throws JsonProcessingException {
		File jsonData = new File("C:/Users/7000032450/eclipse-workspace/Assesement/json/json1/data1.json");
		RestAssured.given()
				.header("Authorization", "Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
				.baseUri("https://gorest.co.in/public/v1/users").contentType(ContentType.JSON).body(jsonData).when()
				.post().then().log().all();
		// ObjectMapper=new ObjectMapper()
		// ObjectMapper MAPPER = new ObjectMapper();
		// String json=MAPPER.writeValueAsString(jsonData);
//	Response response = RestAssured.given()
//            .header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed").
//            contentType("application/json").
//            log().all().
//            body(json).
//            when().
//            post("https://gorest.co.in/public/v1/users").
//            andReturn();
//	String postresponse=response.toString();
//	JsonPath jpath=new JsonPath(postresponse);
//	jpath.get("e");
//	String str=jpath.getString("email");
		Response response2 = RestAssured.given()
				.header("Authorization", "Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
				.baseUri("https://gorest.co.in/public/v1/users").queryParam("email", "siddharth14@matrix.com").when()
				.get();
		System.out.println(response2.asString());

		io.restassured.path.json.JsonPath jsonpath = response2.jsonPath();

		String ID = jsonpath.getString("data[0].id");

		System.out.println(ID);
	}

}
