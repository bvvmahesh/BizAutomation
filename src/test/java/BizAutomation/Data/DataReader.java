package BizAutomation.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		// it will read/scan the entire json file and convert into a String Variable
		//1) Read Json to String
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\BizAutomation\\Data\\JSONDataFile.json"), StandardCharsets.UTF_8);
		
		
		//2) covert String to HashMap
		//jackson Databind will convert string to HashMap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
		
		//Finally we have a list of HashMaps created
		
	}

}
