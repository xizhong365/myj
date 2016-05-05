package wky.java.base.io;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class TestByteStream {

	String path;
	String inByteFileName;
	String outByteFileName;
	
	
	@Before
	public void init() throws URISyntaxException{
		this.path = getClass().getClassLoader().getResource(".").getPath();
		
		this.inByteFileName = this.path + "bytes_in.docx";
		this.outByteFileName = this.path + "bytes_out.docx";
		
		System.out.println(getClass().getResource("/bytes_in.docx").toString());
		System.out.println(this.inByteFileName);
	}
	
	@Test
	public void testByteCopy() throws IOException{
		ByteStream.copyBytes(this.inByteFileName, this.outByteFileName);
		
	}
	
}
