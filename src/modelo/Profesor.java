package modelo;
// Generated 20:00:38, 27 de feb. de 2023 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

/**
 * Profesor generated by hbm2java
 */
@Entity
@Table(name = "profesor")
@NamedQuery(name="findAllProfesores", query="select p from Profesor p")
public class Profesor implements java.io.Serializable {

	private int id;
	private String nombre;
	private String ape1;
	private String ape2;
	private String tipoFuncionario;
	private ContactInfo contactInfo;
	private Set<Modulo> modulos = new HashSet<Modulo>(0);

	public Profesor() {
		
		
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", tipoFuncionario="
				+ tipoFuncionario + "]";
	}

	public Profesor(int id, String nombre, String ape1, String ape2) {
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public Profesor(int id, String nombre, String ape1, String ape2, String tipoFuncionario, ContactInfo contactInfo,
			Set<Modulo> modulos) {
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.tipoFuncionario = tipoFuncionario;
		this.contactInfo = contactInfo;
		this.modulos = modulos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ape1", nullable = false)
	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	@Column(name = "ape2", nullable = false)
	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	@Column(name = "tipoFuncionario", length = 100)
	public String getTipoFuncionario() {
		return this.tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "profesor")
	public ContactInfo getContactInfo() {
		return this.contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "profesormodulo", joinColumns = {
			@JoinColumn(name = "idProfesor", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idModulo", nullable = false, updatable = false) })
	public Set<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

}
