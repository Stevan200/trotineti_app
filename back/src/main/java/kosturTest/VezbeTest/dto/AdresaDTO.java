package kosturTest.VezbeTest.dto;

import javax.persistence.Column;

public class AdresaDTO {

	private Long id;
	
	private String ulica;
	
	private Integer broj;

	public AdresaDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}
	
	
}
