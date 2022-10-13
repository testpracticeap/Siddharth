package AssesementRest.RestAssemenet;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void getRequest() {
		RestAssured.given().baseUri("https://dummyjson.com/products").contentType(ContentType.JSON).when().get().then()
				.log().all();
	}

	@Test
	public void GetProductsDetailsHeaderResponse() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		Headers header = response.headers();

		for (Header headersec : header) {
			System.out.println("value " + headersec.getName() + " " + ":" + headersec.getValue());
		}
	}

	@Test
	public void GetProductsDetailsHeaderResponseoneAtaTime() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		String header = response.header("Server");
		System.out.println(header);
		String header1 = response.header("Content-Type");
		System.out.println(header1);

	}

	@Test
	public void GetProductsDetailsResponseBody() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		ResponseBody resbody = response.getBody();

		System.out.println(resbody.asString());

	}

//post
	@Test
	public void postRequestUsingStaticFile() {
		File jsonData = new File(
				"C:\\Users\\7000032450\\eclipse-workspace\\RestAssemenet\\src\\resources\\java\\json\\widget.json");

		RestAssured.given().baseUri("https://dummyjson.com/products").contentType(ContentType.JSON).body(jsonData)
				.when().post("/add").then().log().all().assertThat().statusCode(200);

	}

	// put request
	@Test
	public void putRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/resources/java/json/widget.json"));
		// convert byte array to string
		String bdy = new String(b);

		// base URL
		RestAssured.given()

				.baseUri("https://dummyjson.com").contentType(ContentType.JSON).body(bdy)

				// adding post method
				.when().put("/products/1").then().log().all()

				// verify status code as 201
				.assertThat().statusCode(200);

	}

	// Delete Request
	@Test
	public void deleteRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/resources/java/json/widget.json"));

		// convert byte array to string
		String bdy = new String(b);

		// base URL
		RestAssured.given()

				.baseUri("https://dummyjson.com").contentType(ContentType.JSON).body(bdy)

				// adding delete method
				.when().delete("/products/3").then().log().all()

				// verify status code as 201
				.assertThat().statusCode(200);
	}
}