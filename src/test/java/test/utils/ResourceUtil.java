package test.utils;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {

	public static String loadToString(String fileName) {

		InputStream inputStream = ResourceUtil.class.getClassLoader()
				.getResourceAsStream(fileName);

		StringBuilder out = new StringBuilder();
		byte[] b = new byte[4096];
		try {
			for (int n; (n = inputStream.read(b)) != -1;) {
				out.append(new String(b, 0, n, "UTF8"));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

}
