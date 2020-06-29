package org.rayis.gestion.entities;

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

@Entity
@Data	@AllArgsConstructor		@NoArgsConstructor
public class Cours {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=10)
	private String code;
	private String description;
	@Column(length=2)
	private double coefficient;
	@OneToMany(mappedBy = "cours")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private java.util.Collection<Note> note;
}
