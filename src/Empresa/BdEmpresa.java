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
        String sql = "insert into empresa (Nome,NomeFantasia,CNPJ,InscricaoEstadual,CNAE,Endereco,CEP,Cidade,Bairro,Estado,Complemento,Telefone1,Telefone2,Telefone3,Email,ContatoAdm,Observacoes)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getNomeFantasia());
            ps.setString(3, empresa.getCNPJ());
            ps.setString(4, empresa.getInscricaoEstadual());
            ps.setString(5, empresa.getCNAE());
            ps.setString(6, empresa.getEndereco());
            ps.setString(7, empresa.getCEP());
            ps.setString(8, empresa.getCidade());
            ps.setString(9, empresa.getBairro());
            ps.setString(10, empresa.getEstado());
            ps.setString(11, empresa.getComplemento());
            ps.setString(12, empresa.getTelefone1());
            ps.setString(13, empresa.getTelefone2());
            ps.setString(14, empresa.getTelefone3());
            ps.setString(15, empresa.getEmail());
            ps.setString(16, empresa.getContatoAdm());
            ps.setString(17, empresa.getObservacoes());
            
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
        String sql = "update empresa set Nome=?, NomeFantasia=?, InscricaoEstadual=?, CNAE=?, Endereco=?, CEP=?, Cidade=?, Bairro=?, Estado=?, Complemento=?, Telefone1=?, Telefone2=?, Telefone3=?, Email=?, ContatoAdm=?, Observacoes=? where CNPJ=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getNomeFantasia());
            ps.setString(3, empresa.getInscricaoEstadual());
            ps.setString(4, empresa.getCNAE());
            ps.setString(5, empresa.getEndereco());
            ps.setString(6, empresa.getCEP());
            ps.setString(7, empresa.getCidade());
            ps.setString(8, empresa.getBairro());
            ps.setString(9, empresa.getEstado());
            ps.setString(10, empresa.getComplemento());
            ps.setString(11, empresa.getTelefone1());
            ps.setString(12, empresa.getTelefone2());
            ps.setString(13, empresa.getTelefone3());
            ps.setString(14, empresa.getEmail());
            ps.setString(15, empresa.getContatoAdm());
            ps.setString(16, empresa.getObservacoes());
            ps.setString(17, empresa.getCNPJ());

            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }
     
     public Empresa localiza(String CNPJ) {
        String sql = "select * from empresa where CNPJ='"+CNPJ+"'";
        Empresa registro = new Empresa();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                registro.setCNPJ(rs.getString("CNPJ"));
                registro.setNome(rs.getString("Nome"));
                registro.setNomeFantasia(rs.getString("NomeFantasia"));
                registro.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                registro.setCNAE(rs.getString("CNAE"));
                registro.setEndereco(rs.getString("Endereco"));
                registro.setCEP(rs.getString("CEP"));
                registro.setCidade(rs.getString("Cidade"));
                registro.setBairro(rs.getString("Bairro"));
                registro.setEstado(rs.getString("Estado"));
                registro.setComplemento(rs.getString("Complemento"));
                registro.setTelefone1(rs.getString("Telefone1"));
                registro.setTelefone2(rs.getString("Telefone2"));
                registro.setTelefone3(rs.getString("Telefone3"));
                registro.setEmail(rs.getString("Email"));
                registro.setContatoAdm(rs.getString("ContatoAdm"));
                registro.setObservacoes(rs.getString("Observacoes"));
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
                registro.setNomeFantasia(rs.getString("NomeFantasia"));
                registro.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                registro.setCNAE(rs.getString("CNAE"));
                registro.setEndereco(rs.getString("Endereco"));
                registro.setCEP(rs.getString("CEP"));
                registro.setCidade(rs.getString("Cidade"));
                registro.setBairro(rs.getString("Bairro"));
                registro.setEstado(rs.getString("Estado"));
                registro.setComplemento(rs.getString("Complemento"));
                registro.setTelefone1(rs.getString("Telefone1"));
                registro.setTelefone2(rs.getString("Telefone2"));
                registro.setTelefone3(rs.getString("Telefone3"));
                registro.setEmail(rs.getString("Email"));
                registro.setContatoAdm(rs.getString("ContatoAdm"));
                registro.setObservacoes(rs.getString("Observacoes"));
                lista.add(registro);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }
     
}


