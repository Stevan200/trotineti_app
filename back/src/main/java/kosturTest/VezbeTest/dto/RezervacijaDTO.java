package kosturTest.VezbeTest.dto;

import java.time.LocalDateTime;


public class RezervacijaDTO {

	private Long id;
	
	private LocalDateTime vremeIznajmljivanja;
	
	private LocalDateTime vremeVracanja;

	private String email;
	
	private Long trotinetId;
	
	private String trotinetSifra;

	@Override
	public String toString() {
		return "RezervacijaDTO []";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getVremeIznajmljivanja() {
		return vremeIznajmljivanja;
	}

	public void setVremeIznajmljivanja(LocalDateTime vremeIznajmljivanja) {
		this.vremeIznajmljivanja = vremeIznajmljivanja;
	}

	public LocalDateTime getVremeVracanja() {
		return vremeVracanja;
	}

	public void setVremeVracanja(LocalDateTime vremeVracanja) {
		this.vremeVracanja = vremeVracanja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTrotinetId() {
		return trotinetId;
	}

	public void setTrotinetId(Long trotinetId) {
		this.trotinetId = trotinetId;
	}

	public String getTrotinetSifra() {
		return trotinetSifra;
	}

	public void setTrotinetSifra(String trotinetSifra) {
		this.trotinetSifra = trotinetSifra;
	}
	
	
	
}
