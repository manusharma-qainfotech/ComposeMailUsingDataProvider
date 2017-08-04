package Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import Model.locators;

public class SpecReader { 
  public	List<locators> list;

	public SpecReader() throws IOException {
		 String path=  System.getProperty("user.dir");
		FileReader reader = new FileReader(
				new File(path+"\\src\\test\\resources\\Test_data.spec"));

		BufferedReader bReader = new BufferedReader(reader);
		String line;
		list = new ArrayList<locators>();
		while ((line = bReader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line, "%");
			if (tokens.countTokens() == 3) {
				String elementName = tokens.nextElement().toString().trim();
				String locatorType = tokens.nextElement().toString().trim();
				String locatorValue = tokens.nextElement().toString().trim();
				locators obj = new locators(elementName,locatorType,locatorValue);
				list.add(obj);
			}
		}


	}
	public  locators getObjByElement(String element) {
		locators loc = null;
		Iterator<locators> itr = list.iterator();
		int flag = 0;

		while (itr.hasNext()) {
			loc = itr.next();
			String a = element;
			String b = loc.getElement();

			if (a.equalsIgnoreCase(b)) {
				return loc;
			}

		}
		return loc;

	}
	

}
