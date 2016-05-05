package wky.java.base.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The Java™ Tutorials http://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 * http://tutorials.jenkov.com/java-io/index.html
 * 
 *  A stream is a continuous flow of data. A stream is a way of sequentially accessing a file. A byte stream access the file byte by byte. A byte stream is
 * suitable for any kind of file, however not quite appropriate for text files. For example, if the file is using a
 * unicode encoding and a character is represented with two bytes, the byte stream will treat these separately and you
 * will need to do the conversion yourself.
 */
public class ByteStream {
	
	public static void copyBytes(String inFile, String outFile) throws IOException {
		BufferedInputStream in = null;
		FileOutputStream out = null;

		try {
			// copy byte by byte
//			in = new FileInputStream(inFile);
			
			// Combining Streams: Read large block from disk. BufferedInputStream & BufferedOutputStream
			in = new BufferedInputStream(new FileInputStream(inFile));
			out = new FileOutputStream(outFile);
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
