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
import model.VietNamProvinces;

public class VietNamProvinceDao {
	
	
	public void insertProvincesStatistic(String name, double confirmed, double underTreatment, double recovered, double deaths) throws IOException{
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/insertAllProvinces");
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
		if (connectToPtovince.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToPtovince.getResponseCode());
		}
	}
	public ArrayList<VietNamProvinces> selectAllProvinces() throws IOException {
		ArrayList<VietNamProvinces> allVNProvinces = new ArrayList<VietNamProvinces>();
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/displayall");
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
		InputStream in = new BufferedInputStream(
			    (connectToPtovince.getInputStream()));
		if (connectToPtovince.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToPtovince.getResponseCode());
		}
		String output = convertToString(in);
		JSONArray allProvinces = new JSONArray(output);
		for(int i = 0; i < allProvinces.length();i++) {
			JSONObject province = allProvinces.getJSONObject(i);
			String name = province.getString("name");
			double confirmed = province.getDouble("confirmed");
			double underTreatment = province.getDouble("underTreatment");
			double recovered = province.getDouble("recovered");
			double deaths = province.getDouble("deaths");
			String date  = province.getString("date");
			allVNProvinces.add(new VietNamProvinces(name, confirmed, underTreatment, recovered, deaths, date));
		}
		return allVNProvinces;
	}
	public void automaticUpdateProvinces() throws IOException, SQLException {
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/autoupdate");
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
}
	public void insertAProvince(String name, double confirmed, double underTreatment, double recovered, double deaths) throws  IOException {
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/insertavietnamprovince?"
				+ "name="+name
				+"&confirmed="+confirmed
				+"&undertreatment="+underTreatment
				+"&recovered="+recovered
				+"&deaths="+deaths);
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
		if (connectToPtovince.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToPtovince.getResponseCode());
		}
	}
	public void updateAProvince(String name, double confirmed, double underTreatment, double recovered, double deaths) throws  IOException {
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/updateaprovince?"
				+ "name="+name
				+"&confirmed="+confirmed
				+"&undertreatment="+underTreatment
				+"&recovered="+recovered
				+"&deaths="+deaths);
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
		if (connectToPtovince.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connectToPtovince.getResponseCode());
		}
	}
	public void deleteAprovince(String name) throws SQLException, IOException {
		HttpURLConnection connectToPtovince = DbConnect.getConnectionProvince("/deleteaprovince?name="+name);
		connectToPtovince.setRequestMethod("POST");
		connectToPtovince.setRequestProperty("Accept", "application/json");
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