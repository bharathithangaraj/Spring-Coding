package com.unimoni.model;

/**
 * 
 * @author gopi
 *
 */
public class Cibil {

	private String panNumber;

	private int cibilScore;

	public Cibil(String panNumber, int cibilScore, String aadher) {
		super();
		this.panNumber = panNumber;
		this.cibilScore = cibilScore;
		this.aadher = aadher;
	}

	public Cibil() {
		// TODO Auto-generated constructor stub
	}

	private String aadher;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public int  getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getAadher() {
		return aadher;
	}

	public void setAadher(String aadher) {
		this.aadher = aadher;
	}

}
