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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Senoramadhani
 */
public class SHDRT extends javax.swing.JFrame {
private TableRowSorter sorter;
private String idshdrtp, idshdrt, shdrt;
    /**
     * Creates new form Agama
     */
    public SHDRT() {
        initComponents();
        tampiltabel();
        awal();
    }
    
    public void awal(){
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
        bersih();
        txtcari.setText("");
    }
    
    public void updatedelete(){
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btnsave.setEnabled(false);
    }
    
    public void bersih(){
        txtidshdrt.setText("");
        txtshdrt.setText("");
    }
    
        //Method Untuk Menyaring Angka
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tampiltabel(){
        DefaultTableModel tb  =new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
            return false;
        }
        };
        //isi kolom judul
        tb.addColumn("id SHDRT");
        tb.addColumn("SHDRT");
        //mengisi data lewat database
        try{
            String sql = "select * from shdrt ORDER BY id_shdrt ASC";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                tb.addRow(new Object[]{res.getString(1),res.getString(2)});
            }
            tabel.setModel(tb);
            sorter = new TableRowSorter<>(tb);
            tabel.setRowSorter(sorter);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidshdrt = new javax.swing.JTextField();
        txtshdrt = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agama");
        setResizable(false);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);
        if (tabel.getColumnModel().getColumnCount() > 0) {
            tabel.getColumnModel().getColumn(0).setResizable(false);
            tabel.getColumnModel().getColumn(1).setResizable(false);
            tabel.getColumnModel().getColumn(2).setResizable(false);
            tabel.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setText("id SHDRT");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("SHDRT");

        txtidshdrt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtidshdrt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidshdrtKeyTyped(evt);
            }
        });

        txtshdrt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        btnsave.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        txtcari.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtcari.setToolTipText("");
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SHDRT");

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtshdrt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtidshdrt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsave)
                                .addGap(18, 18, 18)
                                .addComponent(btnupdate)
                                .addGap(18, 18, 18)
                                .addComponent(btndelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnclear)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidshdrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtshdrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btnclear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        idshdrt = txtidshdrt.getText();
        shdrt = txtshdrt.getText();
         if (idshdrt.equals("")){
            JOptionPane.showMessageDialog(null, "id shdrt tidak boleh kosong");
        } else if (shdrt.equals("")){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else {
            try {
                String sql = "INSERT INTO shdrt VALUES ('"+idshdrt+"','"+shdrt+"')";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                awal();
                pst.execute();
                tampiltabel();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");       
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        String text = txtcari.getText();
        if (text.trim().length() == 0) {
           sorter.setRowFilter(null);
        } else {
           sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtcariActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        txtidshdrt.setText(tabel.getValueAt(tabel.getSelectedRow(), 0).toString());
        txtshdrt.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
        idshdrtp = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
        updatedelete();
    }//GEN-LAST:event_tabelMouseClicked

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        awal();
        tampiltabel();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        idshdrt = txtidshdrt.getText();
        shdrt = txtshdrt.getText();
         if (idshdrt.equals("")){
            JOptionPane.showMessageDialog(null, "id shdrt tidak boleh kosong");
        } else if (shdrt.equals("")){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else {
            try {
                String sql = "update shdrt SET shdrt = '"+shdrt+"', id_shdrt = '"+idshdrt+"' where id_shdrt='"+idshdrtp+"'";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                awal();
                pst.execute();
                tampiltabel();
                JOptionPane.showMessageDialog(null, "Update Data Berhasil");       
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        idshdrt = txtidshdrt.getText();
        if (idshdrt.equals("")){
            JOptionPane.showMessageDialog(null, "id shdrt tidak boleh kosong");
        } else {
            try {
                int jawab;
                if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                    String sql ="delete from shdrt where id_shdrt='"+idshdrt+"'";
                    java.sql.Connection conn = (java.sql.Connection)DBConfig.getDatabase();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    awal();
                    pst.execute();
                    tampiltabel();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtidshdrtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidshdrtKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtidshdrtKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtidshdrt;
    private javax.swing.JTextField txtshdrt;
    // End of variables declaration//GEN-END:variables
}
