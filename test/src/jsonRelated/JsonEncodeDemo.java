package jsonRelated;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Downloaded JSONSIMPLE jar from https://code.google.com/archive/p/json-simple/ and added to Libraries-add external jars.
 * 
 *  JSON | Java | |:---------|:---------| | string | java.lang.String | | number | java.lang.Number | 
 *  | true|false | java.lang.Boolean | | null | null | | array | java.util.List | | object | java.util.Map |
 * */




public class JsonEncodeDemo {
	   public static void main(String[] args){
	      JSONObject obj = new JSONObject();

	      Object put = obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      System.out.print(obj);
	      

	      JSONParser parser = new JSONParser();
	      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
			
	      try{
	         Object obj1 = parser.parse(s);
	         JSONArray array = (JSONArray)obj1;
				
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj1 = parser.parse(s);
	         System.out.println(obj1);

	         s = "[5,]";
	         obj1 = parser.parse(s);
	         System.out.println(obj1);

	         s = "[5,,2]";
	         obj1 = parser.parse(s);
	         System.out.println(obj1);
	      }catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	   }
	   }
	   
}


