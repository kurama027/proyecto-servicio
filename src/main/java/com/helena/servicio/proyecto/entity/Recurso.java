package com.helena.servicio.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tax_recurso")
public class Recurso {
	@Id
	//auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RECURSO")
	private long ID_RECURSO;
	@Column(name = "NO_RECURSO")
	private String NO_RECURSOO;
	@Column(name = "URL_RECURSO")
	private String URL_RECURSO;
	@Column(name = "CO_ESTUDIANTE")
	private String CO_ESTUDIANTE;
	@Column(name = "TI_DOC_RECURSO")
	private String TI_DOC_RECURSO;
	public long getID_RECURSO() {
		return ID_RECURSO;
	}
	public void setID_RECURSO(long iD_RECURSO) {
		ID_RECURSO = iD_RECURSO;
	}
	public String getNO_RECURSOO() {
		return NO_RECURSOO;
	}
	public void setNO_RECURSOO(String nO_RECURSOO) {
		NO_RECURSOO = nO_RECURSOO;
	}
	public String getURL_RECURSO() {
		return URL_RECURSO;
	}
	public void setURL_RECURSO(String uRL_RECURSO) {
		URL_RECURSO = uRL_RECURSO;
	}
	public String getCO_ESTUDIANTE() {
		return CO_ESTUDIANTE;
	}
	public void setCO_ESTUDIANTE(String cO_ESTUDIANTE) {
		CO_ESTUDIANTE = cO_ESTUDIANTE;
	}
	public String getTI_DOC_RECURSO() {
		return TI_DOC_RECURSO;
	}
	public void setTI_DOC_RECURSO(String tI_DOC_RECURSO) {
		TI_DOC_RECURSO = tI_DOC_RECURSO;
	}
	
	
}
