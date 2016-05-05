package wky.java.base.serialization.bean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestLba {

	String lbaXml, path;

	@Before
	public void init() {
		System.out.println("-------------------");

		this.path = getClass().getClassLoader().getResource(".").getPath();
		this.lbaXml = this.path + "lba.xml";
	}

	@Test
	public void testLoadBean() throws FileNotFoundException {
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(this.lbaXml)));

		try {
			List<Lba> lbaList = (ArrayList<Lba>) d.readObject();
			
			System.out.println(lbaList);
		} finally {
			d.close();
		}
		
		
	}

	@Test
	/**
	 * XMLEncoder requires JavaBeans object to serialize it.
	 */
	public void testWriteBean() throws IOException {
		// Params: String shortName, String packageName, String prodShortCode,
		// String name, String parentShortCode, String familyShortCode,
		// String status, String fusionRelease, String shippingRelease, int type
		Lba obj = new Lba("HcmPayTop", "oracle.apps.hcm.payrolls", "PAY", "Payroll Repository", "HcmTop", "HCM",
				"APPROVED", "1", "1", 0);

		// XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new
		// FileOutputStream(this.path + "lba_out.xml")));
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(stream));

		try {
			e.writeObject(obj);
		} finally {
			e.close();
		}

		System.out.println(stream.toString());
		stream.close();

	}

}
