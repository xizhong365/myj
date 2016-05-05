package wky.java.base.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
/**
 * Can it support complex property structure?
 * */
public class TestProperties {

	String fileName = getClass().getClassLoader().getResource("test.properties").getFile();
	String xmlFileName = getClass().getClassLoader().getResource("test.xml").getFile();
	Properties p;
	
	@Before
	public void init() throws FileNotFoundException, IOException{
		System.out.println("------------------");
		p = new Properties(); // F4
		p.load(new BufferedInputStream(new FileInputStream(fileName)));
	}
	
	@Test
	/**
	 * The Java™ Tutorials:System Properties http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
	 * */
	public void testSystemProperties(){
		System.out.println("java.home> "+System.getProperty("java.home"));
		p = System.getProperties();
		p.list(System.out);
	}
	
	@Test
	public void listProperties(){
		p.list(System.out);
	}
	
	@Test
	public void testLoadProperties() throws FileNotFoundException, IOException {
		
		if(p.containsKey("name") && p.containsValue("JJ"))
			System.out.println(p.getProperty("name")); // key is case sensitive.
		
		p.setProperty("add", "new_v");
		
		System.out.println(p.size());
		
		Enumeration<String> e = (Enumeration<String>) p.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = (String)p.get(key);
			System.out.println(key + " : " + value);
		}
	}
	
	@Test
	public void testLoadFromXML() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		Properties p = new Properties();
		p.loadFromXML(new BufferedInputStream(new FileInputStream(xmlFileName)));
		
		System.out.println(p.getProperty("driver"));
	}
	
//	@Test
	public void testJVMProperties(){
		Properties p = System.getProperties();
		p.list(System.out);
		
	}
}
