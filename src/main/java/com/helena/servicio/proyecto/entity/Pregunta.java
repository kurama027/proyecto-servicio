package com.helena.servicio.proyecto.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tax_pregunta")
public class Pregunta {
	@Id
	//auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PREGUNTA")
	private long ID_PREGUNTA;
	@Column(name = "DE_PREGUNTA")
	private String DE_PREGUNTA;
	@ManyToOne
	@JoinColumn(name="ID_PRE_RE")
	private Recurso recu;
	
	public long getID_PREGUNTA() {
		return ID_PREGUNTA;
	}
	public void setID_PREGUNTA(long iD_PREGUNTA) {
		ID_PREGUNTA = iD_PREGUNTA;
	}
	
	public String getDE_PREGUNTA() {
		return DE_PREGUNTA;
	}
	public void setDE_PREGUNTA(String dE_PREGUNTA) {
		DE_PREGUNTA = dE_PREGUNTA;
	}
	public Recurso getRecu() {
		return recu;
	}
	public void setRecu(Recurso recu) {
		this.recu = recu;
	}
	

}
