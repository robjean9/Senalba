/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PlanSaude;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Breus
 */
public class BdPlanSaude extends bd.Bd {
    public BdPlanSaude() {
        try {
            conexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    public void insere(PlanSaude contrib) {
        String sql = "insert into planosaude (nome, codigo, valor) values (?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contrib.getNome());
            ps.setDouble(2, contrib.getCodigo());
            ps.setString(3, contrib.getValor());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    
    
    /* public void localiza
         contrib.setTipo(Contrib.Tipo.valueOf(rs.getString("tipo")));   
       */    
    
}
