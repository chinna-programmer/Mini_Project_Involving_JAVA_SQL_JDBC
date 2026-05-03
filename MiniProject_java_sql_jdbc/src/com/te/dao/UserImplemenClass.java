package com.te.dao;

import java.sql.*;
import java.util.Scanner;

import com.te.dta.UserAccount;
import com.te.utility.ConnectionUtility;

public class UserImplemenClass implements UserDao {
	
public static Scanner sc = new Scanner(System.in);

@Override
public String createTable() {
    String sql = "CREATE TABLE User (" +
                 " user_id INT AUTO_INCREMENT PRIMARY KEY, " +
                 " user_name VARCHAR(20), " +
                 " user_age INT, " +
                 " user_city VARCHAR(20)" +
                 ")";

    try (Connection con = ConnectionUtility.getConnection();
         Statement st = con.createStatement()) {

        st.executeUpdate(sql);
        return "User Table Created Successfully";

    }catch (Exception e) {
        e.printStackTrace();
        return "Table Failed to Create";
    }
}

	@Override
	public String insertData(UserAccount user) {
	  try(Connection con = ConnectionUtility.getConnection();
				PreparedStatement pstm = con.prepareStatement("Insert into User(user_name,user_age,user_city) values(?,?,?)")) {

		pstm.setString(1,user.getUser_name());
		pstm.setInt(2,user.getUser_age());
		pstm.setString(3,user.getUser_city());
		pstm.executeUpdate();
		return "UserData Inserted SuccessFully";
	  }catch(SQLException e ) {
		  e.printStackTrace();
		  return "Failed To Insert Data";
	  }
		
	}

	@Override
	public String updateAgeBasedOnUserId(UserAccount user) {

	try(	Connection con = ConnectionUtility.getConnection();
	PreparedStatement pstm = con.prepareStatement("update user set user_age = ? where user_id = ? ")) {
   
    pstm.setInt(2,user.getUser_id());
    pstm.setInt(1,user.getUser_age());
    int r1 = pstm.executeUpdate();
    if(r1>=1) {
    	return "--SuccessFully Updated--";
    }else {
    	 return  "--ID Not Exist--";
    }
		} catch (SQLException e) {
			e.printStackTrace();
			return "--ID Not Exist--";
		}
	}

	@Override
	public String deleteData(UserAccount user) {
	
		try (Connection con = ConnectionUtility.getConnection();
			PreparedStatement pstm = con.prepareStatement("Delete from user where user_id = ?")){
			
			pstm.setInt(1,user.getUser_id());
		int r1 =	pstm.executeUpdate();
		
		if(r1>=1) {
		return "--Data Deleted SuccessFully--";
		}else {
			return "--Id "+user.getUser_id()+" Not Exist--";
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return "--ID Not Exist--";
		}
	}

}
