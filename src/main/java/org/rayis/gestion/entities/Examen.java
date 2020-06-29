package org.rayis.gestion.entities;

import java.util.Date;

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
public class Examen {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=10)
	private String code;
	private String description;
	private Date date;
	@OneToMany(mappedBy = "examen")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private java.util.Collection<Note> note;
}
