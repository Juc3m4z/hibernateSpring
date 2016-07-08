package com.anncode.transporteshibernate.camionero;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.anncode.transporteshibernate.camion.Camion;
import com.anncode.transporteshibernate.paquete.Paquete;

@Entity
@Table(name = "camionero")
public class Camionero implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "dni")
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "salario")
	private double salario;

	@Column(name = "poblacion")
	private String poblacion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_camionero")
	private List<Paquete> paquetes;
	
	///Mapeamos la lista camioneros
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="camioneros")
	private Set<Camion> camion = new HashSet();

	public Camionero() {

	}

	public Camionero(String dni, String nombre, String telefono, String direccion, double salario, String poblacion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.salario = salario;
		this.poblacion = poblacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Set<Camion> getCamion() {
		return camion;
	}

	public void setCamion(Set<Camion> camion) {
		this.camion = camion;
	}
	
	

}
