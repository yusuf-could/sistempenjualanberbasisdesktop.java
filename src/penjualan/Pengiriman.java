/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import DBO.FungsiQuery;
import DBO.JTextFieldFilter;
import DBO.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author yusuf
 */
public class Pengiriman extends javax.swing.JInternalFrame {
    String[] data = new String[6];
     
public String Tanggal;    
private DefaultTableModel tblModel;
  FungsiQuery query=new FungsiQuery();
    String [] kolom=new String[6];
    String [] isi=new String[6];
    String [] dataPopup={"","","","","",""};
    
    public String[] Kolom()
    {
        kolom[0]="no_dokumen";
        kolom[1]="tanggal";
        kolom[2]="nama_customer";
        kolom[3]="nama_barang";
        kolom[4]="quantity";
        kolom[5]="keterangan";
        return kolom;
    }
    
    public String[] Data()
    {
        try{
            if(DTanggal.getDate() != null){
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                Tanggal = String.valueOf(format.format(DTanggal.getDate()));
            }
            }catch (Exception e){
            
            }
        isi[0]=txtNoDokumen.getText();
        isi[1]=Tanggal;
        isi[2]=txtNamaCustomer.getText();
        isi[3]=txtNamaBarang.getText();
        isi[4]=txtQuantity.getText();
        isi[5]=txtKeterangan.getText();
        return isi;
    }    
    

    /**
     * Creates new form Pengiriman
     */
    public Pengiriman() {
        initComponents();
        set1();
        setNoFak();
        
        txtNamaCustomer.setDocument(new JTextFieldFilter (50,2));
        txtNamaBarang.setDocument(new JTextFieldFilter (20,2));
        txtQuantity.setDocument(new JTextFieldFilter (15,1));
        txtKeterangan.setDocument(new JTextFieldFilter (10,3));
        
        
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("No. Dokumen");
        tblModel.addColumn("Tanggal");
        tblModel.addColumn("Nama Customer");
        tblModel.addColumn("Nama Barang");
        tblModel.addColumn("Quantity");
        tblModel.addColumn("Keterangan");
        setDefaultTableModel();
    }
    
     public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM pengiriman";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("no_dokumen");
                data[1] = res.getString("tanggal");
                data[2] = res.getString("nama_customer");
                data[3] = res.getString("nama_barang");
                data[4] = res.getString("quantity");
                data[5] = res.getString("Keterangan");
                tblModel.addRow(data);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
    }
    }
    
    private void setNoFak()
     {
         try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String SQL = "Select no_dokumen FROM pengiriman ORDER BY no_dokumen desc";
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()){
                String NoDokumen = rs.getString("no_dokumen").substring(3);
                String no = "" + (Integer.parseInt(NoDokumen)+ 1);
                String nol = "";
                
                if(no.length()==1)
                {nol = "000";}
                else if(no.length()==2)
                {nol = "00";}
                else if(no.length()==3)
                {nol = "0";}
                else if(no.length()==4)
                {nol = "";}
                txtNoDokumen.setText("DK-" + nol + no);
            }
            else {
                txtNoDokumen.setText("DK-0001");
            }
         }
         catch(Exception exc)
         {exc.printStackTrace();}
     }
    
   
    private void bersih () 
    {
        
        setNoFak();
        txtNamaCustomer.setText("");
        txtNamaBarang.setText("");
        txtQuantity.setText("");
        txtKeterangan.setText("");
    }
    
    private void set1(){
        txtNoDokumen.setEditable(false);
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }
    
    public void setDataPopup(String[] dataPopup){
        this.dataPopup=dataPopup;
    }
    
     public String[] getDataPopup(){
        return dataPopup;
    }
      public void FilterHuruf(KeyEvent a) {
        if (Character.isDigit(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Masukan Hanya Huruf", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
      public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
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
        txtNoDokumen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        txtNamaCustomer = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnPenjualan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Pengiriman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        txtNoDokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoDokumenActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("No. Dokumen");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel22.setText("Quantity");

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantityKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel24.setText("Nama Barang");

        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyTyped(evt);
            }
        });

        txtNamaCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaCustomerKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel25.setText("Nama Customer");

        btnPenjualan.setText("Data Penjualan");
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. Dokumen", "Tanggal", "Nama Customer", "Nama Barang", "Quantity", "Keterangan"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(4).setResizable(false);
        }

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak Surat Jalan");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel19.setText("Tanggal");

        DTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DTanggalPropertyChange(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Keterangan");

        txtKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeteranganKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeteranganKeyTyped(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoDokumen)
                            .addComponent(txtNamaCustomer)
                            .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtQuantity)
                            .addComponent(txtKeterangan))
                        .addGap(18, 18, 18)
                        .addComponent(btnPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCetak)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnPenjualan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnTambah)
                    .addComponent(btnBatal)
                    .addComponent(btnCetak))
                .addContainerGap(118, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoDokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoDokumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoDokumenActionPerformed

    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityKeyPressed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run(){
                    PopupPenjualan dialog = null;
                    try {
                        dialog = new PopupPenjualan(new javax.swing.JFrame(),true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Pengiriman.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                        txtNamaCustomer.setText((String) dialog.getData()[3]);
                        txtNamaBarang.setText((String) dialog.getData()[4]);
                        txtQuantity.setText((String) dialog.getData()[6]);
                        btnTambah.setEnabled(true);
                        btnUbah.setEnabled(true);
                        btnHapus.setEnabled(true);
                        btnCetak.setEnabled(true);
                    }
                }
            });
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());

            String NoDokumen = Table.getValueAt(row,0).toString();
            String NamaCustomer = Table.getValueAt(row,2).toString();
            String NamaBarang = Table.getValueAt(row,3).toString();
            String Quantity = Table.getValueAt(row,4).toString();
            String Keterangan = Table.getValueAt(row,5).toString();
            

            txtNoDokumen.setText(String.valueOf(NoDokumen));
            txtNamaCustomer.setText(String.valueOf(NamaCustomer));
            txtNamaBarang.setText(String.valueOf(NamaBarang));
            txtQuantity.setText(String.valueOf(Quantity));
            txtKeterangan.setText(String.valueOf(Keterangan));
            btnTambah.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
            btnCetak.setEnabled(true);

        }catch(Exception e){

        }
    }//GEN-LAST:event_TableMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            try{
                if(DTanggal.getDate() != null){
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    Tanggal = String.valueOf(format.format(DTanggal.getDate()));
                }
            }catch (Exception e){

            }
            Object[] options={"Hapus","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html>Yakin<b><i>"
                +txtNoDokumen.getText()+" "+"</i></b> Akan Dihapus?<?html>","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Hapus("pengiriman","no_dokumen", txtNoDokumen.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                bersih();
                setDefaultTableModel();
            }
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:

        if(txtNamaCustomer.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID. Barang Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtNamaCustomer.requestFocus();
        }
        else if(txtNamaBarang.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nama Barang Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtNamaBarang.requestFocus();
        }
        else if(txtQuantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Quantity Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtQuantity.requestFocus();
        }
        else
        {
            try
            {
                try{
                    if(DTanggal.getDate() != null){
                        String pattern = "yyyy-MM-dd";
                        SimpleDateFormat format = new SimpleDateFormat(pattern);
                        Tanggal = String.valueOf(format.format(DTanggal.getDate()));
                    }
                }catch (Exception e){

                }
                Object[]options={" Simpan "," Lihat Kembali "};
                int n=JOptionPane.showOptionDialog(null, "<html> Yakin! <b><i>"
                    +txtNoDokumen.getText()+" "+"</i></b> Akan Disimpan? </html>"," Konfirmasi ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if(0==javax.swing.JOptionPane.YES_OPTION){
                    query.InputDetail(Kolom(), Data(), "pengiriman");
                    JOptionPane.showMessageDialog(null, "Data Kembali Disimpan");
                    bersih();
                    setDefaultTableModel();
                }
            }
            catch(Exception exc)
            {System.err.println(exc.getMessage());}
        }try{
            koneksi knks = new koneksi();
            Connection con= knks.bukakoneksi();
            Statement st = con.createStatement();

            try{
                String path="src/inventory/penjualan.jasper";
                HashMap parameter = new HashMap();
                parameter.put("no_dokumen",txtNoDokumen.getText());
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada"+ex);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try{
            try{
                if(DTanggal.getDate() != null){
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    Tanggal = String.valueOf(format.format(DTanggal.getDate()));
                }
            }catch (Exception e){

            }
            Object[] options={"Ubah","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html>Yakin<b><i>"
                +txtNoDokumen.getText()+" "+"</i></b> Akan Diubah?<?html>","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Edit(Kolom(), Data(), "pengiriman","no_dokumen", txtNoDokumen.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                bersih();
                setDefaultTableModel();
            }
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try{
            
            koneksi knks = new koneksi();
            Connection con= knks.bukakoneksi();
            Statement st = con.createStatement();
            
            try{
                String path="src/Report/suratjalan.jasper";
                HashMap parameter = new HashMap();
                parameter.put("no_pengiriman",txtNoDokumen.getText());
                JasperPrint print = JasperFillManager.fillReport(path, parameter, st.getConnection());
                JasperViewer.viewReport(print,false);
            } catch (Exception ex)
            {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada"+ex);    
            }        
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih();
        set1();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void DTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DTanggalPropertyChange
        // TODO add your handling code here:
        try{
            if(DTanggal.getDate() != null){
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                Tanggal = String.valueOf(format.format(DTanggal.getDate()));
            }
        }catch (Exception e){

        }
    }//GEN-LAST:event_DTanggalPropertyChange

    private void txtKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeteranganKeyPressed

    private void txtNamaCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaCustomerKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaCustomerKeyTyped

    private void txtNamaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaBarangKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtKeteranganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtKeteranganKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaCustomer;
    private javax.swing.JTextField txtNoDokumen;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
