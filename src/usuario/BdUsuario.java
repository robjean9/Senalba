/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import usuario.usuario;
public class BdUsuario extends bd.Bd{
    public BdUsuario(){
        try{
            conexao();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " +e.getMessage());
        }
    }
    public void insere(usuario usuario){
        String sql = "insert into usuario (nome, email, tipo, login, senha) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTipo());
            ps.setString(4, usuario.getLogin());
            ps.setString(5, usuario.getSenha());
            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void atualiza(usuario usuario){
        String sql = "update usuario set nome=?, email=?, tipo=?, login=?, senha=? where codigo=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTipo());
            ps.setString(4, usuario.getLogin());
            ps.setString(5, usuario.getSenha());
            ps.setInt(6, usuario.getCodigo());
            ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        
        
    }
    
    public usuario localiza(String login, String senha){
        //tipo='" + tipo + "'
        String sql = "select login,senha,tipo from usuario where login='" + login + "' and senha='" + senha + "'";
        usuario registro = new usuario();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setLogin(rs.getString("login"));
                registro.setSenha(rs.getString("senha"));
                registro.setTipo(rs.getString("tipo"));
                
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        
        return registro;
    }
    public usuario localizaMail(String email){
        String sql = "select email,login,senha from usuario where email = '" + email + "'";
        usuario registro = new usuario();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setEmail(rs.getString("email"));
                registro.setLogin(rs.getString("login"));
                registro.setSenha(rs.getString("senha"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        
        return registro;
    }
    
    /*public String localizaTipo(String login, String tipo){
        String sql = "select login,tipo from usuario wheretipo = '" + tipo + "'";
        //vo.usuario registro = new usuario();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setTipo(rs.getString("tipo"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        
        return registro;
    }*/

   

   
 


    
   
        
    }

