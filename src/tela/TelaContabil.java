package tela;


import Empresa.BdEmpresa;
import Empresa.Empresa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Breus
 */
public class TelaContabil extends javax.swing.JFrame {
    private Empresa empresa = new Empresa();
    private BdEmpresa bd;
    /**
     * Creates new form TelaContabil
     */
    public TelaContabil() {
        bd = new BdEmpresa();
        
        initComponents();
    }
    String tipo = null;
    
    private void empresaToTela() {
        tNome.setText(getEmpresa().getNome());
        tNomeFantasia.setText(getEmpresa().getNomeFantasia());
        tCNPJ.setText(getEmpresa().getCNPJ());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tNome = new javax.swing.JLabel();
        tNomeFantasia = new javax.swing.JLabel();
        tCNPJ = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        bSindical = new javax.swing.JMenuItem();
        bAssistencial = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tNome.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tNome.setText("Nome da Empresa");

        tNomeFantasia.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        tNomeFantasia.setText("Nome Fantasia da Empresa");

        tCNPJ.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        tCNPJ.setText("CNPJ da Empresa");

        jMenu1.setText("Lançamentos");

        jMenu3.setText("Contribuição");

        bSindical.setText("Sindical");
        bSindical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSindicalActionPerformed(evt);
            }
        });
        jMenu3.add(bSindical);

        bAssistencial.setText("Assistencial");
        bAssistencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAssistencialActionPerformed(evt);
            }
        });
        jMenu3.add(bAssistencial);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNome)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(tNomeFantasia))
                    .addComponent(tCNPJ))
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNomeFantasia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCNPJ)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(721, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSindicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSindicalActionPerformed
        TelaLancamentoSindical t = new TelaLancamentoSindical();
            t.setNovo(false);
            tipo = "SINDICAL";
            t.setEmpresa(bd.localiza(getEmpresa().getCNPJ()));
            t.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_bSindicalActionPerformed

    private void bAssistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAssistencialActionPerformed
        // TODO add your handling code here:
        TelaLancamentoSindical t = new TelaLancamentoSindical();
            t.setNovo(false);
            tipo = "ASSISTÊNCIAL";
            t.setEmpresa(bd.localiza(getEmpresa().getCNPJ()));
            t.setVisible(true);
    }//GEN-LAST:event_bAssistencialActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContabil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContabil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContabil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContabil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContabil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bAssistencial;
    private javax.swing.JMenuItem bSindical;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel tCNPJ;
    private javax.swing.JLabel tNome;
    private javax.swing.JLabel tNomeFantasia;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        empresaToTela();
    }

    /**
     * @return the novo


    /**
     * @return the bd
     */
    public BdEmpresa getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(BdEmpresa bd) {
        this.bd = bd;
    }
}
