package wky.java.base.io.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TestFinder {

	@Test
	public void TestWalk() throws IOException{
		Finder finder = new Finder("*.java");
		Files.walkFileTree(Paths.get("."), finder);
		finder.done();
	}
}
