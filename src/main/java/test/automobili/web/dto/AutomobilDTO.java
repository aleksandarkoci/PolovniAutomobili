package test.automobili.web.dto;

public class AutomobilDTO {

	private Long id;
	private int godiste;
	private int kilometraza;
	private double cena;
	
	private ModelDTO model;

	public AutomobilDTO() {}

	public AutomobilDTO(int godiste, int kilometraza, double cena, ModelDTO model) {
		this.godiste = godiste;
		this.kilometraza = kilometraza;
		this.cena = cena;
		this.model = model;
	}

	public AutomobilDTO(Long id, int godiste, int kilometraza, double cena, ModelDTO model) {
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

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}
}
