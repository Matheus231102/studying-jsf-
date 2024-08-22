package com.matheus.github.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author matheus badia
 */
@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;
    
    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;
    
    @Column(nullable = false, length = 18)
    private String cnpj;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao")
    private Date dataFundacao;
    
    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id", nullable = false)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoEmpresa tipo;

    public Empresa() {
    }
    
    public Long getId() {
        return id;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nomeFantasia=" + nomeFantasia + '}';
    }
    
}
