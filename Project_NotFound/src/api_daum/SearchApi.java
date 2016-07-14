package api_daum;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class SearchApi {
	// 리스트를 만들어서 .. 담을까 ?

	public String[][] Search(String[][] value, String keyword) {
		URL url;
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
			url = new URL("https://apis.daum.net/search/book?apikey=apikey&output=json&q="
					+ keyword);
			// 한글 처리를 위해 InputStreamReader를 UTF-8 인코딩으로 감싼다.
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			// parse
			// 메소드
			JSONObject object = (JSONObject) JSONValue.parseWithException(isr);
			// 객체
			JSONObject channel = (JSONObject) (object.get("channel"));
			// item 배열
			JSONArray items = (JSONArray) channel.get("item");
			int size = items.size() > 5 ? 5 : items.size();
			for (int i = 0; i < size; i++) {
				JSONObject obj1 = (JSONObject) items.get(i);
				value[i][0] = (String) obj1.get("title");
				value[i][0] = value[i][0].replaceAll("&lt;b&gt;", "").replaceAll("&lt;/b&gt;", "");
				value[i][1] = (String) obj1.get("cover_s_url");
				value[i][2] = (String) obj1.get("description");
				value[i][3] = (String) obj1.get("author");
				value[i][4] = (String) obj1.get("pub_date");
				value[i][5] = (String) obj1.get("pub_nm");
				// 다 지운다.. !
			}
			value[5][5] = "" + size;
			return value;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
