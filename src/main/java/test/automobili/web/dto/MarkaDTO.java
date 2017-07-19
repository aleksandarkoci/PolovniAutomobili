package test.automobili.web.dto;

public class MarkaDTO {

	private Long id;
	private String naziv;
	
	public MarkaDTO() {}

	public MarkaDTO(String naziv) {
		this.naziv = naziv;
	}

	public MarkaDTO(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
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
}
