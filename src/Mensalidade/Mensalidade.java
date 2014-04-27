/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mensalidade;

/**
 *
 * @author Welington
 */
public class Mensalidade {
    private int Codigo;
    private String Nome;
    private Double Preco;

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Preco
     */
    public Double getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }
}
