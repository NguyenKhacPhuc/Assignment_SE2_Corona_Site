package dao;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dbConnect.DbConnect;
import model.WorldGeneral;

public class WorldGeneralDao {
	
	public void autoUpdateCurrentWorldGeneral() throws IOException  {
		HttpURLConnection connectToUpdateWorlGeneral = DbConnect.getConnectionWorldGeneral("/autoupdateworldgeneral");
		connectToUpdateWorlGeneral.setRequestMethod("POST");
		connectToUpdateWorlGeneral.setRequestProperty("Accept", "application/json");
		if (connectToUpdateWorlGeneral.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUpdateWorlGeneral.getResponseCode());
		}
	}
	public ArrayList<WorldGeneral> getHistoricalWorldGeneral() throws IOException {
		ArrayList<WorldGeneral> worldGenerlLst = new ArrayList<>();
		HttpURLConnection connectToUpdateWorlGeneral = DbConnect.getConnectionWorldGeneral("/worldhistorycal");
		connectToUpdateWorlGeneral.setRequestMethod("GET");
		connectToUpdateWorlGeneral.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToUpdateWorlGeneral.getInputStream()));
		if (connectToUpdateWorlGeneral.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUpdateWorlGeneral.getResponseCode());
		}
		String output = convertToString(in);
		JSONArray world = new JSONArray(output);
		for(int i = 0; i <world.length();i++) {
			JSONObject worlDtb = world.getJSONObject(i);
			int iD = worlDtb.getInt("iD");
			String date = worlDtb.getString("date");
			int newConfirmed = worlDtb.getInt("newConfirmed");
			int totalConfirmed = worlDtb.getInt("totalConfirmed");
			int newDeaths = worlDtb.getInt("newDeaths");
			int totalDeaths =worlDtb.getInt("totalDeaths");
			int newRecovered =worlDtb.getInt("newRecovered");
			int totalRecovered =worlDtb.getInt("totalRecovered");
			WorldGeneral wg = new WorldGeneral(iD, date, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered);
			worldGenerlLst.add(wg);
			
		}
		return worldGenerlLst;
	}
	public WorldGeneral getCurrentWorldGeneral() throws IOException {
		WorldGeneral wG = new WorldGeneral(0,"",0,0,0,0,0,0);
		HttpURLConnection connectToUpdateWorlGeneral = DbConnect.getConnectionWorldGeneral("");
		connectToUpdateWorlGeneral.setRequestMethod("GET");
		connectToUpdateWorlGeneral.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToUpdateWorlGeneral.getInputStream()));
		if (connectToUpdateWorlGeneral.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToUpdateWorlGeneral.getResponseCode());
		}
		String output = convertToString(in);
		JSONObject world = new JSONObject(output);
		
		wG.setId(world.getInt("iD"));
		wG.setDate(world.getString("date"));
		wG.setNewConfirmed(world.getInt("newConfirmed"));
		wG.setTotalConfirmed(world.getInt("totalConfirmed"));
		wG.setNewDeaths(world.getInt("newDeaths"));
		wG.setTotalDeaths(world.getInt("totalDeaths"));
		wG.setNewRecovered(world.getInt("newRecovered"));
		wG.setTotalRecovered(world.getInt("totalRecovered"));
		return wG;
	
}
	public void updateWorldGeneralManually(String date,int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths, int newRecovered,
			int totalRecovered) throws IOException  
	{
		HttpURLConnection connectToWorldGeneral = DbConnect.getConnectionWorldGeneral("?"
				+ "date="+date
				+"&newconfirmed="+newConfirmed
				+"&totalconfirmed="+totalConfirmed
				+"&newdeaths="+newDeaths
				+"&totaldeaths="+totalDeaths
				+"&newrecovered="+newRecovered
				+"&totalrecovered="+totalRecovered);
		connectToWorldGeneral.setRequestMethod("POST");
		connectToWorldGeneral.setRequestProperty("Accept", "application/json");
		if (connectToWorldGeneral.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToWorldGeneral.getResponseCode());
		}
	}
	public void insertWorldGeneralManually(int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths, int newRecovered,
			int totalRecovered) throws IOException {
		HttpURLConnection connectToWorldGeneral = DbConnect.getConnectionWorldGeneral("?"
				+"newconfirmed="+newConfirmed
				+"&totalconfirmed="+totalConfirmed
				+"&newdeaths="+newDeaths
				+"&totaldeaths="+totalDeaths
				+"&newrecovered="+newRecovered
				+"&totalrecovered="+totalRecovered);
		connectToWorldGeneral.setRequestMethod("PUT");
		connectToWorldGeneral.setRequestProperty("Accept", "application/json");
		if (connectToWorldGeneral.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToWorldGeneral.getResponseCode());
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