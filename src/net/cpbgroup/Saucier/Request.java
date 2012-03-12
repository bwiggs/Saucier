package net.cpbgroup.Saucier;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class Request {

	private static Pattern p = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) - ([a-z]+) ([^ ]+) -> (\\d{3}) \\((\\d+).*", Pattern.CASE_INSENSITIVE);	
	public String dateTime, method;
	public URI uri;
	public HashMap<String, String> params = new HashMap<String, String>();
	public int statusCode, loadTime;

	public Request(String requestSummary) {

		try {
			// match against the sauceconnect output string
			Matcher m = p.matcher(requestSummary);
			m.matches();

			dateTime = m.group(1);
			method = m.group(2);
			uri = new URI(m.group(3));
			statusCode = Integer.parseInt(m.group(4));
			loadTime = Integer.parseInt(m.group(5));

			// breakdown the query params
			List<NameValuePair> queryParams = URLEncodedUtils.parse(uri, "utf8");
			for(NameValuePair p : queryParams) {
				params.put(p.getName(), p.getValue());	
			}

		} catch (Exception e) {
			System.out.println(requestSummary);
			e.printStackTrace();
		}
	}
}