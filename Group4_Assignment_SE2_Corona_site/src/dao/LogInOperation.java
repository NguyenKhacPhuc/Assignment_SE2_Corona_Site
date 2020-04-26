package dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import dbConnect.DbConnect;

public class LogInOperation {
	
	public static String LogIn(String username,String password) throws IOException {
		HttpURLConnection connectToLogIn = DbConnect.getConnectionToLogIn("?"
				+ "username="+username
				+"&password="+password);
		connectToLogIn.setRequestMethod("GET");
		connectToLogIn.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToLogIn.getInputStream()));
		if (connectToLogIn.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToLogIn.getResponseCode());
		}
		return convertToString(in);
	}
	private static String convertToString(InputStream in) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	      StringBuilder sb = new StringBuilder();
	      String line;
	      try {
	         while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	        	 in.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	        
	      return sb.toString();
	   }
}
