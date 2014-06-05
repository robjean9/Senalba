/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tela;

import Mensalidade.BdMensalidade;
import Mensalidade.Mensalidade;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Welington
 */
public class TelaMensalidade extends javax.swing.JFrame {
    private Mensalidade mensalidade = new Mensalidade();
    private boolean novo;
    private BdMensalidade bd;
    private String Login;
    /** Creates new form TelaProduto */
    public TelaMensalidade() {
        initComponents();
        bd = new BdMensalidade();
        preencheTabela();
    }        

    private void preencheTabela() {
      DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
        }
        List c = getBd().pesquisa(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Mensalidade a = (Mensalidade) it.next();
            modelo.addRow(new Object[]{a.getCodigo(), a.getNome(), a.getPreco()});

        }
    }
     private void preencheTabelapesquisa() {
      DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
        }
        List c = getBd().relatorio(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Mensalidade a = (Mensalidade) it.next();
            modelo.addRow(new Object[]{a.getCodigo(), a.getNome(), a.getPreco()});

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

        tFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLocalizaMensalidade = new javax.swing.JTable();
        tCadastro = new javax.swing.JButton();
        bImprimir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Filtro:");

        bFiltro.setText("OK");
        bFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltroActionPerformed(evt);
            }
        });

        tLocalizaMensalidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tLocalizaMensalidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tLocalizaMensalidadeFocusGained(evt);
            }
        });
        tLocalizaMensalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLocalizaMensalidadeMouseClicked(evt);
            }
        });
        tLocalizaMensalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tLocalizaMensalidadeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tLocalizaMensalidade);

        tCadastro.setText("Cadastro");
        tCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCadastroActionPerformed(evt);
            }
        });

        bImprimir.setText("Imprimir");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tCadastro)
                .addGap(32, 32, 32)
                .addComponent(bImprimir)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bFiltro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bFiltro))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCadastro)
                    .addComponent(bImprimir))
                .addGap(23, 23, 23))
        );

        setSize(new java.awt.Dimension(598, 390));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltroActionPerformed
        preencheTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_bFiltroActionPerformed

    private void tLocalizaMensalidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tLocalizaMensalidadeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tLocalizaMensalidadeFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
            // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained


    private void mAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAlteraActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
        if (tLocalizaMensalidade.getSelectedRow() != -1) {
            String Nome =  modelo.getValueAt(tLocalizaMensalidade.getSelectedRow(), 1).toString();
            CadastroMensalidade t = new CadastroMensalidade();
            t.setNovo(false);
            t.setMensalidade(bd.localiza(Nome));
            t.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há nenhuma mensalidade selecionada");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_mAlteraActionPerformed

    private void mExcluiActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
        if (tLocalizaMensalidade.getSelectedRow() != -1) {
            String Nome =  modelo.getValueAt(tLocalizaMensalidade.getSelectedRow(), 1).toString();
            bd.exclui(Nome);
            preencheTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Não há nenhuma mensalidade selecionada");
        }
    }
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
     preencheTabelapesquisa();   // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void tLocalizaMensalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLocalizaMensalidadeMouseClicked
    if(evt.getClickCount() == 2){
            Point p = evt.getPoint();
            int row = tLocalizaMensalidade.rowAtPoint(p);
            DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
            int Codigo =  (int) modelo.getValueAt(row, 0);
            CadastroMensalidade t = new CadastroMensalidade();
            t.setNovo(false);
            t.setMensalidade(bd.localiza(Codigo));
            t.setVisible(true);       // TODO add your handling code her

        }        // TODO add your handling code here:
    }//GEN-LAST:event_tLocalizaMensalidadeMouseClicked

    private void tLocalizaMensalidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tLocalizaMensalidadeKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_DELETE){
         DefaultTableModel modelo = (DefaultTableModel) tLocalizaMensalidade.getModel();
         int Codigo = (int) modelo.getValueAt(tLocalizaMensalidade.getSelectedRow(), 0);
         bd.exclui(Codigo);
         preencheTabela();
     }
// TODO add your handling code here:
    }//GEN-LAST:event_tLocalizaMensalidadeKeyPressed

    private void tCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCadastroActionPerformed
    CadastroMensalidade t = new CadastroMensalidade();
        t.setNovo(true);
        t.setVisible(true);
        preencheTabela();
        // TODO add your handling code here:
    }//GEN-LAST:event_tCadastroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMensalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMensalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMensalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMensalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMensalidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFiltro;
    private javax.swing.JButton bImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tCadastro;
    private javax.swing.JTextField tFiltro;
    private javax.swing.JTable tLocalizaMensalidade;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the bd
     */
    public BdMensalidade getBd() {
        return bd;
    }
}
