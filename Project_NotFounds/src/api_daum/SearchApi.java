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
	public JSONArray Search(String keyword) {
		URL url;
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
			url = new URL("https://apis.daum.net/search/book?apikey=4bf34929379c7dab382bce4cd8177383&output=json&q="
					+ keyword);
			// �븳湲� 泥섎━瑜� �쐞�빐 InputStreamReader瑜� UTF-8 �씤肄붾뵫�쑝濡� 媛먯떬�떎.
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			// parse
			// 硫붿냼�뱶
			JSONObject object = (JSONObject) JSONValue.parseWithException(isr);
			// 媛앹껜
			JSONObject channel = (JSONObject) (object.get("channel"));
			// item 諛곗뿴
			JSONArray items = (JSONArray) channel.get("item");
			return items;
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
