/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mensalidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Welington
 */
public class BdMensalidade extends bd.Bd {
    public BdMensalidade() {
        try{
            conexao();
    } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
    }
    
     public void insere(Mensalidade mensalidade){
        String sql = "insert into Mensalidades (Codigo,Nome,Preco)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(2, mensalidade.getNome());
            ps.setDouble(3, mensalidade.getPreco());
            ps.setInt(1, mensalidade.getCodigo());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
<<<<<<< HEAD
     public void exclui(String Nome){
        String sql="delete from Mensalidades where Codigo=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, Nome);
=======
     public void exclui(String Codigo){
        String sql="delete from Mensalidades where Codigo=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, Codigo);
>>>>>>> c48f1613f9f3f55e2ba21efd57f6d46e071f85c3
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
     
     public void atualiza(Mensalidade mensalidade){
        String sql = "update Mensalidades set Nome=?, Preco=?, where Codigo=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(3, mensalidade.getCodigo());
            ps.setDouble(2, mensalidade.getPreco());
            ps.setString(1, mensalidade.getNome());
            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }
     
     public Mensalidade localiza(String Nome) {
<<<<<<< HEAD
        String sql = "select * from Mensalidades where Codigo=?";
        Mensalidade registro = new Mensalidade();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(2, Nome);
=======
        String sql = "select * from Mensalidades where Nome=?";
        Mensalidade registro = new Mensalidade();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, Nome);
>>>>>>> c48f1613f9f3f55e2ba21efd57f6d46e071f85c3
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                registro.setCodigo(rs.getInt("Codigo"));
                registro.setNome(rs.getString("Nome"));
                registro.setPreco(rs.getDouble("Preco"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public List pesquisa(String busca) {
            String sql = "select * from Mensalidades where nome like '%" + busca + "%'";
            List lista = new ArrayList();
            try {
                Statement st = getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mensalidade registro = new Mensalidade();
                    registro.setCodigo(rs.getInt("codigo"));
                    registro.setNome(rs.getString("nome"));
                    registro.setPreco(rs.getDouble("preco"));
                    lista.add(registro);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return lista;
        }
        public List relatorio(String busca) {
            String sql = "select * from Mensalidades ORDER BY codigo";
            List lista = new ArrayList();
            try {
                Statement st = getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mensalidade registro = new Mensalidade();
                    registro.setCodigo(rs.getInt("codigo"));
                    registro.setNome(rs.getString("nome"));
                    registro.setPreco(rs.getDouble("Preco"));
                    lista.add(registro);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return lista;
        }
}
