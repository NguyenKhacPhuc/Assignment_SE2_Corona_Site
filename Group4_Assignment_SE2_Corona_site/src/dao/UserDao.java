package dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dbConnect.DbConnect;
import model.User;

public class UserDao {
	
//	public ArrayList<User> getAllUser() throws SQLException, IOException{
//		HttpURLConnection connectToUser = DbConnect.getConnectionUser("");
//		ArrayList<User> userList = new ArrayList<User>();
//		connectToUser.setRequestMethod("GET");
//		connectToUser.setRequestProperty("Accept", "application/json");
//		InputStream in = new BufferedInputStream(
//			    (connectToUser.getInputStream()));
//		if (connectToUser.getResponseCode() != 200) {
//		    throw new RuntimeException("Failed : HTTP error code : "
//		            + connectToUser.getResponseCode());
//		}
//		String output = convertToString(in);
//		JSONArray allUser = new JSONArray(output);
//		for(int i =0;i<allUser.length();i++) {
//			JSONObject userO = allUser.getJSONObject(i);
//			int iD = userO.getInt("iD");
//			String name = userO.getString("username");
//			String password = userO.getString("password");
//			String email = userO.getString("email");
//			int age = userO.getInt("age");
//			String dob = userO.getString("dob");
//			User user = new User(name,password,email,age,dob);
//			user.setiD(iD);
//			userList.add(user);
//		}
//		return userList;
//	}
	public void createUser(String username, String password, String email, int age, String dob) throws SQLException, IOException {
		HttpURLConnection connectToUser = DbConnect.getConnectionUser("?"
				+ "username="+username
				+ "&password="+password
				+ "&email="+email
				+ "&age="+age
				+ "&dob="+dob);
		connectToUser.setRequestMethod("PUT");
		connectToUser.setRequestProperty("Accept", "application/json");
		if (connectToUser.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUser.getResponseCode());
		}
	}
	public void deleteUser(int id) throws SQLException, IOException {
		HttpURLConnection connectToUser = DbConnect.getConnectionUser("?ID="+id);
		connectToUser.setRequestMethod("DELETE");
		connectToUser.setRequestProperty("Accept", "application/json");
		if (connectToUser.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUser.getResponseCode());
		}
	}
	public ArrayList<User> searchUser(String name) throws SQLException, IOException {
		HttpURLConnection connectToUser = DbConnect.getConnectionUser("?username="+name);
		ArrayList<User> userList = new ArrayList<User>();
		connectToUser.setRequestMethod("GET");
		connectToUser.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToUser.getInputStream()));
		if (connectToUser.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUser.getResponseCode());
		}
		String output = convertToString(in);
		JSONArray allUser = new JSONArray(output);
		for(int i =0;i<allUser.length();i++) {
			JSONObject userO = allUser.getJSONObject(i);
			int iD = userO.getInt("iD");
			String username = userO.getString("username");
			String password = userO.getString("password");
			String email = userO.getString("email");
			int age = userO.getInt("age");
			String dob = userO.getString("dob");
			User user = new User(username,password,email,age,dob);
			user.setiD(iD);
			userList.add(user);
		}
		return userList;
	}
	public void updateUser(int iD,String username, String password, String email, int age, String dob) throws SQLException, IOException {
		HttpURLConnection connectToUser = DbConnect.getConnectionUser("?"
				+ "iD="+iD
				+"&username="+username
				+"&password="+password
				+"&email="+email
				+"&age="+age
				+"&dob="+dob);
		connectToUser.setRequestMethod("POST");
		connectToUser.setRequestProperty("Accept", "application/json");
		if (connectToUser.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUser.getResponseCode());
		}
	}
	public User getUserByID(int ID) throws IOException {
		HttpURLConnection connectToUser = DbConnect.getConnectionUser("/searchuserbyid?ID="+ID);
		connectToUser.setRequestMethod("GET");
		connectToUser.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToUser.getInputStream()));
		
		if (connectToUser.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUser.getResponseCode());
		}
		String result = convertToString(in);
		JSONObject rs = new  JSONObject(result);
		String name1 = rs.getString("username");
		String password = rs.getString("password");
		String email = rs.getString("email");
		int age = rs.getInt("age");
		String dob = rs.getString("dob");
		 
		User u = new User(name1,password,email,age,dob);
		return u;
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
