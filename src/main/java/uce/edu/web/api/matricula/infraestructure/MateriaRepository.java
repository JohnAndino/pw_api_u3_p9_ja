package uce.edu.web.api.matricula.infraestructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import uce.edu.web.api.matricula.application.dto.MateriaMaxCreditosDTO;
import uce.edu.web.api.matricula.domain.Materia;


import java.util.List;

@ApplicationScoped
public class MateriaRepository implements PanacheRepository<Materia> {

    @PersistenceContext
    EntityManager em;

    public List<MateriaMaxCreditosDTO> materiaConMasCreditos() {

        var jpql = """
            SELECT m.codigo AS codigo, m.nombre AS nombre, m.creditos AS creditos
            FROM Materia m
            WHERE m.creditos = (
                SELECT MAX(m2.creditos)
                FROM Materia m2
            )
        """;

        var query = em.createQuery(jpql, Tuple.class);

        return query.getResultList()
                .stream()
                .map(t -> new MateriaMaxCreditosDTO(
                        t.get("codigo", String.class),
                        t.get("nombre", String.class),
                        t.get("creditos", Integer.class)
                ))
                .toList();
    }
    
    public List<MateriaMaxCreditosDTO> materiaConMasHoras() {

        var jpql = """
            SELECT m.codigo AS codigo, m.nombre AS nombre, m.horasSemanales AS creditos
            FROM Materia m
            WHERE m.horasSemanales = (
                SELECT MAX(m2.horasSemanales)
                FROM Materia m2
            )
        """;

        var query = em.createQuery(jpql, Tuple.class);

        return query.getResultList()
                .stream()
                .map(t -> new MateriaMaxCreditosDTO(
                        t.get("codigo", String.class),
                        t.get("nombre", String.class),
                        t.get("creditos", Integer.class)
                ))
                .toList();
    }
}

