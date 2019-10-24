package MAC_Facility.data;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MAC_Facility.model.Facility;
import MAC_Facility.model.MARForm;
import MAC_Facility.util.SQLConnection;




public class FacilityDAO {
static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<Facility> ReturnMatchingCompaniesList (String queryString, String action) {
		//ArrayList<Facility> FacilityListInDB = new ArrayList<Facility>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<Facility> FacilityListInDB = new ArrayList<Facility>();
		try {
			stmt = conn.createStatement();
			ResultSet companyList = stmt.executeQuery(queryString);
			if(action.equalsIgnoreCase("listfacilities")) {
				
				while (companyList.next()) {
					Facility fac = new Facility(); 
					fac.setIDFacility(companyList.getString("idfacility"));
					fac.setFacility_name(companyList.getString("facility_name"));
					fac.setType(companyList.getString("Type"));
					fac.setVenue(companyList.getString("Duration"));  
					FacilityListInDB.add(fac);	
				}
				
				return FacilityListInDB;
				
			}
		} catch (SQLException e) {}
		
		return FacilityListInDB;
		
	}
	private static ArrayList<MARForm> ReturnMatchingMAR (String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<MARForm> mar_list = new ArrayList<MARForm>();
		try {
			stmt = conn.createStatement();
			ResultSet companyList = stmt.executeQuery(queryString);
			while (companyList.next()) {
					MARForm mar = new MARForm();
					mar.setFacility_name(companyList.getString("facility_name"));
					mar.setFacility_type(companyList.getString("facility_type"));
					mar.setDescription(companyList.getString("description"));
					mar.setReportedBy(companyList.getString("reported_by"));
					mar.setFacility_name(companyList.getString("facility_name"));
					mar.setDate(companyList.getString("date"));
					mar.setTime(companyList.getString("time"));
					mar.setAssigned_to(companyList.getString("assigned_to"));
					mar.setMar(companyList.getString("mar_number"));
					
					mar_list.add(mar);
				}
		} catch (SQLException e) {}
		return mar_list;
	}
	private static void StoreListinDB (Facility facility,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertfacility = queryString + " VALUES ('"  
					+ facility.getIDFacility()  + "','"
					+ facility.getfacility_name() + "','"		
					+ facility.getDuration() + "','"
					+ facility.getType() + "',"
					+ " SYSDATE())";
			stmt.executeUpdate(insertfacility);	
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void ADDFacility(Facility facility) {  
		StoreListinDB(facility,"INSERT INTO FACILITY (idfacility,Name,Duration,Type) ");
	} 
	
	public static ArrayList<Facility>  listfacilities() {  
			return ReturnMatchingCompaniesList(" SELECT * from FACILITY", "listfacilities");
	}
	
	//search companies
	public static ArrayList<Facility>  searchfacilities(String facility_name)  {  
		//	return ReturnMatchingCompaniesList(" SELECT * from FACILITY WHERE Name LIKE '%"+facility_name+"%' ORDER BY idfacility", "");
		return null;
	}
	
	//determine if companyID is unique
	public static Boolean FacilityUniqueID(String idFacility)  {  
			//return (ReturnMatchingCompaniesList(" SELECT * from  WHERE idfacility = '"+idFacility+"' ORDER BY Name").isEmpty(), "");
			return null;
	}
	//search company with company ID
	public static ArrayList<Facility>   searchfacility (String idfacility)  {  
			//return ReturnMatchingCompaniesList(" SELECT * from FACILITY WHERE idfacility = '"+idfacility+"' ORDER BY Name");
		return  null;
	}
	public static ArrayList<MARForm> searchMAR(String searchMAR){
		return ReturnMatchingMAR("SELECT * from mar_details");
		
	}
	
	public static ArrayList<MARForm> searchAssignedMAR(){
		return ReturnMatchingMAR("SELECT * from mar_details WHERE assigned_to is not null ");
		
	}
	
	public static ArrayList<Facility> assignedMAR(){
		//return ReturnMatchingCompaniesList("SELECT * from mar_details WHERE assigned_to is not null", "assignedMAR");
		return null;
	}

}

