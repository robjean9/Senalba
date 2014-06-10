/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PlanSaude;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Welington
 */
public class BdPlanSaude extends bd.Bd {
    public BdPlanSaude() {
        try{
            conexao();
    } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
    }
    
     public void insere(PlanSaude planosaude){
        String sql = "insert into planosaude (Nome, Codigo, Valor)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, planosaude.getNome());
            ps.setString(2, planosaude.getCodigo());
            ps.setString(3, planosaude.getValor());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void exclui(int Codigo){
        String sql="delete from planosaude where Codigo=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, Codigo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void atualiza(PlanSaude planosaude){
        String sql = "update planosaude set Nome=?, Codigo=?, Valor=? where Codigo=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, planosaude.getNome());
            ps.setString(2, planosaude.getCodigo());
            ps.setString(3, planosaude.getValor());
            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }
     
     public PlanSaude localiza(String Codigo) {
        String sql = "select * from planosaude where Codigo='"+Codigo+"'";
        PlanSaude registro = new PlanSaude();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                registro.setCodigo(rs.getString("Codigo"));
                registro.setNome(rs.getString("Nome"));
                registro.setValor(rs.getString("Valor"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }
     
      public ArrayList pesquisa(String nome) {
        String sql = "select * from planosaude where Nome like '%"+nome+"%'";
        ArrayList lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                PlanSaude registro = new PlanSaude();
                registro.setCodigo(rs.getString("Codigo"));
                registro.setNome(rs.getString("Nome"));
                registro.setValor(rs.getString("Valor"));
                lista.add(registro);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }
     
}


