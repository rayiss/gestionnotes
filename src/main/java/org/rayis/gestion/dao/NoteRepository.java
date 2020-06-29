package org.rayis.gestion.dao;

import org.rayis.gestion.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface NoteRepository extends JpaRepository<Note, Long>{

}
