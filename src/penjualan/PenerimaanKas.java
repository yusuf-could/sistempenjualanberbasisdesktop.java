/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import DBO.FungsiQuery;
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
public class PenerimaanKas extends javax.swing.JInternalFrame {
     String[] data = new String[7];
     
public String Tanggal;    
private DefaultTableModel tblModel;
  FungsiQuery query=new FungsiQuery();
    String [] kolom=new String[7];
    String [] isi=new String[7];
    String [] dataPopup={"","","","","","",""};
    
    public String[] Kolom()
    {
        kolom[0]="no_kas";
        kolom[1]="tanggal";
        kolom[2]="keterangan";
        kolom[3]="penerima";
        kolom[4]="no_faktur";
        kolom[5]="terima";
        kolom[6]="sebesar";
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
        isi[0]=txtNoPenKas.getText();
        isi[1]=Tanggal;
        isi[2]=txtKeterangan.getText();
        isi[3]=txtPenerima.getText();
        isi[4]=txtNoFaktur.getText();
        isi[5]=txtTerima.getText();
        isi[6]=txtSebesar.getText();
        return isi;
    }    

    /**
     * Creates new form PenerimaanKas
     */
    public PenerimaanKas() {
        initComponents();
        set1();
        setNoFak();
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("No. PenKas");
        tblModel.addColumn("Tanggal");
        tblModel.addColumn("Keterangan");
        tblModel.addColumn("Penerima");
        tblModel.addColumn("No Faktur");
        tblModel.addColumn("Terima Dari");
        tblModel.addColumn("Sebesar");
        setDefaultTableModel();
    }
    
    public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM penerimakas";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("no_kas");
                data[1] = res.getString("tanggal");
                data[2] = res.getString("keterangan");
                data[3] = res.getString("penerima");
                data[4] = res.getString("no_faktur");
                data[5] = res.getString("terima");
                data[6] = res.getString("sebesar");
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
            String SQL = "Select no_kas FROM penerimakas ORDER BY no_kas desc";
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()){
                String NoPenKas = rs.getString("no_kas").substring(3);
                String no = "" + (Integer.parseInt(NoPenKas)+ 1);
                String nol = "";
                
                if(no.length()==1)
                {nol = "000";}
                else if(no.length()==2)
                {nol = "00";}
                else if(no.length()==3)
                {nol = "0";}
                else if(no.length()==4)
                {nol = "";}
                txtNoPenKas.setText("KM-" + nol + no);
            }
            else {
                txtNoPenKas.setText("KM-0001");
            }
         }
         catch(Exception exc)
         {exc.printStackTrace();}
     }
    
   
    private void bersih () 
    {
        setNoFak();
        txtKeterangan.setText("");
        txtPenerima.setText("");
        txtNoFaktur.setText("");
        txtTerima.setText("");
        txtSebesar.setText("");
    }
    
    private void set1(){
        txtNoPenKas.setEditable(false);
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
        txtNoPenKas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPenerima = new javax.swing.JTextField();
        txtSebesar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTerima = new javax.swing.JTextField();
        txtNoFaktur = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnCPenKas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Penerimaan Kas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        txtNoPenKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPenKasActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("No. PenKas");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel20.setText("Penerima");

        txtPenerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPenerimaKeyTyped(evt);
            }
        });

        txtSebesar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSebesarKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Sebesar");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel24.setText("Terima Dari");

        txtTerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTerimaKeyTyped(evt);
            }
        });

        txtNoFaktur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoFakturKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel25.setText("No. Faktur");

        btnCPenKas.setText("Cari Penjualan");
        btnCPenKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPenKasActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No. PenKas", "Tanggal", "Keterangan", "Penerima", "No Faktur", "Terima Dari", "Sebesar"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

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

        btnPrint.setText("Cetak Kwitansi");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
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

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel21.setText("Keterangan");

        txtKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
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
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint)
                        .addGap(149, 327, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNoPenKas)
                                    .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtKeterangan)
                                        .addGap(30, 30, 30))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTerima, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtSebesar)
                            .addComponent(txtNoFaktur, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCPenKas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNoPenKas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTerima, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSebesar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBatal)
                        .addGap(18, 18, 18)
                        .addComponent(btnCPenKas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnPrint)
                    .addComponent(btnTambah))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoPenKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPenKasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoPenKasActionPerformed

    private void btnCPenKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPenKasActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run(){
                    PopupPenjualan dialog = null;
                    try {
                        dialog = new PopupPenjualan(new javax.swing.JFrame(),true);
                    } catch (SQLException ex) {
                        Logger.getLogger(PenerimaanKas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                        txtNoFaktur.setText((String) dialog.getData()[0]);
                        txtTerima.setText((String) dialog.getData()[3]);
                        txtSebesar.setText((String) dialog.getData()[9]);
                        btnTambah.setEnabled(true);
                    }
                }
            });
    }//GEN-LAST:event_btnCPenKasActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());

            String NoPenKas = Table.getValueAt(row,0).toString();
            String Keterangan = Table.getValueAt(row,2).toString();
            String Penerima = Table.getValueAt(row,3).toString();
            String NoFaktur = Table.getValueAt(row,4).toString();
            String TerimaDari = Table.getValueAt(row,5).toString();
            String Sebesar = Table.getValueAt(row,6).toString();

            txtNoPenKas.setText(String.valueOf(NoPenKas));
            txtKeterangan.setText(String.valueOf(Keterangan));
            txtPenerima.setText(String.valueOf(Penerima));
            txtNoFaktur.setText(String.valueOf(NoFaktur));
            txtTerima.setText(String.valueOf(TerimaDari));
            txtSebesar.setText(String.valueOf(Sebesar));
            btnTambah.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
            
            

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
                +txtNoPenKas.getText()+" "+"</i></b> Akan Dihapus?<?html>","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Hapus("penerimakas","no_kas", txtNoPenKas.getText());
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

        if(txtPenerima.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Penerima Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtPenerima.requestFocus();
        }
        else if(txtKeterangan.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Keterangan Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtKeterangan.requestFocus();
        }
        else if(txtNoFaktur.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "No Faktur Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtNoFaktur.requestFocus();
        }
        else if(txtTerima.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Terima Dari Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtTerima.requestFocus();
        }
        else if(txtSebesar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Sebesar Belum Dipilih","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtSebesar.requestFocus();
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
                    +txtNoPenKas.getText()+" "+"</i></b> Akan Disimpan? </html>"," Konfirmasi ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if(0==javax.swing.JOptionPane.YES_OPTION){
                    query.InputDetail(Kolom(), Data(), "penerimakas");
                    JOptionPane.showMessageDialog(null, "Data Kembali Disimpan");
                    bersih();
                    setDefaultTableModel();
                }
            }
            catch(Exception exc)
            {System.err.println(exc.getMessage());}
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
                +txtNoPenKas.getText()+" "+"</i></b> Akan Diubah?<?html>","Konfirmasi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
                query.Edit(Kolom(), Data(), "penerimakas","no_kas", txtNoPenKas.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                bersih();
                setDefaultTableModel();
            }
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
         try{
            
            koneksi knks = new koneksi();
            Connection con= knks.bukakoneksi();
            Statement st = con.createStatement();
            
            try{
                String path="src/Report/kwitansi1.jasper";
                HashMap parameter = new HashMap();
                parameter.put("kwitansi",txtNoPenKas.getText());
                JasperPrint print = JasperFillManager.fillReport(path, parameter, st.getConnection());
                JasperViewer.viewReport(print,false);
            } catch (Exception ex)
            {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada"+ex);    
            }        
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

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

    private void txtKeteranganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtKeteranganKeyTyped

    private void txtPenerimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPenerimaKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtPenerimaKeyTyped

    private void txtNoFakturKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoFakturKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtNoFakturKeyTyped

    private void txtTerimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTerimaKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtTerimaKeyTyped

    private void txtSebesarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSebesarKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtSebesarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCPenKas;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNoFaktur;
    private javax.swing.JTextField txtNoPenKas;
    private javax.swing.JTextField txtPenerima;
    private javax.swing.JTextField txtSebesar;
    private javax.swing.JTextField txtTerima;
    // End of variables declaration//GEN-END:variables
}
