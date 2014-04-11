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
        String sql = "insert into empresa (Codigo,Nome,CNPJ,InscricaoEstadual,CNAE)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, empresa.getCodigo());
            ps.setString(2, empresa.getNome());
            ps.setString(3, empresa.getCNPJ());
            ps.setString(4, empresa.getInscricaoEstadual());
            ps.setString(5, empresa.getCNAE());
            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void exclui(int Codigo){
        String sql="delete from empresa where codigo=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, Codigo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void atualiza(Empresa empresa){
        String sql = "update empresa set Codigo=?, Nome=?, CNPJ=?, InscricaoEstadual=? where CNAE=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, empresa.getCodigo());
            ps.setString(2, empresa.getNome());
            ps.setString(3, empresa.getCNPJ());
            ps.setString(4, empresa.getInscricaoEstadual());
            ps.setString(5, empresa.getCNAE());
            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }
     
     public Empresa localiza(int Codigo) {
        String sql = "select * from empresa where codigo==?";
        Empresa registro = new Empresa();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, Codigo);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                registro.setCodigo(rs.getInt("Codigo"));
                registro.setNome(rs.getString("Nome"));
                registro.setCNPJ(rs.getString("CNPJ"));
                registro.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                registro.setCNAE(rs.getString("CNAE"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }
}


