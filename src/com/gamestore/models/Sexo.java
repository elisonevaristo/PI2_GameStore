package com.gamestore.models;

/**
 *
 * @author roger
 * Este Enum tem a função de representar o domínio "Sexo" para a classe cliente;
 */
public enum Sexo {
    
    masculino('M', "Masculino"),
    feminino('F', "Feminino"),
    indefinido('I', "Indefinido");
    
    private char id;
    private String descricao;
        
    Sexo(char id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }
    
    public char getId()
    {
        return this.id;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public static Sexo getById(char id)
    {
        switch (id) {
            case 'M':
                return Sexo.masculino;
            case 'F':
                return Sexo.feminino;
            case 'I':
                return Sexo.indefinido;
            default:
                throw new AssertionError("Sexo inválido.");
        }
    }
}
