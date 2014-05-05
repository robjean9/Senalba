/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Empregado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Robsonzinho
 */
public class BdEmpregado extends bd.Bd {
    public BdEmpregado() {
        try {
            conexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    public void insere(Empregado empregado) {
        String sql = "insert into empregado(Nome,RG,CPF,Endereco,CEP,Cidade,Bairro,Estado,Complemento,DEP1,DEP15,Salario1,VT,Data,Sexo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empregado.getNome());
            ps.setString(2, empregado.getRG());
            ps.setString(3, empregado.getCPF());
            ps.setString(4, empregado.getEndereco());
            ps.setString(5, empregado.getCEP());
            ps.setString(6, empregado.getCidade());
            ps.setString(7, empregado.getBairro());
            ps.setString(8, empregado.getEstado());
            ps.setString(9, empregado.getComplemento());
            ps.setInt(10, empregado.getDEP1());
            ps.setInt(11, empregado.getDEP15());
            ps.setDouble(12, empregado.getSalario1());
            ps.setString(13, empregado.getVT());
            ps.setDate(14,new java.sql.Date(empregado.getData().getTime().getTime()));
            ps.setString(15, empregado.getSexo());

            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public void atualiza(Empregado empregado) {
        String sql = "update empregado set Nome=?, RG=?, Endereco=?, CEP=?, Cidade=?, Bairro=?, Estado=?, Complemento=?, DEP1=?, DEP15=?, Salario1=?, VT=?, Data=?, Sexo=? where CPF=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, empregado.getNome());
            ps.setString(2, empregado.getRG());
            ps.setString(3, empregado.getEndereco());
            ps.setString(4, empregado.getCEP());
            ps.setString(5, empregado.getCidade());
            ps.setString(6, empregado.getBairro());
            ps.setString(7, empregado.getEstado());
            ps.setString(8, empregado.getComplemento());
            ps.setInt(9, empregado.getDEP1());
            ps.setInt(10, empregado.getDEP15());
            ps.setDouble(11, empregado.getSalario1());
            ps.setString(12, empregado.getVT());
            ps.setDate(13,new java.sql.Date(empregado.getData().getTime().getTime()));
            ps.setString(14, empregado.getSexo());
            ps.setString(15, empregado.getCPF());

            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    public List relatorio(String CPF) {
          String sql = "select * from empregado ORDER BY Nome";
            List lista = new ArrayList();
            try {
               PreparedStatement st = getCon().prepareStatement(sql);
               ResultSet rs = st.executeQuery();
               while (rs.next()) {
               Empregado registro = new Empregado();
               registro.setNome(rs.getString("Nome"));
               registro.setCPF(rs.getString("CPF"));
               registro.setRG(rs.getString("RG"));
               lista.add(registro);
               }
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
           }
            return lista;
        }
    public Empregado localiza(String CPF) {
        String sql = "select * from empregado where CPF='" + CPF +"'";
        Empregado registro = new Empregado();
        try {
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                registro.setNome(rs.getString("Nome"));
                registro.setCPF(rs.getString("CPF"));
                registro.setRG(rs.getString("RG"));
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return registro;

        }
    
    
}
