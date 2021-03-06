/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainControl;

/**
 *
 * @author igorv
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainView() {
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

        btnCadastroMidias = new javax.swing.JButton();
        btnDevolucao = new javax.swing.JButton();
        btnAluguel = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        btnCadastroClientes = new javax.swing.JButton();
        btnCadastroItens = new javax.swing.JButton();
        btnCadastroProdutora = new javax.swing.JButton();
        btnVerificarTitulos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastroMidias.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCadastroMidias.setText("CADASTRO DE MÍDIAS");
        btnCadastroMidias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroMidiasActionPerformed(evt);
            }
        });

        btnDevolucao.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnDevolucao.setText("DEVOLUÇÃO");
        btnDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucaoActionPerformed(evt);
            }
        });

        btnAluguel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnAluguel.setText("ALUGUEL");
        btnAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAluguelActionPerformed(evt);
            }
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/itunes.png"))); // NOI18N

        btnCadastroClientes.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCadastroClientes.setText("CADASTRO DE CLIENTES");
        btnCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClientesActionPerformed(evt);
            }
        });

        btnCadastroItens.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCadastroItens.setText("CADASTRO DE ITENS");
        btnCadastroItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroItensActionPerformed(evt);
            }
        });

        btnCadastroProdutora.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCadastroProdutora.setText("CADASTRO DE PRODUTORA");
        btnCadastroProdutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutoraActionPerformed(evt);
            }
        });

        btnVerificarTitulos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnVerificarTitulos.setText("VERIFICAR TITULOS");
        btnVerificarTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarTitulosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastroItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroMidias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroProdutora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerificarTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastroMidias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroItens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAluguel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroProdutora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerificarTitulos)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroMidiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroMidiasActionPerformed
        MainControl.CadastroDeMidia();
        dispose();
    }//GEN-LAST:event_btnCadastroMidiasActionPerformed

    private void btnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucaoActionPerformed
        MainControl.Devolucao();
        dispose();
    }//GEN-LAST:event_btnDevolucaoActionPerformed

    private void btnAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAluguelActionPerformed
        MainControl.Aluguel();
        dispose();
    }//GEN-LAST:event_btnAluguelActionPerformed

    private void btnCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClientesActionPerformed
        MainControl.CadastroDeCliente();
        dispose();
    }//GEN-LAST:event_btnCadastroClientesActionPerformed

    private void btnCadastroItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroItensActionPerformed
        MainControl.CadastroDeItem();
        dispose();
    }//GEN-LAST:event_btnCadastroItensActionPerformed

    private void btnCadastroProdutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutoraActionPerformed
        MainControl.CadastroProdutora();
        dispose();
    }//GEN-LAST:event_btnCadastroProdutoraActionPerformed

    private void btnVerificarTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarTitulosActionPerformed
        MainControl.VerificarTitulos();
        dispose();
    }//GEN-LAST:event_btnVerificarTitulosActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnAluguel;
    private javax.swing.JButton btnCadastroClientes;
    private javax.swing.JButton btnCadastroItens;
    private javax.swing.JButton btnCadastroMidias;
    private javax.swing.JButton btnCadastroProdutora;
    private javax.swing.JButton btnDevolucao;
    private javax.swing.JButton btnVerificarTitulos;
    // End of variables declaration//GEN-END:variables
}
