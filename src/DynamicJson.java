import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	public static void main(String[] args) {
	
//	public void addBook() {
		
		RestAssured.baseURI= "https://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
		.body(Payload.Addbook()).when().log().all().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	
}}
