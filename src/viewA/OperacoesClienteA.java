/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewA;

import Check.ChecarCpf;
import Check.ValidarEmail;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.ClientesDAO;
import static model.DAO.ClientesDAO.List;
import model.bean.Cliente;

/**
 *
 * @author Eduardo
 */
public class OperacoesClienteA extends javax.swing.JFrame {

    /**
     * Creates new form OperacoesCliente
     */
    public OperacoesClienteA() {
        initComponents();
        
        readJTable();
        
    }
    
        public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTClientesC.getModel();
        modelo.setNumRows(0);
        
        ClientesDAO pdao = new ClientesDAO();

        for(Cliente c: pdao.read()){
            
            modelo.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getCelular(),
                c.getCep(),
                c.getRua(),
                c.getNumero()
            });
    
    }
 }
     public void readJTableFor(String verificar){
        DefaultTableModel modelo = (DefaultTableModel) jTClientesC.getModel();
        modelo.setNumRows(0);
        
        ClientesDAO pdao = new ClientesDAO();

        for(Cliente c: pdao.readCpf(verificar)){
            
            modelo.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getCelular(),
                c.getCep(),
                c.getRua(),
                c.getNumero()
            });
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
        jLabel2 = new javax.swing.JLabel();
        txtNomeC = new javax.swing.JTextField();
        txtCPFC = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmailC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCelularC = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCEPC = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuaC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroC = new javax.swing.JTextField();
        btnRegistrarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTClientesC = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtPesquisarC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        try {
            txtCPFC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Email");

        jLabel4.setText("Celular");

        try {
            txtCelularC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("CEP");

        try {
            txtCEPC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Rua");

        jLabel7.setText("Número");

        btnRegistrarC.setText("Registrar");
        btnRegistrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCActionPerformed(evt);
            }
        });

        jTClientesC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Email", "Celular", "CEP", "Rua", "Número"
            }
        ));
        jTClientesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTClientesCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTClientesC);

        jLabel9.setText("Pesquisar");

        txtPesquisarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarCActionPerformed(evt);
            }
        });
        txtPesquisarC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarCKeyPressed(evt);
            }
        });

        jButton1.setText("Atualizar Página");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(txtNomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPFC, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCelularC, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesquisarC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCEPC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txtRuaC, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(txtNumeroC, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnRegistrarC)
                .addGap(79, 79, 79)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCEPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarC)
                    .addComponent(jButton1))
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCActionPerformed
 
        if (!ChecarCpf.checkCpfCliente(txtCPFC.getText()) && ValidarEmail.Valido(txtEmailC.getText())) {
        ClientesDAO fdao = new ClientesDAO();
        Cliente c1 = new Cliente();
        
        c1.setNome(txtNomeC.getText());   
        c1.setCpf((txtCPFC.getText()));            
        c1.setEmail(txtEmailC.getText());    
        c1.setCelular((txtCelularC.getText()));
        c1.setCep((txtCEPC.getText()));
        c1.setRua((txtRuaC.getText()));
        c1.setNumero((txtNumeroC.getText()));
        
        fdao.create(c1);
            
        txtNomeC.setText("");
        txtCPFC.setText("");
        txtEmailC.setText("");
        txtCelularC.setText("");
        txtCEPC.setText("");
        txtRuaC.setText("");
        txtNumeroC.setText("");
        
        readJTable();
        
        } else {
          JOptionPane.showMessageDialog(null, "CPF já existe ou o email está inválido!");  
        }
        
    }//GEN-LAST:event_btnRegistrarCActionPerformed

    private void txtPesquisarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarCActionPerformed

    private void jTClientesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTClientesCMouseClicked
      
         if (jTClientesC.getSelectedRow() != -1){
            
           txtNomeC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 0).toString());
           txtCPFC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 1).toString());
           txtEmailC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 2).toString());
           txtCelularC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 3).toString());
           txtCEPC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 4).toString());
           txtRuaC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 5).toString());
           txtNumeroC.setText(jTClientesC.getValueAt(jTClientesC.getSelectedRow(), 6).toString());
                    
        }
    }//GEN-LAST:event_jTClientesCMouseClicked

    private void txtPesquisarCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarCKeyPressed
        // TODO add your handling code here:
        ArrayList <Cliente> prod = List(txtPesquisarC.getText());
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Nome","CPF","Telefone","Email","Rua","Cep","Número"});
            Object[] row = new Object [7] ;
            for(int i=0;i < prod.size(); i++)
            {
                row[0] = prod.get(i).getNome();
                row[1] = prod.get(i).getCpf();
                row[2] = prod.get(i).getEmail();
                row[3] = prod.get(i).getCelular();
                row[4] = prod.get(i).getCep(); 
                row[5] = prod.get(i).getRua();
                row[6] = prod.get(i).getNumero();
                txtNomeC.setText((String) row[0]);
                txtCPFC.setText((String) row[1]);
                txtCelularC.setText((String) row[3]);
                txtEmailC.setText((String) row[2]);
                txtCEPC.setText((String) row[4]);
                txtRuaC.setText((String) row[5]);
                txtNumeroC.setText((String) row[6]);
                model.addRow(row);
            }   
                  jTClientesC.setModel(model);
        
    }//GEN-LAST:event_txtPesquisarCKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            txtNomeC.setText("");
            txtCPFC.setText("");
            txtEmailC.setText("");
            txtCelularC.setText("");
            txtCEPC.setText("");
            txtRuaC.setText("");
            txtNumeroC.setText("");
            txtPesquisarC.setText("");
            
            readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTClientesC;
    private javax.swing.JFormattedTextField txtCEPC;
    private javax.swing.JFormattedTextField txtCPFC;
    private javax.swing.JFormattedTextField txtCelularC;
    private javax.swing.JTextField txtEmailC;
    private javax.swing.JTextField txtNomeC;
    private javax.swing.JTextField txtNumeroC;
    private javax.swing.JTextField txtPesquisarC;
    private javax.swing.JTextField txtRuaC;
    // End of variables declaration//GEN-END:variables
}
