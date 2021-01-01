/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import DBO.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusuf
 */
public class PopupCustomer extends javax.swing.JDialog {
    String [] data = new String[4];
    
    Customer Cus = new Customer();
    
    
private DefaultTableModel tblModel;

    /**
     * Creates new form PopupBarang
     */
    public PopupCustomer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("ID. Customer");
        tblModel.addColumn("Nama Customer");
        tblModel.addColumn("Alamat");
        tblModel.addColumn("No. Telpon");
        setDefaultTable();
    }
    
    public void setDefaultTable(){
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql;
            sql = "SELECT * FROM customer";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("id_customer");
                data[1] = res.getString("nama_customer");
                data[2] = res.getString("alamat");
                data[3] = res.getString("no_telpon");
                tblModel.addRow(data);
            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
    }
    
    public String[] getData()
    {
        return Cus.getDataPopup();
    }
    
    public void hapusTable()
    {
        int rowCount=Table.getRowCount();
        for(int i=0; i<rowCount; i++)
        {
            tblModel.removeRow(0);
        }
    }
     private void Tabel(javax.swing.JTable tb, int lebar[])
    {
        tb.setAutoResizeMode(tb.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for(int i=0; i<kolom; i++)
    {
        javax.swing.table.TableColumn
        tbc=tb.getColumnModel().getColumn(i);
        tbc.setPreferredWidth(lebar[i]);
        tb.setRowHeight(17);
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
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        cbCustomer = new javax.swing.JComboBox<>();
        txtIdCustomer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Customer - PT. Sugimoto Presisi Technologi");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/image/icon sugimoto.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID. Customer", "Nama Customer", "Alamat", "No. Telpon"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TableComponentShown(evt);
            }
        });
        jScrollPane4.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setHeaderValue("ID. Customer");
            Table.getColumnModel().getColumn(1).setHeaderValue("Nama Customer");
            Table.getColumnModel().getColumn(2).setHeaderValue("Alamat");
            Table.getColumnModel().getColumn(3).setHeaderValue("No. Telpon");
        }

        cbCustomer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID. Customer", "Nama Customer" }));

        txtIdCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCustomerActionPerformed(evt);
            }
        });
        txtIdCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdCustomerKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtIdCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCustomerActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int row = Table.getSelectedRow();
        if(row < 0)
        {
            return;
        }
        Cus.setDataPopup(new String[]
        {
            tblModel.getValueAt (row,0).toString(),
            tblModel.getValueAt (row,1).toString(),
            tblModel.getValueAt (row,2).toString(),
            tblModel.getValueAt (row,3).toString(),
            });
        dispose();
    }//GEN-LAST:event_TableMouseClicked

    private void txtIdCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCustomerKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            if(txtIdCustomer.getText().equals(""))
            {
                hapusTable();
                setDefaultTable();
            }
            else
            {
                hapusTable();
                String Key = null;
                if (cbCustomer.getSelectedIndex()==0)
                {Key="id_customer";}
                else if (cbCustomer.getSelectedIndex()==1)
                {Key="nama_customer";}
                try
                {
                    koneksi knks = new koneksi();
                    Connection con = knks.bukakoneksi();
                    Statement st = con.createStatement();
                    String SQL = "SELECT * FROM customer WHERE "+ Key +" LIKE '"+txtIdCustomer.getText()+"'";
                    ResultSet res = st.executeQuery(SQL);
                    while (res.next())
                    {
                        data[0]=res.getString(1);
                        data[1]=res.getString(2);
                        data[2]=res.getString(3);
                        data[3]=res.getString(4);
                        tblModel.addRow(data);
                    }
                }
                catch(Exception e)
                {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Barang Tidak Ada" + e);
                }
            }
        }
    }//GEN-LAST:event_txtIdCustomerKeyPressed

    private void TableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TableComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_TableComponentShown

    
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
            java.util.logging.Logger.getLogger(PopupCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupCustomer dialog = new PopupCustomer(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtIdCustomer;
    // End of variables declaration//GEN-END:variables
}