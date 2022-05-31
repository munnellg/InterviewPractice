package ie.munnellg.interview;

public class UrlEncoder {

	public static void encode(char[] url, int end) {

		for (int p = url.length - 1, j = end - 1; j >= 0; j--, p--) {

			if (url[j] == ' ') {
				url[p--] = '0';
				url[p--] = '2';
				url[p] = '%';
			} else {
				url[p] = url[j];
			}
		}
	}
}
