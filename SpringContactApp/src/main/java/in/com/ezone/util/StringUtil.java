package in.com.ezone.util;

public class StringUtil {

	public static String toCommaSeparatedString(Object[] items) {

		StringBuilder stringBuilder = new StringBuilder();

		for (Object item : items) {

			stringBuilder.append(item).append(",");

		}

		if (stringBuilder.length() > 0) {

			stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		}

		return stringBuilder.toString();

	}

}
