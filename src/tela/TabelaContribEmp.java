/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tela;

import Contrib.BdContrib;
import Contrib.Contrib;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Breus
 */
public class TabelaContribEmp extends javax.swing.JFrame {

    /**
     * Creates new form TabelaContribEmp
     */
    BdContrib bd;
    public TabelaContribEmp() {
        initComponents();
        bd = new BdContrib();
        preencheTabela();
    }
private void preencheTabela() {
      DefaultTableModel modelo = (DefaultTableModel) jAssociado.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
        }
        List c = bd.relatorio(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Contrib a = (Contrib) it.next();
            modelo.addRow(new Object[]{a.getCNPJ(), a.getTipo(), a.getData(), a.getValor()});

        }
    }

     private void preencheTabelapesquisa() {
      DefaultTableModel modelo = (DefaultTableModel) jAssociado.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
            
        }
        List c = bd.pesquisa(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Contrib a = (Contrib) it.next();
            modelo.addRow(new Object[]{a.getCNPJ(), a.getTipo(), a.getData(), a.getValor()});

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

        jLabel1 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        bFiltro = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAssociado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Procurar:");

        bFiltro.setText("Ok");
        bFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltroActionPerformed(evt);
            }
        });

        bNovo.setText("Cadastrar novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        jAssociado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CNPJ", "Tipo", "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jAssociado.getTableHeader().setReorderingAllowed(false);
        jAssociado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAssociadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jAssociado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bNovo))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bFiltro)
                    .addComponent(bNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltroActionPerformed
        preencheTabelapesquisa();        // TODO add your handling code here:
    }//GEN-LAST:event_bFiltroActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bNovoActionPerformed

    private void jAssociadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAssociadoMouseClicked
       
    }//GEN-LAST:event_jAssociadoMouseClicked

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
            java.util.logging.Logger.getLogger(TabelaContribEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaContribEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaContribEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaContribEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaContribEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFiltro;
    private javax.swing.JButton bNovo;
    private javax.swing.JTable jAssociado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFiltro;
    // End of variables declaration//GEN-END:variables
}
