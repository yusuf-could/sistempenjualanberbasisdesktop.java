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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author yusuf
 */
public class Jurnal extends javax.swing.JInternalFrame {

     
public String Tanggal;    
private DefaultTableModel tblModel;
  FungsiQuery query=new FungsiQuery();
    String [] kolom=new String[8];
    String [] isi=new String[8];
    String[] data = new String[8];
    String [] dataPopup={"","","","","","","",""};
    
    public String[] kolom()
    {
        kolom[0]="kode_jurnal";
        kolom[1]="tanggal";
        kolom[2]="keterangan";
        kolom[3]="kode_akun";
        kolom[4]="nama_akun";
        kolom[5]="sebesar";
        kolom[6]="debit";
        kolom[7]="kredit";
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
        
        isi[0]=txtKodeJurnal.getText();
        isi[1]=Tanggal;
        isi[2]=txtKeterangan.getText();
        isi[3]=txtKodeAkun.getText();
        isi[4]=txtNamaAkun.getText();
        isi[5]=txtSebesar.getText();
        isi[6]=txtDebit.getText();
        isi[7]=txtKredit.getText();
        return isi;
    }    
    /**
     * Creates new form Jurnal
     */
    public Jurnal() {
        initComponents();
        set1();
        setNoJur();
      
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("Kode Jurnal");
        tblModel.addColumn("Tanggal");
        tblModel.addColumn("Keterangan");
        tblModel.addColumn("Kode Akun");
        tblModel.addColumn("Nama Akun");
        tblModel.addColumn("Sebesar");
        tblModel.addColumn("Debit");
        tblModel.addColumn("Kredit");
        setDefaultTableModel();
    }
    
     public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM jurnal";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("kode_jurnal");
                data[1] = res.getString("tanggal");
                data[2] = res.getString("keterangan");
                data[3] = res.getString("kode_akun");
                data[4] = res.getString("nama_akun");
                data[5] = res.getString("sebesar");
                data[6] = res.getString("debit");
                data[7] = res.getString("kredit");
                tblModel.addRow(data);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
    }
    }
    
    private void setNoJur()
     {
         try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String SQL = "Select kode_jurnal FROM jurnal ORDER BY kode_jurnal desc";
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()){
                String KodeJurnal = rs.getString("kode_jurnal").substring(3);
                String no = "" + (Integer.parseInt(KodeJurnal)+ 1);
                String nol = "";
                
                if(no.length()==1)
                {nol = "000";}
                else if(no.length()==2)
                {nol = "00";}
                else if(no.length()==3)
                {nol = "0";}
                else if(no.length()==4)
                {nol = "";}
                txtKodeJurnal.setText("JR-" + nol + no);
            }
            else {
                txtKodeJurnal.setText("JR-0001");
            }
         }
         catch(Exception exc)
         {exc.printStackTrace();}
     }
    
   
    private void bersih () 
    {
        setNoJur();
        txtKeterangan.setText("");
        DTanggal.setDateFormatString("");
        txtKodeAkun.setText("");
        txtNamaAkun.setText("");
        txtSebesar.setText("");
        txtDebit.setText("");
        txtKredit.setText("");
    }
    
    private void set1(){
     txtKodeJurnal.setEditable(false);
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
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKodeAkun = new javax.swing.JTextField();
        txtKodeJurnal = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtNamaAkun = new javax.swing.JTextField();
        txtSebesar = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtKredit = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtDebit = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        btnCariPenKas = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        btnAkun = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Jurnal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel20.setText("Kode Jurnal");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel21.setText("Keterangan");

        txtKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeteranganActionPerformed(evt);
            }
        });
        txtKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeteranganKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel26.setText("Kode Akun");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Jurnal", "Tanggal", "Keterangan", "Kode Akun", "Nama Akun", "Sebesar", "Debit", "Kredit"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

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

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txtKodeAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKodeAkunKeyTyped(evt);
            }
        });

        txtKodeJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeJurnalActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel27.setText("Nama Akun");

        txtNamaAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaAkunActionPerformed(evt);
            }
        });
        txtNamaAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaAkunKeyTyped(evt);
            }
        });

        txtSebesar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSebesarKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setText("Kredit");

        txtKredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKreditKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel30.setText("Debit");

        txtDebit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebitKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel22.setText("Tanggal");

        DTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DTanggalPropertyChange(evt);
            }
        });

        btnCariPenKas.setText("Cari PenKas");
        btnCariPenKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPenKasActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel31.setText("Sebesar");

        btnAkun.setText("Cari Akun");
        btnAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAkunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKodeJurnal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(DTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKodeAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDebit, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtSebesar)
                                    .addComponent(txtKredit)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCariPenKas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKodeJurnal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKodeAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKredit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSebesar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAkun))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCariPenKas))))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());
            String KodeJurnal = Table.getValueAt(row,0).toString();
            String Keterangan = Table.getValueAt(row,2).toString();
            String KodeAkun = Table.getValueAt(row,3).toString();
            String NamaAkun = Table.getValueAt(row,4).toString();
            String Sebesar = Table.getValueAt(row,5).toString();
            String Debit = Table.getValueAt(row,6).toString();
            String Kredit = Table.getValueAt(row,7).toString();

            txtKodeJurnal.setText(String.valueOf(KodeJurnal));
            txtKeterangan.setText(String.valueOf(Keterangan));
            txtKodeAkun.setText(String.valueOf(KodeAkun));
            txtNamaAkun.setText(String.valueOf(NamaAkun));
            txtSebesar.setText(String.valueOf(Sebesar));
            txtDebit.setText(String.valueOf(Debit));
            txtKredit.setText(String.valueOf(Kredit));
            btnTambah.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);

        }catch(Exception e){

        }
    }//GEN-LAST:event_TableMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
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
            Object[] options={"Simpan","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null, "<html> Yakin <b><i>"
                +txtKodeJurnal.getText()+" "+"</i></b> akan simpan? </html>","Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION){
                query.InputDetail(kolom(), Data(), "jurnal");
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                bersih();
                setDefaultTableModel();
            }
        }catch(Exception exc){
            System.err.println(exc.getMessage());
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
            int n=JOptionPane.showOptionDialog(null,"<html> Yakin <b><i>"
                +txtKodeJurnal.getText()+" "+"</i></b> Akan Diubah? </html> ","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Edit(kolom(), Data(), "jurnal","kode_jurnal",txtKodeJurnal.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                bersih();
                setDefaultTableModel();
            }
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            
            Object[] options={"Hapus","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html> Yakin <b><i>"
                +txtKodeJurnal.getText()+" "+"</i></b> Akan Dihapus? </html>","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Hapus("jurnal", "kode_jurnal", txtKodeJurnal.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                bersih();
                setDefaultTableModel();
            }
        }
        catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih();
        set1();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtKodeJurnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeJurnalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeJurnalActionPerformed

    private void txtNamaAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaAkunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaAkunActionPerformed

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

    private void btnCariPenKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPenKasActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run(){
                    PopupKas dialog = new PopupKas(new javax.swing.JFrame(),true);
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                    txtKeterangan.setText((String) dialog.getData()[2]);
                    txtSebesar.setText((String) dialog.getData()[6]);
                    btnTambah.setEnabled(true);
                    }
                }
        });
    }//GEN-LAST:event_btnCariPenKasActionPerformed

    private void btnAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAkunActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run(){
                    PopupMasterAkun dialog = new PopupMasterAkun(new javax.swing.JFrame(),true);
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                    txtKodeAkun.setText((String) dialog.getData()[0]);
                    txtNamaAkun.setText((String) dialog.getData()[1]);
                    txtDebit.setText((String) dialog.getData()[2]);
                    txtKredit.setText((String) dialog.getData()[3]);
                    btnTambah.setEnabled(true);
                    }
                }
        });
    }//GEN-LAST:event_btnAkunActionPerformed

    private void txtKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeteranganActionPerformed

    private void txtKeteranganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtKeteranganKeyTyped

    private void txtKodeAkunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeAkunKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtKodeAkunKeyTyped

    private void txtNamaAkunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaAkunKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaAkunKeyTyped

    private void txtSebesarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSebesarKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtSebesarKeyTyped

    private void txtDebitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebitKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtDebitKeyTyped

    private void txtKreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKreditKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtKreditKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnAkun;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariPenKas;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDebit;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtKodeAkun;
    private javax.swing.JTextField txtKodeJurnal;
    private javax.swing.JTextField txtKredit;
    private javax.swing.JTextField txtNamaAkun;
    private javax.swing.JTextField txtSebesar;
    // End of variables declaration//GEN-END:variables
}
