package com.matheus.github.repository;

import com.matheus.github.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author matheus badia
 */
public class SchemaGeneration {
    
    public static void main(String[] args) {
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("testing_jsf_persistence_unit");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        
        List<Empresa> empresaList = entityManager.createNativeQuery("select * from tb_empresa").getResultList();
        
        System.out.println("empresaList: " + empresaList);
        
        entityManager.close();
        EntityManagerFactory.close(); 
    }
}
