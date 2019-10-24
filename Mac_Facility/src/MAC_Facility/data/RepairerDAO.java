package MAC_Facility.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MAC_Facility.model.Repairer;
import MAC_Facility.util.SQLConnection;


public class RepairerDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public ArrayList<Repairer> searchRepairer(String assignedTo) throws SQLException, ClassNotFoundException {
		Statement stmt = null;   
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = SQLConnection.getDBConnection();
		
		
		String query = "SELECT * FROM mac_facility.assigned_repairs where assignedTo = '"+assignedTo+"';";
		System.out.println("User Search Query ..."+query);
	      ArrayList<Repairer> repairerList=new ArrayList<Repairer>();  

		try {
			
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			System.out.println(results);
			
			while(results.next()) {
				Repairer repairer = new Repairer();

				repairer.setId(results.getString("idAssigned_Repairs"));
				repairer.setFacility_name(results.getString("facilityName"));
				repairer.setFacility_type(results.getString("facilityType"));
				repairer.setStartDate(results.getDate("startDate"));
				repairer.setStartTime(results.getString("startTime"));
				repairer.setFloor(results.getString("floor"));
				repairerList.add(repairer);
			}
			System.out.println(repairerList);

			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		

		finally {
			
			stmt.close();
			conn.close();
		}

		return repairerList;

	
	}

}
