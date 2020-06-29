package org.rayis.gestion.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {Note.class})
public interface ProjectionNote {
    public Long getId();
    public double getValeur();
    public Apprenant getApprenant();
    public Examen getExamen();
    public Cours getCours();
}
