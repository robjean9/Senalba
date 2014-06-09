/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contrib;

import Empregado.Empregado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Breus
 */
public class BdContrib extends bd.Bd {
    public BdContrib() {
        try {
            conexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    public void insere(Contrib contrib) {
        String sql = "insert into contribuicaoEmp (CNPJ, Valor, DatPag, Tipo) values (?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contrib.getCNPJ());
            ps.setDouble(2, contrib.getValor());
            ps.setString(3, contrib.getDataPag());
            ps.setString(4, contrib.getTipo().toString());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    
    
    /* public void localiza
         contrib.setTipo(Contrib.Tipo.valueOf(rs.getString("tipo")));   
       */    
    
}
