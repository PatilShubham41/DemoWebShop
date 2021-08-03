package page.utilities;

public class Utilities {

	public static String randomStringGenerator(int length) {
		StringBuffer result = new StringBuffer();

		String genString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < length; i++) {
			
			result.append(genString.charAt((int)(Math.random()*genString.length())));
		}

		return result.toString();
	}

}
