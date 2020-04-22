package com.example.Seppocupranking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Valmentaja {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long valmentajaid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmentaja")
	private List<Joukkue> joukkue;
	
	
	public Valmentaja() {}
	
	public Valmentaja(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getValmentajaid() {
		return valmentajaid;
	}

	public void setValmentajaid(Long valmentajaid) {
		this.valmentajaid = valmentajaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Joukkue> getJoukkue() {
		return joukkue;
	}

	public void setJoukkue(List<Joukkue> joukkue) {
		this.joukkue = joukkue;
	}

	@Override
	public String toString() {
		return "Valmentaja [valmentajaid=" + valmentajaid + ", nimi=" + nimi + ", joukkue=" + joukkue + "]";
	}
	
	
}