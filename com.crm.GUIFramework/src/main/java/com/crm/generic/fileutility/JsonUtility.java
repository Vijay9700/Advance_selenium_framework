package com.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws IOException, ParseException
	{
		FileReader file=new FileReader("./ConfifAppData/commondata.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(file);
		JSONObject map=(JSONObject)obj;
		return (String) map.get(key);
	}

}
