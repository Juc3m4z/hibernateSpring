package com.anncode.transporteshibernate.camion;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.anncode.transporteshibernate.camionero.Camionero;

@Entity
@Table(name="camion")
public class Camion implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="potencia")
	private double potencia;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="tipo")
	private String tipo;
	
	///@JoinTable -- Nombre de la tabla que se relaciona con Camion y Camionero
	///joinColumns -- foreignKey de Camion
	///inverseJoinColumn -- foreignKey de Camionero
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "camion_camionero", joinColumns = @JoinColumn(name = "id_camion"), inverseJoinColumns = @JoinColumn(name = "id_camionero"))
	private Set<Camionero> camioneros = new HashSet();

	public Camion() {	
	}

	public Camion(String matricula, double potencia, String modelo,
			String tipo) {
		super();
		this.matricula = matricula;
		this.potencia = potencia;
		this.modelo = modelo;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Camionero> getCamioneros() {
		return camioneros;
	}

	public void setCamioneros(Set<Camionero> camioneros) {
		this.camioneros = camioneros;
	}
	
}
