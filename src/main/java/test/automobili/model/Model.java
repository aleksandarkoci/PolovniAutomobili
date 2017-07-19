package test.automobili.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Model {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Marka marka;
	
	@OneToMany(mappedBy = "model", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Automobil> automobili = new ArrayList<>();

	public Model() {}

	public Model(String naziv, Marka marka, List<Automobil> automobili) {
		this.naziv = naziv;
		this.marka = marka;
		this.automobili = automobili;
	}

	public Model(Long id, String naziv, Marka marka, List<Automobil> automobili) {
		this.id = id;
		this.naziv = naziv;
		this.marka = marka;
		this.automobili = automobili;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	public List<Automobil> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(List<Automobil> automobili) {
		this.automobili = automobili;
	}
}
