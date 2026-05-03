package com.te.dta;

import java.math.BigDecimal;

public class BestPriceAccount {
	
	public int bestPrice_id=10;
	public BigDecimal amount;
	public String productPurchased;
	
	public UserAccount userAccount;
	
	public BestPriceAccount() {
		super();
	
		this.userAccount=new UserAccount();
	}
	public BestPriceAccount(int bestPrice_id, BigDecimal amount, String productPurchased) {
		super();
		this.bestPrice_id = bestPrice_id;
		this.amount = amount;
		this.productPurchased = productPurchased;
		this.userAccount=new UserAccount();
	}
	public int getBestPrice_id() {
		return bestPrice_id;
	}
	public void setBestPrice_id(int bestPrice_id) {
		this.bestPrice_id = bestPrice_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getProductPurchased() {
		return productPurchased;
	}
	public void setProductPurchased(String productPurchased) {
		this.productPurchased = productPurchased;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	@Override
	public String toString() {
		return "BestPriceAccount [bestPrice_id=" + bestPrice_id + ", amount=" + amount + ", productPurchased="
				+ productPurchased + ", userAccount=" + userAccount + "]";
	}
	
}
