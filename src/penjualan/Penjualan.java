/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import DBO.FungsiQuery;
import DBO.JTextFieldFilter;
import DBO.koneksi;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
public class Penjualan extends javax.swing.JInternalFrame {
     String[] data = new String[10];
     
public String Tanggal;    
private DefaultTableModel tblModel;
  FungsiQuery query=new FungsiQuery();
    String [] kolom=new String[10];
    String [] isi=new String[10];
    String [] dataPopup={"","","","","","","","","",""};
    
    public String[] Kolom()
    {
        kolom[0]="no_faktur";
        kolom[1]="tanggal";
        kolom[2]="nama_customer";
        kolom[3]="id_barang";
        kolom[4]="nama_barang";
        kolom[5]="harga_barang";
        kolom[6]="quantity";
        kolom[7]="harga";
        kolom[8]="ppn";
        kolom[9]="total_harga";
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
        isi[0]=txtNoFaktur.getText();
        isi[1]=Tanggal;
        isi[2]=txtNamaCustomer.getText();
        isi[3]=txtIdBarang.getText();
        isi[4]=txtNamaBarang.getText();
        isi[5]=txtHargaBarang.getText();
        isi[6]=txtQuantity.getText();
        isi[7]=txtSubtotal.getText();
        isi[8]=txtPpn.getText();
        isi[9]=txtTotalHarga.getText();
        return isi;
    }    
    
   

    /**
     * Creates new form Penjualan
     */
    public Penjualan() throws SQLException {
        initComponents();
        set1();
        setNoFak();
        
        txtIdBarang.setDocument(new JTextFieldFilter (50,3));
        txtNamaCustomer.setDocument(new JTextFieldFilter (50,3));
        txtNamaBarang.setDocument(new JTextFieldFilter (20,3));
        txtHargaBarang.setDocument(new JTextFieldFilter (20,1));
        txtQuantity.setDocument(new JTextFieldFilter (15,1));
        txtPpn.setDocument(new JTextFieldFilter (10,1));
        txtTotalHarga.setDocument(new JTextFieldFilter (50,1));
        
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("No. Faktur");
        tblModel.addColumn("Tanggal");
        tblModel.addColumn("Nama Customer");
        tblModel.addColumn("ID. Barang");
        tblModel.addColumn("Nama Barang");
        tblModel.addColumn("Harga Barang");
        tblModel.addColumn("Quantity");
        tblModel.addColumn("Harga");
        tblModel.addColumn("Ppn");
        tblModel.addColumn("TotalHarga");
        setDefaultTableModel();
        
    }
 
    public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM penjualan";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("no_faktur");
                data[1] = res.getString("tanggal");
                data[2] = res.getString("nama_customer");
                data[3] = res.getString("id_barang");
                data[4] = res.getString("nama_barang");
                data[5] = res.getString("harga_barang");
                data[6] = res.getString("quantity");
                data[7] = res.getString("harga");
                data[8] = res.getString("ppn");
                data[9] = res.getString("total_harga");
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
            String SQL = "Select no_faktur FROM penjualan ORDER BY no_faktur desc";
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()){
                String NoFaktur = rs.getString("no_faktur").substring(3);
                String no = "" + (Integer.parseInt(NoFaktur)+ 1);
                String nol = "";
                
                if(no.length()==1)
                {nol = "000";}
                else if(no.length()==2)
                {nol = "00";}
                else if(no.length()==3)
                {nol = "0";}
                else if(no.length()==4)
                {nol = "";}
                txtNoFaktur.setText("FP-" + nol + no);
            }
            else {
                txtNoFaktur.setText("FP-0001");
            }
         }
         catch(Exception exc)
         {exc.printStackTrace();}
     }
    
   
    private void bersih () 
    {
        setNoFak();
        txtIdBarang.setText("");
        txtNamaCustomer.setText("");
        txtNamaBarang.setText("");
        txtHargaBarang.setText("");
        txtQuantity.setText("");
        txtSubtotal.setText("");
        txtPpn.setText("");
        txtTotalHarga.setText("");
    }
    
    private void set1(){
        txtNoFaktur.setEditable(false);
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
        txtNoFaktur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtHargaBarang = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        txtNamaCustomer = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnBarang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        lblHarga = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtPpn = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        btnCustomer = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtIdBarang = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Penjualan - PT. Sugimoto Presisi Technologi");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        txtNoFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoFakturActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("No. Faktur");

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

        txtHargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaBarangKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Harga Barang");

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

        btnBarang.setText("Cari Barang ");
        btnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Faktur", "Tanggal", "Nama Customer", "ID. Barang", "Nama Barang", "Harga Barang", "Quantity", "Harga", "Ppn", "Total Harga"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        lblHarga.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblHarga.setText("Subtotal");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel28.setText("Harga Total");

        txtTotalHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalHargaKeyPressed(evt);
            }
        });

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

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setText("Ppn");

        txtPpn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPpnKeyPressed(evt);
            }
        });

        btnPrint.setText("Cetak Faktur");
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

        btnCustomer.setText("Cari Customer");
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel26.setText("ID. Barang");

        txtIdBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdBarangKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint)
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtTotalHarga))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtPpn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoFaktur)
                            .addComponent(txtNamaCustomer)
                            .addComponent(DTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdBarang))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaBarang)
                            .addComponent(txtHargaBarang)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBarang)
                        .addGap(107, 107, 107)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus)
                        .addComponent(btnUbah)
                        .addComponent(btnPrint)
                        .addComponent(btnTambah)
                        .addComponent(btnBatal))
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPpn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run(){
                    PopupBarang dialog = new PopupBarang(new javax.swing.JFrame(),true);
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                        txtIdBarang.setText((String) dialog.getData()[0]);
                        txtNamaBarang.setText((String) dialog.getData()[1]);
                        txtHargaBarang.setText((String) dialog.getData()[5]);
                        btnTambah.setEnabled(true);
                    }
                }
            });
    }//GEN-LAST:event_btnBarangActionPerformed

    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed
        // TODO add your handling code here:
        String a=txtHargaBarang.getText();
        String b=txtQuantity.getText();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            int y = c*d;
            
            txtSubtotal.setText(Integer.toString(y));
            txtPpn.requestFocus();
        }
    }//GEN-LAST:event_txtQuantityKeyPressed

    private void txtPpnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPpnKeyPressed
        // TODO add your handling code here:
        String a=txtSubtotal.getText();     
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            int c = Integer.parseInt(a);
            int y = c*10/100;
            
            txtPpn.setText(Integer.toString(y));
            txtTotalHarga.requestFocus();
        }
    }//GEN-LAST:event_txtPpnKeyPressed

    private void txtTotalHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalHargaKeyPressed
        // TODO add your handling code here:
        String a=txtPpn.getText();
        String b=txtSubtotal.getText();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            int y = c+d;
            
            txtTotalHarga.setText(Integer.toString(y));
            txtTotalHarga.requestFocus();
        }
    }//GEN-LAST:event_txtTotalHargaKeyPressed

    private void txtNoFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoFakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoFakturActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(txtQuantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Quantity Belum Diisi","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtQuantity.requestFocus();
        }
        else if(txtSubtotal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Subtotal Belum Diisi","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtSubtotal.requestFocus();
        }
        else if(txtPpn.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ppn Belum Diisi","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtPpn.requestFocus();
        }
        else if(txtTotalHarga.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Total Hrga Belum Diisi","Perhatian !",
                JOptionPane.WARNING_MESSAGE);
            txtTotalHarga.requestFocus();
        }
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
                 +txtNoFaktur.getText()+" "+"</i></b> Akan Disimpan? </html>"," Konfirmasi ",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                 if(0==javax.swing.JOptionPane.YES_OPTION){
                     query.InputDetail(Kolom(), Data(), "penjualan");
                     JOptionPane.showMessageDialog(null, "Data Kembali Disimpan");
                     bersih();
                     setDefaultTableModel();
                 }
             }
             catch(Exception exc)
             {System.err.println(exc.getMessage());}
         
         
    }//GEN-LAST:event_btnTambahActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());
            
            String NoFaktur = Table.getValueAt(row,0).toString();
            String NamaCustomer = Table.getValueAt(row,2).toString();
            String IDBarang = Table.getValueAt(row,3).toString();
            String NamaBarang = Table.getValueAt(row,4).toString();
            String HargaBarang = Table.getValueAt(row,5).toString();
            String Quantity = Table.getValueAt(row,6).toString();
            String Harga = Table.getValueAt(row,7).toString();
            
            
            txtNoFaktur.setText(String.valueOf(NoFaktur));
            txtNamaCustomer.setText(String.valueOf(NamaCustomer));
            txtIdBarang.setText(String.valueOf(IDBarang));
            txtNamaBarang.setText(String.valueOf(NamaBarang));
            txtHargaBarang.setText(String.valueOf(HargaBarang));
            txtQuantity.setText(String.valueOf(Quantity));
            txtSubtotal.setText(String.valueOf(Harga));
            btnTambah.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
           
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_TableMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try{
            
            koneksi knks = new koneksi();
            Connection con= knks.bukakoneksi();
            Statement st = con.createStatement();
            
            try{
                String path="src/Report/faktur1.jasper";
                HashMap parameter = new HashMap();
                parameter.put("nofaktur",txtNoFaktur.getText());
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
            +txtNoFaktur.getText()+" "+"</i></b> Akan Dihapus?<?html>","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Hapus("penjualan","no_faktur", txtNoFaktur.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            bersih();
            setDefaultTableModel();
                }
        }catch(Exception exc){
         System.err.println(exc.getMessage());
                }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            +txtNoFaktur.getText()+" "+"</i></b> Akan Diubah?<?html>","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Edit(Kolom(), Data(), "penjualan","no_faktur", txtNoFaktur.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            bersih();
            setDefaultTableModel();
                }
        }catch(Exception exc){
         System.err.println(exc.getMessage());
                }
    }//GEN-LAST:event_btnUbahActionPerformed

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

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run(){
                    PopupCustomer dialog = new PopupCustomer(new javax.swing.JFrame(),true);
                    dialog.setVisible(true);
                    if(dialog.getData()[0].toString().equals("")){
                    }else{
                        txtNamaCustomer.setText((String) dialog.getData()[1]);
                        btnTambah.setEnabled(true);
                    }
                }
            });
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void txtNamaCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaCustomerKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaCustomerKeyTyped

    private void txtIdBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBarangKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtIdBarangKeyTyped

    private void txtNamaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_txtNamaBarangKeyTyped

    private void txtHargaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaBarangKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtHargaBarangKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtQuantityKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnBarang;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtIdBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaCustomer;
    private javax.swing.JTextField txtNoFaktur;
    private javax.swing.JTextField txtPpn;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
