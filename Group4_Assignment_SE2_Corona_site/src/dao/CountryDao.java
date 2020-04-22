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
import model.Country;

public class CountryDao {
	public CountryDao() throws IOException, SQLException {
		
	}
	public void updateAllCountry() throws IOException, SQLException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/automaticupdatecountries");
		System.out.println(connectToCountry.toString());
		connectToCountry.setRequestMethod("POST");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
	}
	public ArrayList<Country> selectAllCountry() throws IOException{
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/displayall");
		ArrayList<Country> cLst = new ArrayList<Country>();
		connectToCountry.setRequestMethod("GET");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
		InputStream in = new BufferedInputStream(
			    (connectToCountry.getInputStream()));
		
		String output = convertToString(in);
		JSONArray countriesStatistic = new JSONArray(output);
		for(int i = 0; i<countriesStatistic.length();i++) {
			JSONObject o = countriesStatistic.getJSONObject(i);
			String country = o.getString("country");
			double newConfirmed = o.getDouble("newConfirmed");
			double totalConfirmed = o.getDouble("totalConfirmed");
			double newDeaths = o.getDouble("newDeaths");
			double totalDeaths = o.getDouble("totalDeaths");
			double newRecovered = o.getDouble("newRecovered");
			double totalRecovered = o.getDouble("totalRecovered");
			String date = o.getString("Date");
			String countryCode = o.getString("countryCode");
			Country c = new Country(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
			cLst.add(c);
		}
		return cLst;
}
	public Country selectVietNamCurrent() throws SQLException, IOException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/vietnamnow");
		connectToCountry.setRequestMethod("GET");
		connectToCountry.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToCountry.getInputStream()));
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
		String output = convertToString(in);
		JSONObject vn = new JSONObject(output);
		String country = vn.getString("country");
		double newConfirmed = vn.getDouble("newConfirmed");
		double totalConfirmed = vn.getDouble("totalConfirmed");
		double newDeaths = vn.getDouble("newDeaths");
		double totalDeaths = vn.getDouble("totalDeaths");
		double newRecovered = vn.getDouble("newRecovered");
		double totalRecovered = vn.getDouble("totalRecovered");
		String date = vn.getString("Date");
		String countryCode = vn.getString("countryCode");
		Country c = new Country(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		return c;
	}
	public Country selectCustomCountry(String cD) throws SQLException, IOException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/specificcountry?country="+cD);
		connectToCountry.setRequestMethod("GET");
		connectToCountry.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToCountry.getInputStream()));
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
		String output = convertToString(in);
		JSONObject vn = new JSONObject(output);
		String country = vn.getString("country");
		double newConfirmed = vn.getDouble("newConfirmed");
		double totalConfirmed = vn.getDouble("totalConfirmed");
		double newDeaths = vn.getDouble("newDeaths");
		double totalDeaths = vn.getDouble("totalDeaths");
		double newRecovered = vn.getDouble("newRecovered");
		double totalRecovered = vn.getDouble("totalRecovered");
		String date = vn.getString("Date");
		String countryCode = vn.getString("countryCode");
		Country c = new Country(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		return c;
	}
	public void createCountry(String country, double newConfirmed, double totalConfirmed, double newDeaths, double totalDeaths,
			double newRecovered, double totalRecovered, String date,String countryCode) throws SQLException, IOException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/createcountry?"
				+ "country="+country
				+"&newconfirmed="+newConfirmed
				+"&totalconfirmed="+totalConfirmed
				+"&newdeaths="+newDeaths
				+"&totaldeaths="+totalDeaths
				+"&newrecovered="+newRecovered
				+"&totalrecovered="+totalRecovered
				+"&date="+date
				+"countrycode="+countryCode);
		connectToCountry.setRequestMethod("POST");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
	}
	
	public void deleteCountry(String cD) throws SQLException, IOException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/deletecountry?countrycode="+cD);
		connectToCountry.setRequestMethod("POST");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
	}
	public void updateSpecificCountry(String country, double newConfirmed, double totalConfirmed, double newDeaths, double totalDeaths,
			double newRecovered, double totalRecovered, String date,String countryCode) throws SQLException, IOException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/updateacountry?"
				+ "country="+country
				+"&newconfirmed="+newConfirmed
				+"&totalconfirmed="+totalConfirmed
				+"&newdeaths="+newDeaths
				+"&totaldeaths="+totalDeaths
				+"&newrecovered="+newRecovered
				+"&totalrecovered="+totalRecovered
				+"&date="+date
				+"countrycode="+countryCode);
		connectToCountry.setRequestMethod("POST");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
	}
	// only use when country in the table is empty
	public void insertAllCountry() throws IOException, SQLException {
		HttpURLConnection connectToCountry = DbConnect.getConnectionCountry("/automaticinsertallcountry");
		connectToCountry.setRequestMethod("POST");
		connectToCountry.setRequestProperty("Accept", "application/json");
		if (connectToCountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToCountry.getResponseCode());
		}
}
	public void insertACountry(String country, double newConfirmed, double totalConfirmed, double newDeaths, double totalDeaths,
			double newRecovered, double totalRecovered, String date,String countryCode) throws SQLException, IOException {
		HttpURLConnection insertACountry = DbConnect.getConnectionCountry("/createcountry?"
				+ "country="+country
				+"&newconfirmed="+newConfirmed
				+"&totalconfirmed="+totalConfirmed
				+"&newdeaths="+newDeaths
				+"&totaldeaths="+totalDeaths
				+"&newrecovered="+newRecovered
				+"&totalrecovered="+totalRecovered
				+"&date="+date
				+"countrycode="+countryCode);
		insertACountry.setRequestMethod("POST");
		insertACountry.setRequestProperty("Accept", "application/json");
		if (insertACountry.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + insertACountry.getResponseCode());
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