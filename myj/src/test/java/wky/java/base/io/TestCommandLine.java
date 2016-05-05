package wky.java.base.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class TestCommandLine {

	@Test
	public void testCMDConsole() throws IOException, InterruptedException {
		// eclipse bug: System.console() (Java 6.0) returns null when running inside Eclipse
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		Console c = System.console();
		if (c != null) {
			String cmd = c.readLine("Enter cmd> ");
			char[] pwd = c.readPassword("Enter pwd:a> ");
			if (pwd.equals("a")) {
				processCmd(cmd);
			}
		} else {
			System.out.println("No Console.");

			Scanner in = new Scanner(System.in);
			System.out.println("Enter cmd> ");
			String cmd = in.nextLine();
			// System.out.println(cmd);

			processCmd(cmd);
		}
	}

	private void processCmd(String cmd) throws IOException, InterruptedException {
		String os = System.getProperty("os.name");
		System.out.println(os);

		Runtime rt = Runtime.getRuntime();
		Process p;

		if (os.toUpperCase().indexOf("WIN") < 0) {
			p = rt.exec(cmd);
		} else {
			p = rt.exec(new String[] { "cmd.exe", "/c", cmd });
		}
		p.waitFor();

		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "";
		while ((s = reader.readLine()) != null) {
			System.out.println(s);
		}
	}
}
