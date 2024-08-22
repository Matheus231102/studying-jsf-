package com.matheus.github.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author matheus badia
 */
@Entity
@Table(name = "tb_ramo_atividade")
public class RamoAtividade implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 80)
    private String descricao;

    public RamoAtividade() {
    }
    
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RamoAtividade other = (RamoAtividade) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "RamoAtividade{" + "id=" + id + '}';
    }
    
}

