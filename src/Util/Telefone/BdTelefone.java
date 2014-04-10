/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.Telefone;

/**
 *
 * @author Robsonzinho
 */
import java.sql.*;
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
    
    
    
    
    
}
