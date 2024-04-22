package kosturTest.VezbeTest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

public class TrotinetDTO {

	private Long id;
	
	@Length(max = 20, message = "Duzina moze biti max 20 char.")
	private String sifra;
	
	@Min(value = 0, message = "Min. nivo baterije 0.")
	@Max(value = 100, message = "max. nivo baterije 100.")
	private Integer nivoBaterije;
	
	private Double maksimalnaBrzina;
	
	private boolean iznajmljen;
	
	private Long adresaId;
	
	private String adresaUlica;

	public TrotinetDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Integer getNivoBaterije() {
		return nivoBaterije;
	}

	public void setNivoBaterije(Integer nivoBaterije) {
		this.nivoBaterije = nivoBaterije;
	}

	public Double getMaksimalnaBrzina() {
		return maksimalnaBrzina;
	}

	public void setMaksimalnaBrzina(Double maksimalnaBrzina) {
		this.maksimalnaBrzina = maksimalnaBrzina;
	}

	public boolean isIznajmljen() {
		return iznajmljen;
	}

	public void setIznajmljen(boolean iznajmljen) {
		this.iznajmljen = iznajmljen;
	}

	public Long getAdresaId() {
		return adresaId;
	}

	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}

	public String getAdresaUlica() {
		return adresaUlica;
	}

	public void setAdresaUlica(String adresaUlica) {
		this.adresaUlica = adresaUlica;
	}

	

}
