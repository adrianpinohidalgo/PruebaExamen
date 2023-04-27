package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inquilino database table.
 * 
 */
@Entity
@NamedQuery(name="Inquilino.findAll", query="SELECT i FROM Inquilino i")
public class Inquilino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float cuotaMensual;

	private String dni;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinAlquiler;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioAlquiler;

	private String nombreCompleto;

	//bi-directional many-to-one association to Vivienda
	@ManyToOne
	@JoinColumn(name="idVivienda")
	private Vivienda vivienda;

	public Inquilino() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCuotaMensual() {
		return this.cuotaMensual;
	}

	public void setCuotaMensual(float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaFinAlquiler() {
		return this.fechaFinAlquiler;
	}

	public void setFechaFinAlquiler(Date fechaFinAlquiler) {
		this.fechaFinAlquiler = fechaFinAlquiler;
	}

	public Date getFechaInicioAlquiler() {
		return this.fechaInicioAlquiler;
	}

	public void setFechaInicioAlquiler(Date fechaInicioAlquiler) {
		this.fechaInicioAlquiler = fechaInicioAlquiler;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Vivienda getVivienda() {
		return this.vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", nombreCompleto=" + nombreCompleto + "]";
	}
	
	

}