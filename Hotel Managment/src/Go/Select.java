package Go;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	
	public static ResultSet getData(String query) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			
			con = DataBase.connection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			return rs;
			
			
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			return null;
			
		}
		
	}

}
