/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "insert into empresa (Nome,CNPJ,InscricaoEstadual,CNAE,Endereco,CEP,Cidade,Bairro,Estado,Complemento)values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getCNPJ());
            ps.setString(3, empresa.getInscricaoEstadual());
            ps.setString(4, empresa.getCNAE());
            ps.setString(5, empresa.getEndereco());
            ps.setString(6, empresa.getCEP());
            ps.setString(7, empresa.getCidade());
            ps.setString(8, empresa.getBairro());
            ps.setString(9, empresa.getEstado());
            ps.setString(10, empresa.getComplemento());
            
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
        String sql = "update empresa set Nome=?, InscricaoEstadual=?, CNAE=?, Endereco=?, CEP=?, Cidade=?, Bairro=?, Estado=?, Complemento=? where CNPJ=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getInscricaoEstadual());
            ps.setString(3, empresa.getCNAE());
            ps.setString(4, empresa.getEndereco());
            ps.setString(5, empresa.getCEP());
            ps.setString(6, empresa.getCidade());
            ps.setString(7, empresa.getBairro());
            ps.setString(8, empresa.getEstado());
            ps.setString(9, empresa.getComplemento());
            ps.setString(10, empresa.getCNPJ());

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
                registro.setEndereco(rs.getString("Endereco"));
                registro.setCEP(rs.getString("CEP"));
                registro.setCidade(rs.getString("Cidade"));
                registro.setBairro(rs.getString("Bairro"));
                registro.setEstado(rs.getString("Estado"));
                registro.setComplemento(rs.getString("Complemento"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }
     
      public ArrayList pesquisa(String nome) {
        String sql = "select * from empresa where Nome like '%"+nome+"%'";
        ArrayList lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                Empresa registro = new Empresa();
                registro.setCNPJ(rs.getString("CNPJ"));
                registro.setNome(rs.getString("Nome"));
                registro.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                registro.setCNAE(rs.getString("CNAE"));
                registro.setEndereco(rs.getString("Endereco"));
                registro.setCEP(rs.getString("CEP"));
                registro.setCidade(rs.getString("Cidade"));
                registro.setBairro(rs.getString("Bairro"));
                registro.setEstado(rs.getString("Estado"));
                registro.setComplemento(rs.getString("Complemento"));
                lista.add(registro);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }
     
}


