/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBHelper.DBConfig;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Senoramadhani
 */
public class Petugas extends javax.swing.JFrame {
    private String passwordlama, niplama, nip, nama, username, password, nipk, namak, nipklama;

    /**
     * Creates new form Petugas
     */
    public Petugas() {
        initComponents();
        tampildataregistrasi();
        tampildatakades();
    }
    
    //Method Untuk Menyaring Angka
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tampildataregistrasi(){
        //mengisi data lewat database
        try{
            String sql = "SELECT * FROM petugas WHERE jabatan = 'Petugas Registrasi'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
                niplama = res.getString("nip");
                txtnip1.setText(res.getString("nip"));
                txtnama1.setText(res.getString("nama"));
                lbljabatan.setText(res.getString("jabatan"));
                passwordlama = res.getString("password");
            }
        } catch(Exception e){
        }
    }
    
    public void tampildatakades(){
        //mengisi data lewat database
        try{
            String sql = "SELECT * FROM petugas WHERE jabatan = 'Kepala Desa Sindangpakuon'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
                nipklama = res.getString("nip");
                txtnip2.setText(res.getString("nip"));
                txtnama2.setText(res.getString("nama"));
                lbljabatan1.setText(res.getString("jabatan"));
            }
        } catch(Exception e){
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        txtnama1 = new javax.swing.JTextField();
        txtnip1 = new javax.swing.JTextField();
        lbljabatan = new javax.swing.JLabel();
        lbljabatan1 = new javax.swing.JLabel();
        btnupdate1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnip2 = new javax.swing.JTextField();
        txtnama2 = new javax.swing.JTextField();
        btnupdate2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtpasswordlama = new javax.swing.JPasswordField();
        txtpassword1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Petugas");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Password Lama");

        txtusername1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        txtnama1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        txtnip1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnip1KeyTyped(evt);
            }
        });

        lbljabatan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbljabatan.setText(".....");

        lbljabatan1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbljabatan1.setText(".....");

        btnupdate1.setText("Update");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("NIP");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Nama");

        txtnip2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnip2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnip2KeyTyped(evt);
            }
        });

        txtnama2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        btnupdate2.setText("Update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Password Baru");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbljabatan)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpasswordlama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnama1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnip1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnupdate1))))
                    .addComponent(lbljabatan1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnip2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnupdate2))
                            .addComponent(txtnama2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(163, 183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbljabatan)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpasswordlama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbljabatan1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 449));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
        //ambil data
        nip = txtnip1.getText();
        nama = txtnama1.getText();
        username = txtusername1.getText();
        password = txtpassword1.getText();
        passwordlama = txtpasswordlama.getText();
         if (nip.equals("")){
            JOptionPane.showMessageDialog(null, "NIP tidak boleh kosong");
        } else if (nama.equals("")){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        } else if (username.equals("")){
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
        } else if (passwordlama.equals("")){
            JOptionPane.showMessageDialog(null, "Password Lama tidak boleh kosong");
        } else if (password.equals("")){
            JOptionPane.showMessageDialog(null, "Password Baru tidak boleh kosong");
        } else {
            try {
                String sql = "UPDATE petugas SET nip = '"+nip+"', nama = '"+nama+"', username = '"+username+"', password = '"+password+"' WHERE nip = '"+niplama+"' AND PASSWORD = '"+passwordlama+"'";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Data Berhasil");
                txtnama1.setText(nama);
                txtnip1.setText(nip);
                txtpasswordlama.setText("");
                txtusername1.setText("");
                txtpassword1.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        nipk = txtnip2.getText();
        namak = txtnama2.getText();
         if (nipk.equals("")){
            JOptionPane.showMessageDialog(null, "NIP tidak boleh kosong");
        } else if (namak.equals("")){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        } else {
            try {
                String sql = "UPDATE petugas SET nip = '"+nipk+"', nama = '"+namak+"' WHERE nip = '"+nipklama+"'";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Data Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void txtnip1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnip1KeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtnip1KeyTyped

    private void txtnip2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnip2KeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtnip2KeyTyped

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate1;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbljabatan;
    private javax.swing.JLabel lbljabatan1;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtnama2;
    private javax.swing.JTextField txtnip1;
    private javax.swing.JTextField txtnip2;
    private javax.swing.JPasswordField txtpassword1;
    private javax.swing.JPasswordField txtpasswordlama;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}