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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author yusuf
 */
public class masterakun extends javax.swing.JInternalFrame {
public String KodeAkun;
public String NamaAkun;

 String[] data = new String[4];
    private DefaultTableModel tblModel;
    FungsiQuery query = new FungsiQuery();
    String [] kolom = new String [4];
    String [] isi = new String [4];
    String [] dataPopup={"","","",""};
    
    public String [] kolom() {
        kolom[0] = "kode_akun";
        kolom[1] = "nama_akun";
        kolom[2] = "debit";
        kolom[3] = "kredit";
        return kolom;
    }
    
    public String[] Data() {
        KodeAkun = (String) cbKodeAkun.getSelectedItem();
         if (KodeAkun == "Aktiva Lancar") {
             NamaAkun = "100";
         } else if (KodeAkun == "Kas") {
             NamaAkun = "111";
         } else if (KodeAkun == "Piutang Usaha") {
             NamaAkun = "112";
         } else if (KodeAkun == "Perlengkapan") {
             NamaAkun = "112";
         } else if (KodeAkun == "Surat-surat Berharga") {
             NamaAkun = "114";
         } else if (KodeAkun == "Iklan Dibayar Dimuka") {
             NamaAkun = "115";
         } else if (KodeAkun == "Sewa Dibayar Dimuka") {
             NamaAkun = "116";
         } else if (KodeAkun == "Harta Tetap") {
             NamaAkun = "120";
         } else if (KodeAkun == "Tanah") {
             NamaAkun = "121";
         } else if (KodeAkun == "Peralatan") {
             NamaAkun = "122";
         } else if (KodeAkun == "Akm. Peny. Peralatan") {
             NamaAkun = "123";
         } else if (KodeAkun == "Gedung") {
             NamaAkun = "124";
         } else if (KodeAkun == "Akm. Peny. Gedung") {
             NamaAkun = "125";
         } else if (KodeAkun == "Harta tidak Terwujud") {
             NamaAkun = "140";
         } else if (KodeAkun == "Gooodwill") {
             NamaAkun = "141";
         } else if (KodeAkun == "Utang") {
             NamaAkun = "200";
         } else if (KodeAkun == "Utang Jangka Pendek/Lancar") {
             NamaAkun = "210";
         } else if (KodeAkun == "Utang Usaha") {
             NamaAkun = "211";
         } else if (KodeAkun == "Utang Gaji") {
             NamaAkun = "212";
         } else if (KodeAkun == "Utang Pajak") {
             NamaAkun = "213";
         } else if (KodeAkun == "Utang Bunga") {
             NamaAkun = "214";
         } else if (KodeAkun == "Modal") {
             NamaAkun = "300";
         } else if (KodeAkun == "Modal Pemilik") {
             NamaAkun = "311";
         } else if (KodeAkun == "Pendapatan") {
             NamaAkun = "400";
         } else if (KodeAkun == "Pendaptan Jasa/Usaha") {
             NamaAkun = "411";
         } else if (KodeAkun == "Pendapatan Lain-lain") {
             NamaAkun = "412";
         } else if (KodeAkun == "Beban-beban") {
             NamaAkun = "500";
         } else if (KodeAkun == "Beban Gaji") {
             NamaAkun = "511";
         }  else if (KodeAkun == "Beban Air Listrik & Telpon") {
             NamaAkun = "512";
         }  else if (KodeAkun == "Beban Pajak") {
             NamaAkun = "513";
         }  else if (KodeAkun == "Beban Bunga") {
             NamaAkun = "514";
         }
        isi[0] = NamaAkun;
        isi[1] = KodeAkun;
        isi[2] = txtDebit.getText();
        isi[3] = txtKredit.getText();
        return isi;
    }
    /**
     * Creates new form masterakun
     */
    public masterakun() {
        initComponents();
        set1();
        bersih();
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("Kode Akun");
        tblModel.addColumn("Nama Akun");
        tblModel.addColumn("Debit");
        tblModel.addColumn("Kredit");
        setDefaultTableModel();
    }
    
     private void bersih()
    {
     txtKodeAkun.setText("");
     txtNamaAkun.setText("");
     txtDebit.setText("");
     txtKredit.setText("");
    }
     private void set1(){
     btnTambah.setEnabled(true);
     btnUbah.setEnabled(false);
     btnHapus.setEnabled(false);
    }
     
    public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM master_akun";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("kode_akun");
                data[1] = res.getString("nama_akun");
                data[2] = res.getString("debit");
                data[3] = res.getString("kredit");
                tblModel.addRow(data);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
    }
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
        txtNamaAkun = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtDebit = new javax.swing.JTextField();
        cbKodeAkun = new javax.swing.JComboBox<>();
        txtKodeAkun = new javax.swing.JTextField();
        txtKredit = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Master Akun", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel20.setText("Kode Akun");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel21.setText("Nama Akun");

        txtNamaAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaAkunKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel26.setText("Debit");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Akun", "Nama Akun", "Debit", "Kredit"
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

        txtDebit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebitKeyTyped(evt);
            }
        });

        cbKodeAkun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Pilihan=", "Aktiva Lancar", "Kas", "Piutang Usaha", "Perlengkapan", "Surat-surat Berharga", "Iklan Dibayar Dimuka", "Sewa Dibayar Dimuka", "Harta Tetap", "Tanah", "Peralatan", "Akm. Peny. Peralatan", "Gedung", "Akm. Peny. Gedung", "Harta tidak Terwujud", "Gooodwill", "Utang", "Utang Jangka Pendek/Lancar", "Utang Usaha", "Utang Gaji", "Utang Pajak", "Utang Bunga", "Modal", "Modal Pemilik", "Pendapatan", "Pendaptan Jasa/Usaha", "Pendapatan Lain-lain", "Beban-beban", "Beban Gaji", "Beban Air Listrik & Telpon", "Beban Pajak", "Beban Bunga" }));
        cbKodeAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeAkunActionPerformed(evt);
            }
        });

        txtKodeAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeAkunActionPerformed(evt);
            }
        });
        txtKodeAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKodeAkunKeyTyped(evt);
            }
        });

        txtKredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKreditKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel27.setText("Kredit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbKodeAkun, 0, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKodeAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtKredit, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(txtDebit)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbKodeAkun)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKodeAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKredit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
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

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try{
            
                Object[] options={"Simpan","Lihat Kembali"};
                int n=JOptionPane.showOptionDialog(null, "<html> Yakin <b><i>"
                    +txtKodeAkun.getText()+" "+"</i></b> akan simpan? </html>","Konfirmasi",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(n==javax.swing.JOptionPane.YES_OPTION){
                        query.InputDetail(kolom(), Data(), "master_akun");
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                        setDefaultTableModel();
                        bersih();
                    }
                }catch(Exception exc){
                        System.err.println(exc.getMessage());                    
                }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());
            String KodeAkun = Table.getValueAt(row,0).toString();
            String NamaAkun = Table.getValueAt(row,1).toString();
            String Debit = Table.getValueAt(row,2).toString();
            String Kredit = Table.getValueAt(row,3).toString();
            
            txtKodeAkun.setText(String.valueOf(KodeAkun));
            txtNamaAkun.setText(String.valueOf(NamaAkun));
            txtDebit.setText(String.valueOf(Debit));
            txtKredit.setText(String.valueOf(Kredit));
            btnTambah.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
           
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_TableMouseClicked

    private void cbKodeAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodeAkunActionPerformed
        // TODO add your handling code here:
          KodeAkun = (String) cbKodeAkun.getSelectedItem();
         if (KodeAkun == "Aktiva Lancar") {
             NamaAkun = "100";
         } else if (KodeAkun == "Kas") {
             NamaAkun = "111";
         } else if (KodeAkun == "Piutang Usaha") {
             NamaAkun = "112";
         } else if (KodeAkun == "Perlengkapan") {
             NamaAkun = "112";
         } else if (KodeAkun == "Surat-surat Berharga") {
             NamaAkun = "114";
         } else if (KodeAkun == "Iklan Dibayar Dimuka") {
             NamaAkun = "115";
         } else if (KodeAkun == "Sewa Dibayar Dimuka") {
             NamaAkun = "116";
         } else if (KodeAkun == "Harta Tetap") {
             NamaAkun = "120";
         } else if (KodeAkun == "Tanah") {
             NamaAkun = "121";
         } else if (KodeAkun == "Peralatan") {
             NamaAkun = "122";
         } else if (KodeAkun == "Akm. Peny. Peralatan") {
             NamaAkun = "123";
         } else if (KodeAkun == "Gedung") {
             NamaAkun = "124";
         } else if (KodeAkun == "Akm. Peny. Gedung") {
             NamaAkun = "125";
         } else if (KodeAkun == "Harta tidak Terwujud") {
             NamaAkun = "140";
         } else if (KodeAkun == "Gooodwill") {
             NamaAkun = "141";
         } else if (KodeAkun == "Utang") {
             NamaAkun = "200";
         } else if (KodeAkun == "Utang Jangka Pendek/Lancar") {
             NamaAkun = "210";
         } else if (KodeAkun == "Utang Usaha") {
             NamaAkun = "211";
         } else if (KodeAkun == "Utang Gaji") {
             NamaAkun = "212";
         } else if (KodeAkun == "Utang Pajak") {
             NamaAkun = "213";
         } else if (KodeAkun == "Utang Bunga") {
             NamaAkun = "214";
         } else if (KodeAkun == "Modal") {
             NamaAkun = "300";
         } else if (KodeAkun == "Modal Pemilik") {
             NamaAkun = "311";
         } else if (KodeAkun == "Pendapatan") {
             NamaAkun = "400";
         } else if (KodeAkun == "Pendaptan Jasa/Usaha") {
             NamaAkun = "411";
         } else if (KodeAkun == "Pendapatan Lain-lain") {
             NamaAkun = "412";
         } else if (KodeAkun == "Beban-beban") {
             NamaAkun = "500";
         } else if (KodeAkun == "Beban Gaji") {
             NamaAkun = "511";
         }  else if (KodeAkun == "Beban Air Listrik & Telpon") {
             NamaAkun = "512";
         }  else if (KodeAkun == "Beban Pajak") {
             NamaAkun = "513";
         }  else if (KodeAkun == "Beban Bunga") {
             NamaAkun = "514";
         }
        txtKodeAkun.setText(NamaAkun);
        txtNamaAkun.setText(KodeAkun);
    }//GEN-LAST:event_cbKodeAkunActionPerformed

    private void txtKodeAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeAkunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeAkunActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try{
            KodeAkun = (String) cbKodeAkun.getSelectedItem();
         if (KodeAkun == "Aktiva Lancar") {
             NamaAkun = "100";
         } else if (KodeAkun == "Kas") {
             NamaAkun = "111";
         } else if (KodeAkun == "Piutang Usaha") {
             NamaAkun = "112";
         } else if (KodeAkun == "Perlengkapan") {
             NamaAkun = "112";
         } else if (KodeAkun == "Surat-surat Berharga") {
             NamaAkun = "114";
         } else if (KodeAkun == "Iklan Dibayar Dimuka") {
             NamaAkun = "115";
         } else if (KodeAkun == "Sewa Dibayar Dimuka") {
             NamaAkun = "116";
         } else if (KodeAkun == "Harta Tetap") {
             NamaAkun = "120";
         } else if (KodeAkun == "Tanah") {
             NamaAkun = "121";
         } else if (KodeAkun == "Peralatan") {
             NamaAkun = "122";
         } else if (KodeAkun == "Akm. Peny. Peralatan") {
             NamaAkun = "123";
         } else if (KodeAkun == "Gedung") {
             NamaAkun = "124";
         } else if (KodeAkun == "Akm. Peny. Gedung") {
             NamaAkun = "125";
         } else if (KodeAkun == "Harta tidak Terwujud") {
             NamaAkun = "140";
         } else if (KodeAkun == "Gooodwill") {
             NamaAkun = "141";
         } else if (KodeAkun == "Utang") {
             NamaAkun = "200";
         } else if (KodeAkun == "Utang Jangka Pendek/Lancar") {
             NamaAkun = "210";
         } else if (KodeAkun == "Utang Usaha") {
             NamaAkun = "211";
         } else if (KodeAkun == "Utang Gaji") {
             NamaAkun = "212";
         } else if (KodeAkun == "Utang Pajak") {
             NamaAkun = "213";
         } else if (KodeAkun == "Utang Bunga") {
             NamaAkun = "214";
         } else if (KodeAkun == "Modal") {
             NamaAkun = "300";
         } else if (KodeAkun == "Modal Pemilik") {
             NamaAkun = "311";
         } else if (KodeAkun == "Pendapatan") {
             NamaAkun = "400";
         } else if (KodeAkun == "Pendaptan Jasa/Usaha") {
             NamaAkun = "411";
         } else if (KodeAkun == "Pendapatan Lain-lain") {
             NamaAkun = "412";
         } else if (KodeAkun == "Beban-beban") {
             NamaAkun = "500";
         } else if (KodeAkun == "Beban Gaji") {
             NamaAkun = "511";
         }  else if (KodeAkun == "Beban Air Listrik & Telpon") {
             NamaAkun = "512";
         }  else if (KodeAkun == "Beban Pajak") {
             NamaAkun = "513";
         }  else if (KodeAkun == "Beban Bunga") {
             NamaAkun = "514";
         }
         txtKodeAkun.setText(NamaAkun);
         txtNamaAkun.setText(KodeAkun);
            
            Object[] options={"Ubah","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html> Yakin <b><i>"
            +txtKodeAkun.getText()+" "+"</i></b> Akan Diubah? </html> ","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Edit(kolom(), Data(), "master_akun","kode_akun",txtKodeAkun.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            setDefaultTableModel();
            bersih();
            
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
            +txtKodeAkun.getText()+" "+"</i></b> Akan Dihapus? </html>","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Hapus("master_akun","kode_akun", txtKodeAkun.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            setDefaultTableModel();
            bersih();
            
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

    private void txtNamaAkunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaAkunKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaAkunKeyTyped

    private void txtDebitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebitKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtDebitKeyTyped

    private void txtKreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKreditKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtKreditKeyTyped

    private void txtKodeAkunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeAkunKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtKodeAkunKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbKodeAkun;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDebit;
    private javax.swing.JTextField txtKodeAkun;
    private javax.swing.JTextField txtKredit;
    private javax.swing.JTextField txtNamaAkun;
    // End of variables declaration//GEN-END:variables
}
