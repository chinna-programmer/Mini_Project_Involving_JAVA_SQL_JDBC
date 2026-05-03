package com.te.dao;

import java.util.List;

import com.te.dta.BestPriceAccount;

public interface BestPriceDao {
	
	public String createTable();
	public String insertData(BestPriceAccount mall);
	public String updataAmountBasedOnBestpriceId(BestPriceAccount bestPrice);
	public String deleteData(BestPriceAccount bestPrice);
	public List<BestPriceAccount> readData();
 
}
