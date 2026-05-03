package com.te.dao;

import com.te.dta.UserAccount;

public interface UserDao {
	
	public  String createTable();
	public  String insertData(UserAccount user);  
	public  String updateAgeBasedOnUserId(UserAccount user);
	public  String deleteData(UserAccount user);

}
