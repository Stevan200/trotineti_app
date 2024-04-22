package kosturTest.VezbeTest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Trotinet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( nullable = false, unique = true)
	private String sifra;
	
	@Column
	private Integer nivoBaterije;
	
	@Column( nullable = false)
	private Double maksimalnaBrzina;
	
	@Column( nullable = false)
	private boolean iznajmljen;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
	private Adresa adresa;
	
	@OneToMany(mappedBy = "trotinet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Rezervacija> rezervacije = new ArrayList<>();

	public Trotinet() {
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trotinet other = (Trotinet) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Trotinet [id=" + id + ", sifra=" + sifra + ", nivoBaterije=" + nivoBaterije + ", maksimalnaBrzina="
				+ maksimalnaBrzina + ", iznajmljen=" + iznajmljen + ", adresa=" + adresa + ", rezervacije="
				+ rezervacije + "]";
	}
	
	
}
