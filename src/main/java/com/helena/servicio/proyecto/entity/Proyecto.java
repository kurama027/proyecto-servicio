package com.helena.servicio.proyecto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tma_proyecto")
public class Proyecto {
	@Id
	//auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROYECTO")
	private long ID_PROYECTO;
	@Column(name = "NO_PROYECTO")
	private String NO_PROYECTO;
	@Column(name = "DE_PROYECTO")
	private String DE_PROYECTO;
	@Column(name = "CRO_ACTIVIDADES")
	private String CRO_ACTIVIDADES;
	@Column(name = "FE_INICIO")
	private Date FE_INICIO;
	@Column(name = "FE_FINAL")
	private Date FE_FINAL;  
	@Column(name = "ES_PROYECTO")
	private String ES_PROYECTO; 
	@Column(name = "ID_UBIGEO")
	private long ID_UBIGEO;
	@Column(name = "ID_COORDINADOR_GE")
	private long ID_COORDINADOR_GE;
	public long getID_PROYECTO() {
		return ID_PROYECTO;
	}
	public void setID_PROYECTO(long iD_PROYECTO) {
		ID_PROYECTO = iD_PROYECTO;
	}
	public String getNO_PROYECTO() {
		return NO_PROYECTO;
	}
	public void setNO_PROYECTO(String nO_PROYECTO) {
		NO_PROYECTO = nO_PROYECTO;
	}
	public String getDE_PROYECTO() {
		return DE_PROYECTO;
	}
	public void setDE_PROYECTO(String dE_PROYECTO) {
		DE_PROYECTO = dE_PROYECTO;
	}
	public String getCRO_ACTIVIDADES() {
		return CRO_ACTIVIDADES;
	}
	public void setCRO_ACTIVIDADES(String cRO_ACTIVIDADES) {
		CRO_ACTIVIDADES = cRO_ACTIVIDADES;
	}
	public Date getFE_INICIO() {
		return FE_INICIO;
	}
	public void setFE_INICIO(Date fE_INICIO) {
		FE_INICIO = fE_INICIO;
	}
	public Date getFE_FINAL() {
		return FE_FINAL;
	}
	public void setFE_FINAL(Date fE_FINAL) {
		FE_FINAL = fE_FINAL;
	}
	public String getES_PROYECTO() {
		return ES_PROYECTO;
	}
	public void setES_PROYECTO(String eS_PROYECTO) {
		ES_PROYECTO = eS_PROYECTO;
	}
	public long getID_UBIGEO() {
		return ID_UBIGEO;
	}
	public void setID_UBIGEO(long iD_UBIGEO) {
		ID_UBIGEO = iD_UBIGEO;
	}
	public long getID_COORDINADOR_GE() {
		return ID_COORDINADOR_GE;
	}
	public void setID_COORDINADOR_GE(long iD_COORDINADOR_GE) {
		ID_COORDINADOR_GE = iD_COORDINADOR_GE;
	} 
	
	
}
