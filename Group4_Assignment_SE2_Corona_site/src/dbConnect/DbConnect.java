package dbConnect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DbConnect {
	private final static int host = 8888;
	private static String user = "http://localhost:"+host+ "/Assignment_Group4/user";
	private static String worldgeneral = "http://localhost:"+host+ "/Assignment_Group4/worldgeneral";;
	private static String eachday = "http://localhost:"+host+ "/Assignment_Group4/eachday";;
	private static String country = "http://localhost:"+host+ "/Assignment_Group4/country";
	private static String province = "http://localhost:"+host+ "/Assignment_Group4/province";
	
	public static HttpURLConnection getConnectionUser(String path) throws IOException {
		URL url = new URL(user+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
	public static HttpURLConnection getConnectionCountry(String tail) throws IOException {
		URL url = new URL(country+tail);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
	public static HttpURLConnection getConnectionEachday(String path) throws IOException {
		URL url = new URL(eachday+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
	public static HttpURLConnection getConnectionWorldGeneral(String path) throws IOException {
		URL url = new URL(worldgeneral+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
	public static HttpURLConnection getConnectionProvince(String path) throws IOException {
		URL url = new URL(province+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
}
