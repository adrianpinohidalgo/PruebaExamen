package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vivienda database table.
 * 
 */
@Entity
@NamedQuery(name="Vivienda.findAll", query="SELECT v FROM Vivienda v")
public class Vivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Inquilino
	@OneToMany(mappedBy="vivienda")
	private List<Inquilino> inquilinos;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="idLocalidad")
	private Localidad localidad;

	public Vivienda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Inquilino> getInquilinos() {
		return this.inquilinos;
	}

	public void setInquilinos(List<Inquilino> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public Inquilino addInquilino(Inquilino inquilino) {
		getInquilinos().add(inquilino);
		inquilino.setVivienda(this);

		return inquilino;
	}

	public Inquilino removeInquilino(Inquilino inquilino) {
		getInquilinos().remove(inquilino);
		inquilino.setVivienda(null);

		return inquilino;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}