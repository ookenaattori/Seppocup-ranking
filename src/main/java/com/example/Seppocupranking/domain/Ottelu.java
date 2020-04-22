package com.example.Seppocupranking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ottelu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String joukkue1;
	private String joukkue2;
	private int maalit1;
	private int maalit2;
	private int pisteet1;
	private int pisteet2;
	private String ja;
	
	public Ottelu() {}
	
	
	public Ottelu(String joukkue1, String joukkue2, int maalit1, int maalit2, int pisteet1, int pisteet2, String ja) {
		
		super();
		this.joukkue1 = joukkue1;
		this.joukkue2 = joukkue2;
		this.maalit1 = maalit1;
		this.maalit2 = maalit2;
		this.pisteet1 = pisteet1;
		this.pisteet2 = pisteet2;
		this.ja = ja;
			
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getJoukkue1() {
		return joukkue1;
	}


	public void setJoukkue1(String joukkue1) {
		this.joukkue1 = joukkue1;
	}


	public String getJoukkue2() {
		return joukkue2;
	}


	public void setJoukkue2(String joukkue2) {
		this.joukkue2 = joukkue2;
	}


	public int getMaalit1() {
		return maalit1;
	}


	public void setMaalit1(int maalit1) {
		this.maalit1 = maalit1;
	}


	public int getMaalit2() {
		return maalit2;
	}


	public void setMaalit2(int maalit2) {
		this.maalit2 = maalit2;
	}


	public int getPisteet1() {
		return pisteet1;
	}


	public void setPisteet1(int pisteet1) {
		this.pisteet1 = pisteet1;
	}


	public int getPisteet2() {
		return pisteet2;
	}


	public void setPisteet2(int pisteet2) {
		this.pisteet2 = pisteet2;
	}


	public String getJa() {
		return ja;
	}


	public void setJa(String ja) {
		this.ja = ja;
	}


	@Override
	public String toString() {
		return "Ottelu [id=" + id + ", joukkue1=" + joukkue1 + ", joukkue2=" + joukkue2 + ", maalit1=" + maalit1
				+ ", maalit2=" + maalit2 + ", pisteet1=" + pisteet1 + ", pisteet2=" + pisteet2 + ", ja=" + ja + "]";
	}


	
	
	
}