package com.anncode.transporteshibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="camionero")
public class Camionero implements Serializable{

	
	@Id
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="dni")
	private String dni;
	
	@Id
	@Column(name="nombre")
	private String nombre;
	
	@Id
	@Column(name="telefono")
	private String telefono;
	
	@Id
	@Column(name="direccion")
	private String direccion;
	
	@Id
	@Column(name="salario")
	private double salario;
	
	@Id
	@Column(name="poblacion")
	private String poblacion;

	public Camionero() {
		
	}

	public Camionero(int id, String dni, String nombre, String telefono,
			String direccion, double salario, String poblacion) {
		super();
		this.id = id;
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

}
