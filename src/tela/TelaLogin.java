/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tela;

/**
 *
 * @author robson
 */


import usuario.BdUsuario;
import java.awt.Image;
import java.awt.Toolkit;
import usuario.usuario;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TelaLogin extends javax.swing.JFrame {
    BdUsuario bd = new BdUsuario();
    
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
       URL url = this.getClass().getResource("/img/icon.png");  
       Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
       this.setIconImage(imagemTitulo); 
        initComponents();
      
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tLogin = new javax.swing.JTextField();
        tSenha = new javax.swing.JPasswordField();
        bEntra = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - SindSócio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        tLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tLoginKeyPressed(evt);
            }
        });

        tSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tSenhaKeyPressed(evt);
            }
        });

        bEntra.setText("Entrar");
        bEntra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntraActionPerformed(evt);
            }
        });

        jButton2.setText("Esqueci minha Senha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bEntra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tSenha))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bEntra)
                            .addComponent(jButton2)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public static String userativo = null;
public static String usertipo = null;
    private void bEntraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntraActionPerformed
        usuario result = bd.localiza(tLogin.getText(), String.valueOf(tSenha.getPassword()));
        if(tLogin.getText().equals(result.getLogin()) & String.valueOf(tSenha.getPassword()).equals(result.getSenha())){
           userativo = (result.getLogin());
           usertipo = result.getTipo();
           TelaPrincipal t = new TelaPrincipal();
           t.setUsr(result);
           t.setVisible(true);
           this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Login ou Senha incorreto!");
        }       
    }//GEN-LAST:event_bEntraActionPerformed

    private void tLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tLoginKeyPressed
        int tecla = evt.getKeyCode();
        if( tecla == KeyEvent.VK_ENTER){
            tLogin.setFocusable(false);
            tSenha.setFocusable(true);
            
        }
    }//GEN-LAST:event_tLoginKeyPressed
     
    
            
    private void tSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSenhaKeyPressed
        
        int tecla = evt.getKeyCode();
        if( tecla == KeyEvent.VK_ENTER){
            usuario result = bd.localiza(tLogin.getText(), String.valueOf(tSenha.getPassword()));
            if(tLogin.getText().equals(result.getLogin()) & String.valueOf(tSenha.getPassword()).equals(result.getSenha())){
                //userativo = (result.getLogin());
                //usertipo = result.getTipo();
                //telaHome t = new telaHome();
                //t.setVisible(true);
                //this.dispose();
            } else {
                //JOptionPane.showMessageDialog(null, "Login ou Senha incorreto!");
            }
        }
    }//GEN-LAST:event_tSenhaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String email = JOptionPane.showInputDialog("Digite o e-mail cadastrado em sua conta, lembre-se você precisará dele para recuperar sua senha");
        usuario result = bd.localizaMail(email);
        if(result.getEmail() == null && result.getLogin() == null && result.getSenha() == null){
            JOptionPane.showMessageDialog(null, "Digite um E-mail válido!");
        } else {
            try {
                sendEmail(result.getEmail(), result.getLogin(), result.getSenha());
            } catch (EmailException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void sendEmail(String mail, String login, String senha) throws EmailException{
        boolean erro = false;
        try{
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.barekode.com.br");
            email.addTo(mail);
            email.setFrom("equipe@barekode.com", "Sistema de recuperação de senha");
            email.setSubject("Recuperação de Senha do Sistema");
            email.setMsg(" Seu Login é: " + login + "\n Sua Senha é: " + senha);
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("estagiario@barekode.com", "estagiariokode"));
            email.getMailSession().getProperties().put("mail.smtp.auth", "true");
            email.getMailSession().getProperties().put("mail.debug", "true");
            email.getMailSession().getProperties().put("mail.smtp.port", "465");
            email.getMailSession().getProperties().put("mail.smtp.socketFactory.port", "465");
            email.getMailSession().getProperties().put("mail.smtp.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
            email.getMailSession().getProperties().put("mail.smtp.socketFactory.fallback", "false");
            email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
            email.send();
        } catch (EmailException ex){
            JOptionPane.showMessageDialog(null, "Erro ao enviar!\n" +ex.getMessage());
            erro = true;
            
        }
        if(erro = false){
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso!!");
        
        }
    }
    
   
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEntra;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tLogin;
    private javax.swing.JPasswordField tSenha;
    // End of variables declaration//GEN-END:variables

   /*/ private void setString(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setString(String user, String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }/*/
}
