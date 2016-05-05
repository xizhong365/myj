package wky.java.base.classloader;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

/**
 * Each class will use its own classloader to load other classes. 
 * So if ClassA.class references ClassB.class then ClassB needs to be on the classpath of the classloader of ClassA, or its parents.
 * 
 * 
 * 理解Java ClassLoader机制 http://www.blogjava.net/lhulcn618/archive/2006/05/25/48230.html
 * */
public class TestClassPath {

	@Before
	public void init() {
		System.out.println("--------------------------");
	}

	@Test
	public void testBootstrapLoad() {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
	}

	@Test
	public void testTmp() {
		ClassLoader ldr = Thread.currentThread().getContextClassLoader();
		ldr = getClass().getClassLoader();

		System.out.println("java.home: " + System.getProperty("java.home"));

		/**
		 * Extensions Class Loader
		 * 
		 * Load from JAVA_HOME/jre/lib/ext or java.ext.dirs
		 */
		System.out.println("java.ext.dirs: " + System.getProperty("java.ext.dirs"));
		
		System.out.println("java.class.path: " + System.getProperty("java.class.path"));

		// Bootstrap Class Loader is native implement, it is null for jvm.
		ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("the parent of extension classloader : " + extensionClassloader.getParent());

		/**
		 * ClassLoader load resources.
		 * 
		 * 可以将图片等资源随同Class一同打包到jar类库中（当然，也可单独打包这些资源）并添加它们到class loader的搜索路径中，我们就可以无需关心这些资源的具体位置，让class loader来帮我们寻找
		 * */
		System.out.println(ClassLoader.getSystemResource("java/lang/String.class"));
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testLoadClassToJVM(){
		String str = new String();
		
		try {
			String str1 = (String)Class.forName("java.lang.String").newInstance();
			
			String str2 = (String)this.getClass().getClassLoader().loadClass("java.lang.String").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
