package wky.java.base.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class TestTmp {

	String fileName = "d:\\Dropbox\\1.txt";
	
	@Test
	public void fileExists(){
		// NIO
		Path p = Paths.get(fileName);
		
		assertTrue(Files.isRegularFile(p));
		assertTrue(Files.isReadable(p));
		
		// old IO
		assertTrue(new File(fileName).exists());
	}
	
	@Test
	public void test1() {
		Path p = Paths.get(fileName);

		System.out.println(p.getFileName());
		System.out.println(p.toAbsolutePath());
		
		System.out.println(this.getClass().getClassLoader().getResource(".").getPath());
	}
}
