/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.TelefoneEmpregado;

/**
 *
 * @author Robsonzinho
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BdTelefone extends bd.Bd {

    public BdTelefone() {
        try{
            conexao();
    }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\n" +e.getMessage());
        }
    }
    
    public void insere(Telefone tel){
        String sql = "insert into Telefones (cpf_empregado,telefone,tipo)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, tel.getCpf_empregado());
            ps.setString(2, tel.getTelefone());
            ps.setString(3, tel.getTipo());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Telefone!\n" +e.getMessage());
        }
    }
    
    public void exclui(String telefone){
        String sql="delete from Telefones where telefone=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, telefone);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Telefone!\n" +e.getMessage());
        }
    }
    
    public ArrayList pesquisa(String cpf){
        String sql = "select * from Telefones where cpf_empregado='"+cpf+"'";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Telefone tel  = new Telefone();
                tel.setCpf_empregado(rs.getString("cpf_empregado"));
                tel.setTelefone(rs.getString("telefone"));
                tel.setTipo(rs.getString("tipo"));
                lista.add(tel);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Telefone!\n" +e.getMessage());
        }
        return lista;
    }
    
    
    
    
    
}
