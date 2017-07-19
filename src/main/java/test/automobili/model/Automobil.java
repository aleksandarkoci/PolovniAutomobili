package test.automobili.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Automobil {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private int godiste;
	@Column
	private int kilometraza;
	@Column
	private double cena;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Model model;

	public Automobil() {}

	public Automobil(int godiste, int kilometraza, double cena, Model model) {
		this.godiste = godiste;
		this.kilometraza = kilometraza;
		this.cena = cena;
		this.model = model;
	}

	public Automobil(Long id, int godiste, int kilometraza, double cena, Model model) {
		this.id = id;
		this.godiste = godiste;
		this.kilometraza = kilometraza;
		this.cena = cena;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public int getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}	
}
