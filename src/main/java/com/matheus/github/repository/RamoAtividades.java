package com.matheus.github.repository;

import com.matheus.github.model.RamoAtividade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author matheus badia
 */
public class RamoAtividades implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager entityManager;

    public RamoAtividades() {}
    
    public List<RamoAtividade> pesquisar(String descricao) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
            
        Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
        
        criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
        
        TypedQuery<RamoAtividade> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
}
