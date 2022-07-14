package com.helena.servicio.proyecto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tmv_programa")
public class Programa {
	@Id
	//auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROGRAMA")
	private long ID_PROGRAMA;
	@Column(name = "NO_PROGRAMA")
	private String NO_PROGRAMA;
	@Column(name = "ES_PROGRAMA")
	private String ES_PROGRAMA;
	@Column(name = "DE_PROGRAMA")
	private String DE_PROGRAMA;
	@Column(name = "DU_PROGRAMA")
	private String DU_PROGRAMA;
	@Column(name = "ID_FACULTAD")
	private Long ID_FACULTAD;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PROG_PROY")
	private Proyecto proyec;
	
	
	public Proyecto getProyec() {
		return proyec;
	}
	public void setProyec(Proyecto proyec) {
		this.proyec = proyec;
	}
	public long getID_PROGRAMA() {
		return ID_PROGRAMA;
	}
	public void setID_PROGRAMA(long iD_PROGRAMA) {
		ID_PROGRAMA = iD_PROGRAMA;
	}
	public String getNO_PROGRAMA() {
		return NO_PROGRAMA;
	}
	public void setNO_PROGRAMA(String nO_PROGRAMA) {
		NO_PROGRAMA = nO_PROGRAMA;
	}
	public String getES_PROGRAMA() {
		return ES_PROGRAMA;
	}
	public void setES_PROGRAMA(String eS_PROGRAMA) {
		ES_PROGRAMA = eS_PROGRAMA;
	}
	public String getDE_PROGRAMA() {
		return DE_PROGRAMA;
	}
	public void setDE_PROGRAMA(String dE_PROGRAMA) {
		DE_PROGRAMA = dE_PROGRAMA;
	}
	public String getDU_PROGRAMA() {
		return DU_PROGRAMA;
	}
	public void setDU_PROGRAMA(String dU_PROGRAMA) {
		DU_PROGRAMA = dU_PROGRAMA;
	}
	public Long getID_FACULTAD() {
		return ID_FACULTAD;
	}
	public void setID_FACULTAD(Long iD_FACULTAD) {
		ID_FACULTAD = iD_FACULTAD;
	}
	
	
}
