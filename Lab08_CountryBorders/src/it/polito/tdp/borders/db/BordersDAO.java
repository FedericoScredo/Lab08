package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {
	
	List<Country> paesi=new ArrayList<Country>();

	public List<Country> loadAllCountries() {

		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {
				paesi.add(new Country(rs.getInt("ccode"),rs.getString("StateAbb"),rs.getString("StateNme")));
			}

			conn.close();
			return paesi;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		
		List<Border> confini = new ArrayList<Border>();
		
		//if (anno!=2006){
			
			String sql1 = "SELECT * FROM contiguity WHERE year=? AND conttype=1";

			try {
				
				Connection conn = DBConnect.getInstance().getConnection();
				PreparedStatement st = conn.prepareStatement(sql1);
				st.setInt(1,anno);
				ResultSet rs = st.executeQuery();
				
				//System.out.println("query eseguita");

				while (rs.next()) {
					//System.out.println("entrato");
					confini.add(new Border(rs.getInt("state1no"),rs.getInt("state2no"),rs.getInt("year"),rs.getInt("conttype")));
				}

				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Database Error -- loadAllCountries");
				throw new RuntimeException("Database Error");
			}
			
//		}
		
//		if (anno==2006){
//			
//			String sql2 = "SELECT * FROM contiguity2006 WHERE conttype=1";
//
//			try {
//				Connection conn = DBConnect.getInstance().getConnection();
//				PreparedStatement st = conn.prepareStatement(sql2);
//				ResultSet rs = st.executeQuery();
//				
//				//System.out.println("query eseguita");
//				
//				while (rs.next()) {
//					//System.out.println("entrato");
//					confini.add(new Border(rs.getInt("state1no"),rs.getInt("state2no"),rs.getInt("year"),rs.getInt("conttype")));
//				}
//
//				conn.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("Database Error -- loadAllCountries");
//				throw new RuntimeException("Database Error");
//			}
//			
//		}
		
		return confini;
	}
	
}
