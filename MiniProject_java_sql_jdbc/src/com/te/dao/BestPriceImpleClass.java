package com.te.dao;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.te.dta.BestPriceAccount;
import com.te.dta.UserAccount;
import com.te.utility.ConnectionUtility;

public class BestPriceImpleClass implements BestPriceDao {
     public static Scanner sc = new Scanner(System.in);
	@Override
	public String createTable() {
		try(Connection con = ConnectionUtility.getConnection();
			Statement st = con.createStatement()) {
			
			st.executeUpdate(
				    "CREATE TABLE BestPrice (" +
				    " bestPrice_id INT AUTO_INCREMENT PRIMARY KEY," +
				    " amount DECIMAL(10,2)," +
				    " product_purchased VARCHAR(30)," +
				    " user_id INT," +
				    " CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES User(user_id)" +
				    ")"
				);
			return "--BestPrice Table Created SuccessFully--";
		} catch (SQLException e) {
			e.printStackTrace();
			return "--Failed Create Table--";
		}
				
	}

	@Override
	public String insertData(BestPriceAccount mall) {
		try(Connection con = ConnectionUtility.getConnection()) {
			
     if(mall.userAccount.getUser_id()>0) {
    	 PreparedStatement pstm = con.prepareStatement("Insert into BestPrice(amount,product_purchased,user_id) "
 				+ "values(?,?,?)");
       pstm.setBigDecimal(1,mall.getAmount());
       pstm.setString(2,mall.getProductPurchased()); 
       pstm.setInt(3,mall.userAccount.getUser_id());
 	  pstm.executeUpdate();
 	  pstm.close();
 	  return "--BestPrice Data Inserted SuccessFully--";
     }else {
	  PreparedStatement pstm1 = con.prepareStatement("Insert into BestPrice(amount,product_purchased) "
				+ "values(?,?)");
	  pstm1.setBigDecimal(1,mall.getAmount());
	  pstm1.setString(2,mall.getProductPurchased()); 
	  pstm1.executeUpdate();
	  pstm1.close();
	  return "--BestPrice Data Inserted SuccessFully--";
     }
		    
		} catch (SQLException e) {
		       e.getMessage();
		       return "--BestPrice Data Failed To Insert--"+e.getMessage();
		}
	}

	@Override
	public String updataAmountBasedOnBestpriceId(BestPriceAccount bestPrice) {
		try(Connection con = ConnectionUtility.getConnection();
    PreparedStatement pstm = con.prepareStatement("update bestPrice set amount = ? where bestPrice_id = ? ")) {
    pstm.setBigDecimal(1,bestPrice.getAmount());
    pstm.setInt(2,bestPrice.getBestPrice_id());
    int r1 = pstm.executeUpdate();
    if(r1>=1) {
 	   return "--SuccessFully Updated--";
    }else {
 	   return "--ID Not Exist--";
    }
		} catch (SQLException e) {
			e.printStackTrace();
			return "--ID Not Exist--";
		}
	}

	@Override
	public String deleteData(BestPriceAccount bestPrice) {
		try(Connection con = ConnectionUtility.getConnection();
			PreparedStatement pstm = con.prepareStatement("Delete from bestPrice where bestPrice_id = ?")) {
		
			pstm.setInt(1, bestPrice.getBestPrice_id());
		int r1 =	pstm.executeUpdate();
		
		if(r1>=1) {
		   return "--Data Deleted SuccessFully--";
		}else {
			return "--ID Not Exist---";
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return "--ID Not Exist--";
		}
		
	}

	@Override
	public List<BestPriceAccount> readData() {
	boolean isNull = true;
	List<BestPriceAccount> list = new ArrayList<BestPriceAccount>();
		try {
			Connection con = ConnectionUtility.getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      String query="select * "
		  + "from User u \r\n"
	      + "inner join BestPrice b \r\n"
	      + "on u.user_id = b.user_id;";
	     ResultSet rs = st.executeQuery(query);
	     isNull= rs.first();
	     rs.beforeFirst();
	     while(rs.next()) {
	
//	    	  System.out.println(rs.getInt("user_id")+" | "+rs.getString("user_name")+" | "
//	    			  +rs.getInt("user_age")+" | "+rs.getString("user_city")+" | "+rs.getInt("bestPrice_id")
//	    			  +" | "+rs.getInt("user_Id")+" | "+rs.getBigDecimal("amount")+" | "+rs.getString("product_purchased"));
	    	 BestPriceAccount best = new BestPriceAccount();
	    	 best.userAccount = new UserAccount();
	    	 best.userAccount.setUser_id(rs.getInt("user_id"));
	    	 best.userAccount.setUser_name(rs.getString("user_name"));
	    	 best.userAccount.setUser_age(rs.getInt("user_age"));
	    	 best.userAccount.setUser_city(rs.getString("user_city"));
	     best.setBestPrice_id(rs.getInt("bestPrice_id"));
	    	 best.setAmount(rs.getBigDecimal("amount"));
	    	 best.setProductPurchased(rs.getString("product_purchased"));

	    	  list.add(best);
	    }
	     if(!isNull) {
	    	 System.out.println("--No Data Exist--");
	     }else {
	    	 System.out.println( "--Data Matched--");
	     }
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	return list;
	}
	


}
