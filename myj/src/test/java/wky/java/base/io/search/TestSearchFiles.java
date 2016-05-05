package wky.java.base.io.search;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestSearchFiles {

	SearchFiles sf;

	@Before
	public void init() {
		sf = new SearchFiles();
	}

	@Test
	public void TestSearchWithFileUtils() throws IOException {

		sf.SearchWithFileUtils(".");
	}

	@Test
	public void TestSearchWithFileUtilsIOFilter() throws IOException {
		sf.SearchWithFileUtilsIOFilter(".");
	}

}
