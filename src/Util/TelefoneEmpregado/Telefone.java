/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.TelefoneEmpregado;

/**
 *
 * @author Robsonzinho
 */
public class Telefone {
    private String cpf_empregado;
    private String telefone;
    private String tipo;

    
    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cpf_empregado
     */
    public String getCpf_empregado() {
        return cpf_empregado;
    }

    /**
     * @param cpf_empregado the cpf_empregado to set
     */
    public void setCpf_empregado(String cpf_empregado) {
        this.cpf_empregado = cpf_empregado;
    }
}
