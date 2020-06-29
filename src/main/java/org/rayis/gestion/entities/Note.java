package org.rayis.gestion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data	@AllArgsConstructor		@NoArgsConstructor
public class Note implements Serializable{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=3)
	private double valeur;
	@ManyToOne
	private Apprenant apprenant;
	@ManyToOne
	private Examen examen;
	@ManyToOne
	private Cours cours;
}
