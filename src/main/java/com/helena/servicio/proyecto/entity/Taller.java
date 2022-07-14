package com.helena.servicio.proyecto.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tmv_taller")
public class Taller {
	@Id
	//auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TALLER")
	private long ID_TALLER;
	@Column(name = "NO_TALLER")
	private String NO_TALLER; 
	@Column(name = "NU_TALLER")
	private String NU_TALLER;

	@Column(name = "FE_TALLER")
	private Date FE_TALLER;
	@Column(name = "ID_GRUPO")
	private Long ID_GRUPO;
	@Column(name = "ID_CICLO")
	private Long ID_CICLO;
	@Column(name = "ID_ESCUELA")
	private Long ID_ESCUELA;
	@Column(name = "ES_TALLER")
	private String ES_TALLER;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_TALLER_PROG")
	private Programa programa;
	
	public long getID_TALLER() {
		return ID_TALLER;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public void setID_TALLER(long iD_TALLER) {
		ID_TALLER = iD_TALLER;
	}
	public String getNO_TALLER() {
		return NO_TALLER;
	}
	public void setNO_TALLER(String nO_TALLER) {
		NO_TALLER = nO_TALLER;
	}
	public String getNU_TALLER() {
		return NU_TALLER;
	}
	public void setNU_TALLER(String nU_TALLER) {
		NU_TALLER = nU_TALLER;
	}
	public Date getFE_TALLER() {
		return FE_TALLER;
	}
	public void setFE_TALLER(Date fE_TALLER) {
		FE_TALLER = fE_TALLER;
	}
	public Long getID_GRUPO() {
		return ID_GRUPO;
	}
	public void setID_GRUPO(Long iD_GRUPO) {
		ID_GRUPO = iD_GRUPO;
	}
	public Long getID_CICLO() {
		return ID_CICLO;
	}
	public void setID_CICLO(Long iD_CICLO) {
		ID_CICLO = iD_CICLO;
	}
	public Long getID_ESCUELA() {
		return ID_ESCUELA;
	}
	public void setID_ESCUELA(Long iD_ESCUELA) {
		ID_ESCUELA = iD_ESCUELA;
	}
	public String getES_TALLER() {
		return ES_TALLER;
	}
	public void setES_TALLER(String eS_TALLER) {
		ES_TALLER = eS_TALLER;
	}
	
	
	
}
