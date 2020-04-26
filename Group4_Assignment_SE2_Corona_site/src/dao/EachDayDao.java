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
import model.EachDay;

public class EachDayDao {
	
	public ArrayList<EachDay> getAllVietNamDays() throws SQLException, IOException {
		ArrayList<EachDay> alldaysVn = new ArrayList<EachDay>();
		HttpURLConnection connnectToEachDay = DbConnect.getConnectionEachday("");
		connnectToEachDay.setRequestMethod("GET");
		connnectToEachDay.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connnectToEachDay.getInputStream()));
		if (connnectToEachDay.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connnectToEachDay.getResponseCode());
		}
		String output = convertToString(in);
		JSONArray days = new JSONArray(output);
		for(int i = 0; i < days.length();i++) {
			JSONObject day = days.getJSONObject(i);
			String date = day.getString("date");
			double cases = day.getDouble("cases");
			double recovered = day.getDouble("recovered");
			double deaths = day.getDouble("deaths");
			EachDay eD = new EachDay(date, cases, recovered, deaths);
			alldaysVn.add(eD);
		}
			
		return alldaysVn;
	}

	public void updateASpecificDay( double cases, double recovered, double deaths) throws SQLException, IOException {
		HttpURLConnection connnectToEachDay = DbConnect.getConnectionEachday("?"
				+"cases="+cases
				+"&recovered"+recovered
				+"&deaths="+deaths);
		connnectToEachDay.setRequestMethod("POST");
		connnectToEachDay.setRequestProperty("Accept", "application/json");
		if (connnectToEachDay.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connnectToEachDay.getResponseCode());
		}
	}
	public void insertAday(String date, double cases, double recovered, double deaths) throws SQLException, IOException {
		HttpURLConnection connnectToEachDay = DbConnect.getConnectionEachday("?"
				+"&cases="+cases
				+"&recovered"+recovered
				+"&deaths="+deaths);
		connnectToEachDay.setRequestMethod("PUT");
		connnectToEachDay.setRequestProperty("Accept", "application/json");
		if (connnectToEachDay.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connnectToEachDay.getResponseCode());
		}
	}
	public void updateDataInEachDayTable() throws IOException, SQLException {
		HttpURLConnection connnectToEachDay = DbConnect.getConnectionEachday("/updatevndays");
		connnectToEachDay.setRequestMethod("POST");
		connnectToEachDay.setRequestProperty("Accept", "application/json");
		if (connnectToEachDay.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connnectToEachDay.getResponseCode());
		}
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

