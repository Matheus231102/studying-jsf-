package com.matheus.github.repository;

import com.matheus.github.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author matheus badia
 */
public class Empresas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public Empresas() {}
    
    public Empresa pegarPorId(Long id) {
        return entityManager.find(Empresa.class, id);
    }
    
    public List<Empresa> pegarPorNome(String nome) {
        TypedQuery<Empresa> query = entityManager.createQuery("select e from Empresa e where e.nomeFantasia like :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome + "%");
        return query.getResultList();
    }
    
    public Empresa guardar(Empresa empresa) {
        return entityManager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = pegarPorId(empresa.getId());
        entityManager.remove(empresa);
    }
    
}
