package wky.java.base.io.search;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class SearchFiles {
    public void SearchWithFileUtils(String path) throws IOException {
    	Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"java"}, true);
    	for (File f : files) {
    		System.out.println(f.getCanonicalPath());
    	}
        
    }
    
    public void SearchWithFileUtilsIOFilter(String path) {
    	Collection<File> files = FileUtils.listFiles(new File(path), new IOFileFilter(){

			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return true;
			}

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return true;
			}}, new IOFileFilter(){

				public boolean accept(File file) {
					// TODO Auto-generated method stub
					return true;
				}

				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return true;
				}});
    	
    	for (File f : files) {
    		try {
				System.out.println(f.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
}
