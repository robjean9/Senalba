/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contrib;

import java.util.Calendar;

/**
 *
 * @author Breus
 */
public class Contrib {
    private String CNPJ;
    private double Valor;
    private String DataPag;
    private Tipo Tipo;

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the DataPag
     */
    public String getDataPag() {
        return DataPag;
    }

    /**
     * @param DataPag the DataPag to set
     */
    public void setDataPag(String DataPag) {
        this.DataPag = DataPag;
    }

    /**
     * @return the Tipo
     */
    public Tipo getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(Tipo Tipo) {
        this.Tipo = Tipo;
    }


    public enum Tipo {
        SINDICAL, ASSISTENCIAL
    }
}