package DbManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class DbMethods {
	static DbConnection db = new DbConnection();
	static Statement st = null;
	static ResultSet res = null;

	// created by Yamini Meka
	// Last 4 digits of id: 2765

	public static ArrayList listUserCourses(String username) {
		ArrayList listCourses = new ArrayList();
		try {
			st = db.getConnection().createStatement();
			res = st.executeQuery("select * from userCourses where username='"
					+ username + "'");
			while (res.next()) {
				listCourses.add(res.getString(1));
				listCourses.add(res.getString(2));
				listCourses.add(res.getString(3));
				listCourses.add(res.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCourses;
	}

	// created by Sai Kireety Kokkiligadda
	// Last 4 digits of id: 7714

	public static void addUserCourses(String username, String crn1,
			String crn2, String crn3) {
		// TODO Auto-generated method stub
		String query = "Insert into userCourses values('" + username + "','"
				+ crn1 + "','" + crn2 + "','" + crn3 + "')";
		try {
			st = db.getConnection().createStatement();
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}