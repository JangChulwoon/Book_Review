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
	// ����Ʈ�� ���� .. ������ ?

	public String[][] Search(String[][] value, String keyword) {
		URL url;
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
			url = new URL("https://apis.daum.net/search/book?apikey=66c51867d890a469e648e90c610bdcd5&output=json&q="
					+ keyword);
			// �ѱ� ó���� ���� InputStreamReader�� UTF-8 ���ڵ����� ���Ѵ�.
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			// parse
			// �޼ҵ�
			JSONObject object = (JSONObject) JSONValue.parseWithException(isr);
			// ��ü
			JSONObject channel = (JSONObject) (object.get("channel"));
			// item �迭
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
				// �� �����.. !
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
