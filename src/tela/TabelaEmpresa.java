/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tela;

import Empresa.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author charles
 */

public class TabelaEmpresa extends javax.swing.JFrame {
    BdEmpresa bd;
    
    /**
     * Creates new form TabelaEmpresa
     */
    public TabelaEmpresa() {
        initComponents();
        preencheTabela();
        bd = new BdEmpresa();
    }
    
    private void preencheTabela(){
        BdEmpresa bde = new BdEmpresa();
        DefaultTableModel modelo = (DefaultTableModel) tEmpresas.getModel();
        int i = modelo.getRowCount();
        while(i-->0){
            modelo.removeRow(i);
        }
        ArrayList c = bde.pesquisa(tNome.getText());
        for(Iterator it = c.iterator(); it.hasNext();){
            Empresa emp = (Empresa) it.next();
            modelo.addRow(new Object[]{emp.getCNPJ(), emp.getNome(), emp.getInscricaoEstadual(), emp.getCNAE()});
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEmpresas = new javax.swing.JTable();
        bCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CNPJ", "Nome", "Inscrição Estadual", "CNAE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tEmpresas.getTableHeader().setReorderingAllowed(false);
        tEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tEmpresas);
        if (tEmpresas.getColumnModel().getColumnCount() > 0) {
            tEmpresas.getColumnModel().getColumn(0).setResizable(false);
            tEmpresas.getColumnModel().getColumn(1).setResizable(false);
            tEmpresas.getColumnModel().getColumn(2).setResizable(false);
            tEmpresas.getColumnModel().getColumn(3).setResizable(false);
        }

        bCadastrar.setText("Cadastrar empresa");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCadastrar)
                .addGap(39, 39, 39))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(bCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        preencheTabela();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
        CadastroEmpresa t = new CadastroEmpresa();
        t.setVisible(true);
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void tEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmpresasMouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount() == 2){
            Point p = evt.getPoint();
            int row = tEmpresas.rowAtPoint(p);
            DefaultTableModel modelo = (DefaultTableModel) tEmpresas.getModel();
            String CNPJ =(String)  modelo.getValueAt(row, 0);
            CadastroEmpresa t = new CadastroEmpresa();
            t.setNovo(false);
            t.setEmpresa(bd.localiza(CNPJ));
            t.setVisible(true);
         }
    }//GEN-LAST:event_tEmpresasMouseClicked

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
            java.util.logging.Logger.getLogger(TabelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tEmpresas;
    private javax.swing.JTextField tNome;
    // End of variables declaration//GEN-END:variables
}