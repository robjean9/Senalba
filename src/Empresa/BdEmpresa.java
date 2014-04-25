/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Welington
 */
public class BdEmpresa extends bd.Bd {
    public BdEmpresa() {
        try{
            conexao();
    } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
    }
    
     public void insere(Empresa empresa){
        String sql = "insert into empresa (Nome,CNPJ,InscricaoEstadual,CNAE)values(?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getCNPJ());
            ps.setString(3, empresa.getInscricaoEstadual());
            ps.setString(4, empresa.getCNAE());
            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void exclui(int CNPJ){
        String sql="delete from empresa where CNPJ=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, CNPJ);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void atualiza(Empresa empresa){
        String sql = "update empresa set Nome=?, InscricaoEstadual=?, CNAE=? where CNPJ=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getInscricaoEstadual());
            ps.setString(3, empresa.getCNAE());
            ps.setString(4, empresa.getCNPJ());

            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }
     
     public Empresa localiza(int CNPJ) {
        String sql = "select * from empresa where CNPJ=?";
        Empresa registro = new Empresa();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, CNPJ);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                registro.setCNPJ(rs.getString("CNPJ"));
                registro.setNome(rs.getString("Nome"));
                registro.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                registro.setCNAE(rs.getString("CNAE"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }
}


