package test.automobili.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Marka {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	
	@OneToMany(mappedBy = "marka", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Model> modeli = new ArrayList<>();

	public Marka() {}
	
	public Marka(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public Marka(String naziv, List<Model> modeli) {
		this.naziv = naziv;
		this.modeli = modeli;
	}

	public Marka(Long id, String naziv, List<Model> modeli) {
		this.id = id;
		this.naziv = naziv;
		this.modeli = modeli;
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

	public List<Model> getModeli() {
		return modeli;
	}

	public void setModeli(List<Model> modeli) {
		this.modeli = modeli;
	}
}
