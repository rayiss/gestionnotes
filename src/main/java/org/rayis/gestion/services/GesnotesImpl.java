package org.rayis.gestion.services;

import org.rayis.gestion.dao.ApprenantRepository;
import org.rayis.gestion.dao.CoursRepository;
import org.rayis.gestion.dao.ExamenRepository;
import org.rayis.gestion.dao.NoteRepository;
import org.rayis.gestion.entities.Apprenant;
import org.rayis.gestion.entities.Cours;
import org.rayis.gestion.entities.Examen;
import org.rayis.gestion.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class GesnotesImpl implements IGesnotes {

    @Autowired
    private ApprenantRepository apprenantRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void initApprenants() {
        String[] prenoms = new String[] {"Antoine","Résus","Charlie","Christine","Elodie","Elianne","Bertrand","Nathan","Marie","Suzie"};
        String[] matricules = new String[] {"ENSP201","IAI112","FAC501","UY001S","UY2603","FGI355","ISTDI23","UD2356","UCAC589","LBM254"};
        Stream.of("Rayis Lara","Saga Dens","Bah Nkeng","Nlend Song","Koa Esso","Zak Nitcheu","Lens Kemp","Goa Soua","Zenith Ray","Grands Sim").forEach(nomApp->{
            Apprenant apprenant = new Apprenant();
            apprenant.setNom(nomApp);
            apprenant.setPrenom(prenoms[new Random().nextInt(prenoms.length)]);
            apprenant.setMatricule(matricules[new Random().nextInt(matricules.length)]);
            apprenant.setPhoto(nomApp.replaceAll(" ", ""));
            apprenantRepository.save(apprenant);
        });
    }

    @Override
    public void initCours() {
        Stream.of("MATH101","PHY217","CHI023","SVT893","FRA544","ANG098","HIST98","GEO345","SPO340","ECO3097").forEach(codeCours->{
            Cours cours = new Cours();
            cours.setCode(codeCours);
            cours.setDescription("Cours de "+codeCours);
            cours.setCoefficient(1+(int)(Math.random()*4));
            coursRepository.save(cours);
        });
    }

    @Override
    public void initExamens(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String[] date = new String[] {"15-10-2020","06-09-2020","09-03-2020","18-11-2012","08-08-2015","06-03-2019","31-07-2017","06-08-2020","01-01-2018","12-05-2019"};
        Stream.of("SEM101","TRIM217","HEB023","SEM893","TRIM544","HEB098","SEM423","TRIM2017","SEM202","TRI417").forEach(codeExamen->{
            Examen examen = new Examen();
            examen.setCode(codeExamen);
            examen.setDescription("Examen de "+codeExamen);
            try {
                examen.setDate(dateFormat.parse(date[new Random().nextInt(date.length)]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            examenRepository.save(examen);
        });
    }

    @Override
    public void initNotes() {
        List<Apprenant> apprenants = apprenantRepository.findAll();
        List<Cours> cours = coursRepository.findAll();
        List<Examen> examens = examenRepository.findAll();
        apprenants.forEach(app->{
            Note noteApp = new Note();
            noteApp.setValeur(1+(int)(Math.random()*19));
            noteApp.setApprenant(apprenants.get(new Random().nextInt(apprenants.size())));
            noteApp.setCours(cours.get(new Random().nextInt(cours.size())));
            noteApp.setExamen(examens.get(new Random().nextInt(examens.size())));
            noteRepository.save(noteApp);
        });
    }
}
