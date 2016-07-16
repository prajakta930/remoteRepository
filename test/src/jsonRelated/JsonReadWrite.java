package jsonRelated;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonReadWrite {

    public static void main(String[] args) {
	
    	System.out.println("changed");
	JSONObject obj = new JSONObject();
	obj.put("name" , "prajakta");
	obj.put("name", "sameer");
	
	JSONArray list = new JSONArray();
	list.add("I");
	list.add("love");
	list.add("you");
	
	obj.put("list", list);
	
	System.out.println(obj);
/*	try {

		FileWriter file = new FileWriter("c:\\test1.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}*/
    
    
    
    JSONParser parser = new JSONParser();
    
    try{
    	Object obj1 = parser.parse(new FileReader("c:\\test.json"));
    	JSONObject jsonObject = (JSONObject) obj1;
    	String name = (String) jsonObject.get("name");
    	System.out.println(name);
    	
    }catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

}
    }
