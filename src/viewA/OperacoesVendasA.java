/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewA;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DAO.VendasDAO;
import static model.DAO.VendasDAO.List;
import static model.DAO.VendasDAO.ListP;
import model.bean.Venda;
import model.bean.VendaProduto;

/**
 *
 * @author isac_
 */
public class OperacoesVendasA extends javax.swing.JFrame {

    /**
     * Creates new form OperacoesVendas
     */
    public OperacoesVendasA() {
        initComponents();
        
        readJTable();
    }

     public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTableVendas1.getModel();
        modelo.setNumRows(0);
        
        VendasDAO pdao = new VendasDAO();

        for(Venda v: pdao.read()){
            
            modelo.addRow(new Object[]{
                v.getIdvenda(),
                v.getClientev(),
                v.getQtditens(),
                v.getDatavenda(),
                v.getValort()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIDvenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtClientevenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDatavenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQtdvenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorvenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        setResizable(false);

        jTableVendas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Qtd Produtos", "Data", "Valor Total"
            }
        ));
        jTableVendas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendas1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendas1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setText("Pesquisar");

        jLabel2.setText("ID");

        jLabel3.setText("Cliente");

        jLabel4.setText("Data");

        jLabel5.setText("Qtd Produtos");

        jLabel6.setText("Valor");

        jButton2.setText("Visualizar Produtos");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Atualizar Página");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 651, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDatavenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtQtdvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClientevenda, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtValorvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(151, 151, 151))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDvenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatavenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtdvenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClientevenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorvenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtIDvenda.setEnabled(false);
        txtClientevenda.setEnabled(false);
        txtDatavenda.setEnabled(false);
        txtQtdvenda.setEnabled(false);
        txtValorvenda.setEnabled(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        jTableVendas1.setEnabled(true);
        ArrayList<Venda> prod = List(jTextField1.getText());
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Código","Cliente","Qtd Produtos","Data","Valor Total"});
            Object[] row = new Object [5] ;
            for(int i=0;i < prod.size(); i++)
            {
                row[0] = prod.get(i).getIdvenda();
                row[1] = prod.get(i).getClientev();
                row[2] = prod.get(i).getQtditens();
                row[3] = prod.get(i).getDatavenda();
                row[4] = prod.get(i).getValort(); 
                txtIDvenda.setText(String.valueOf((int) row[0]));
                txtClientevenda.setText((String) row[1]);
                txtQtdvenda.setText(String.valueOf((int) row[2]));
                txtDatavenda.setText((String) row[3]);
                txtValorvenda.setText(String.valueOf((double) row[4]));
                model.addRow(row);
            }   
                  jTableVendas1.setModel(model);
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTableVendas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendas1MouseClicked
        // TODO add your handling code here:
        
        if (jTableVendas1.getSelectedRow() != -1){
            
           txtIDvenda.setText(jTableVendas1.getValueAt(jTableVendas1.getSelectedRow(), 0).toString());
           txtClientevenda.setText(jTableVendas1.getValueAt(jTableVendas1.getSelectedRow(), 1).toString());
           txtQtdvenda.setText(jTableVendas1.getValueAt(jTableVendas1.getSelectedRow(), 2).toString());
           txtDatavenda.setText(jTableVendas1.getValueAt(jTableVendas1.getSelectedRow(), 3).toString());
           txtValorvenda.setText(jTableVendas1.getValueAt(jTableVendas1.getSelectedRow(), 4).toString());
           
        }
        
    }//GEN-LAST:event_jTableVendas1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        ArrayList<VendaProduto> prod = ListP(txtIDvenda.getText());
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"CodP","Cliente","Qtd Produtos","Preço"});
            Object[] row = new Object [4] ;
            for(int i=0;i < prod.size(); i++)
            {
                row[0] = prod.get(i).getCodproduto();
                row[1] = prod.get(i).getQtdproduto();
                row[2] = prod.get(i).getNomeproduto();
                row[3] = prod.get(i).getPrecoproduto();
                model.addRow(row);
            }   
                  jTableVendas1.setModel(model);
                  txtIDvenda.setText(null);
                  txtClientevenda.setText(null);
                  txtDatavenda.setText(null);
                  txtQtdvenda.setText(null);
                  txtValorvenda.setText(null);
                  jTableVendas1.setEnabled(false);
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                  txtIDvenda.setText("");
                  txtClientevenda.setText("");
                  txtDatavenda.setText("");
                  txtQtdvenda.setText("");
                  txtValorvenda.setText("");
                  jTextField1.setText("");
                  
                  readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableVendas1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtClientevenda;
    private javax.swing.JTextField txtDatavenda;
    private javax.swing.JTextField txtIDvenda;
    private javax.swing.JTextField txtQtdvenda;
    private javax.swing.JTextField txtValorvenda;
    // End of variables declaration//GEN-END:variables
}