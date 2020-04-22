package com.example.Seppocupranking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Joukkue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String nimi;
	private int pisteet;
	private int voitot;
	private int haviot;
	private int jvoitot;
	private int jhaviot;
	private int maalit;
	private int ottelut;
	
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "valmentajaid")
	    private Valmentaja valmentaja;
	

	public Joukkue() {
		
	}
	
	
	public Joukkue(String nimi, int pisteet, int voitot, int haviot, int jvoitot, int jhaviot, int maalit, int ottelut, Valmentaja valmentaja) {
		super();
		this.nimi= nimi;
		this.pisteet = pisteet;
		this.voitot = voitot;
		this.haviot = haviot;
		this.jvoitot = jvoitot;
		this.jhaviot = jhaviot;
		this.maalit = maalit;
		this.ottelut = ottelut;
		this.valmentaja = valmentaja;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}


	public int getPisteet() {
		return pisteet;
	}


	public void setPisteet(int pisteet) {
		this.pisteet = pisteet;
	}


	public int getVoitot() {
		return voitot;
	}


	public void setVoitot(int voitot) {
		this.voitot = voitot;
	}


	public int getHaviot() {
		return haviot;
	}


	public void setHaviot(int haviot) {
		this.haviot = haviot;
	}


	public int getJvoitot() {
		return jvoitot;
	}


	public void setJvoitot(int jvoitot) {
		this.jvoitot = jvoitot;
	}


	public int getJhaviot() {
		return jhaviot;
	}


	public void setJhaviot(int jhaviot) {
		this.jhaviot = jhaviot;
	}


	public int getMaalit() {
		return maalit;
	}


	public void setMaalit(int maalit) {
		this.maalit = maalit;
	}


	public int getOttelut() {
		return ottelut;
	}


	public void setOttelut(int ottelut) {
		this.ottelut = ottelut;
	}


	public Valmentaja getValmentaja() {
		return valmentaja;
	}


	public void setValmentaja(Valmentaja valmentaja) {
		this.valmentaja = valmentaja;
	}


	@Override
	public String toString() {
		return "Joukkue [id=" + id + ", nimi=" + nimi + ", pisteet=" + pisteet + ", voitot=" + voitot + ", haviot="
				+ haviot + ", jvoitot=" + jvoitot + ", jhaviot=" + jhaviot + ", maalit=" + maalit + ", ottelut="
				+ ottelut + ", valmentaja=" + valmentaja + "]";
	}




	
}