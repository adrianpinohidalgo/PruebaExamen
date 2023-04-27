package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localidad database table.
 * 
 */
@Entity
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Vivienda
	@OneToMany(mappedBy="localidad")
	private List<Vivienda> viviendas;

	public Localidad() {
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

	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public Vivienda addVivienda(Vivienda vivienda) {
		getViviendas().add(vivienda);
		vivienda.setLocalidad(this);

		return vivienda;
	}

	public Vivienda removeVivienda(Vivienda vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setLocalidad(null);

		return vivienda;
	}

}