package com.matheus.github.model;

/**
 *
 * @author matheus badia
 */
public enum TipoEmpresa {
    MEI("Microempreendedor Individual"),
    EIRELI("Empresa Individual de Resposabilidade Limitada"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anônima");
    
    private String descricao;

    private TipoEmpresa() {
    }
    
    private TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
