package dbConnect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DbConnect {
	private final static int host = 8888;
	private static String user = "http://localhost:"+host+ "/Assignment_Group4/user";
	private static String worldgeneral = "http://localhost:"+host+ "/Assignment_Group4/world";;
	private static String eachday = "http://localhost:"+host+ "/Assignment_Group4/vietnamdays";;
	private static String country = "http://localhost:"+host+ "/Assignment_Group4/country";
	private static String province = "http://localhost:"+host+ "/Assignment_Group4/province";
	private static String login = "http://localhost:"+host+ "/Assignment_Group4/login";
	
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
	public static HttpURLConnection getConnectionToLogIn(String path) throws IOException {
		URL url = new URL(login+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection;
	}
}
