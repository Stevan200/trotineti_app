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
import javax.persistence.OneToMany;

@Entity
public class Adresa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String ulica;
	
	@Column(nullable = false)
	private Integer broj;
	
	@OneToMany(mappedBy = "adresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trotinet> trotineti = new ArrayList<>();

	public Adresa() {
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

	public List<Trotinet> getTrotineti() {
		return trotineti;
	}

	public void setTrotineti(List<Trotinet> trotineti) {
		this.trotineti = trotineti;
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
		Adresa other = (Adresa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Adresa [id=" + id + ", ulica=" + ulica + ", broj=" + broj + ", trotineti=" + trotineti + "]";
	}
	
	
}
