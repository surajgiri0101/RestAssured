import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public static void main(String[] args) {
		
		int sum =0;
		JsonPath js = new JsonPath(Payload.CoursePrice());
		int count =	js.getInt("courses.size()");
		for(int i =0; i<count;i++) {
			
			int prices = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int Amount = prices*copies;
			System.out.println(Amount);
            sum = sum + Amount;
		}
        System.out.println(sum);
        int purchaseamount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseamount);
	}

}
