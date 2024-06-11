import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public ComplexJsonParse() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		//print no of courses returned by api
		
	int count =	js.getInt("courses.size()");
	
	System.out.println(count);
	
	//print purchase amount
	
	int totalAmount = js.getInt("dashboard.purchaseAmount");
	
	System.out.println(totalAmount);
	
	//Print title of the first course
	
 String titlefirstcourse =	js.get("courses[0].title");
		
	System.out.println(titlefirstcourse);
	
	
	// print all courses titles and their respective prices
	
	for (int i =0; i<count;i++) {
		
	 String couresetitles = js.get("courses["+i+"].title");
	 System.out.println(js.get("courses["+i+"].price").toString());
		System.out.println(couresetitles);
	}
	
System.out.println("print no of copies sold by RPA course");

for(int i =0; i<count; i++) {
	
	String Coursetitle = js.get("courses["+i+"].title");
	if(Coursetitle.equalsIgnoreCase("RPA")) 
	{
		int copies = js.get("courses["+i+"].copies");
		System.out.println(copies);
		break;
	}
}

// verify if sum of all courses prices matches with purchase amount
	}

}
