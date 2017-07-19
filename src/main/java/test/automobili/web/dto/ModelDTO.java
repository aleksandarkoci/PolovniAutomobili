package test.automobili.web.dto;

public class ModelDTO {

	private Long id;
	private String naziv;
	
	private MarkaDTO marka;

	public ModelDTO() {}

	public ModelDTO(String naziv, MarkaDTO marka) {
		this.naziv = naziv;
		this.marka = marka;
	}

	public ModelDTO(Long id, String naziv, MarkaDTO marka) {
		this.id = id;
		this.naziv = naziv;
		this.marka = marka;
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

	public MarkaDTO getMarka() {
		return marka;
	}

	public void setMarka(MarkaDTO marka) {
		this.marka = marka;
	}
}
