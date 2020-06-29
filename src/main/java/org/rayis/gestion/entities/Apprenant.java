package org.rayis.gestion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data	@AllArgsConstructor		@NoArgsConstructor
public class Apprenant implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=75)
	private String nom;
	private String prenom;
	private String matricule;
	private String photo;
	@OneToMany(mappedBy = "apprenant")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private java.util.Collection<Note> note;

}
