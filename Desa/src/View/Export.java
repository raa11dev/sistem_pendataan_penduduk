/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBHelper.DBConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Senoramadhani
 */
public class Export extends javax.swing.JFrame {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
    int hari, bulan, tahun;
    GregorianCalendar date = new GregorianCalendar();
    String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    String namabulann[] = {"JANUARI", "FEBUARI", "MARET", "APRIL", "MEI", "JUNI", "JULI", "AGUSTUS", "SEPTEMBER", "OKTOBER", "NOVEMBER", "DESEMBER"};
    /**
     * Creates new form Export
     */
    public Export() {
        initComponents();
    }
    public void export(Integer month, Integer year) throws SQLException{
    hari = date.get(Calendar.DAY_OF_MONTH);
    bulan = date.get(Calendar.MONTH);
    tahun = date.get(Calendar.YEAR);
        try {
            FileInputStream file = new FileInputStream("D:\\Laporan Penduduk\\Template\\TEMPLATE.xlsx");
            
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFSheet sheet1 = workbook.getSheetAt(2);
            XSSFSheet sheet2 = workbook.getSheetAt(3);
            XSSFSheet sheet3 = workbook.getSheetAt(1);
            XSSFSheet sheet4 = workbook.getSheetAt(4);
            org.apache.poi.ss.usermodel.Cell cell = null;
            
            //Update Kedatangan
            writeDataKedatangan(workbook, sheet2, month, year); 
            dataDesa(workbook, sheet2, month); 
            
            //Update Kelahiran
            writeDataKelahiran(workbook, sheet1, month, year); 
            dataDesa(workbook, sheet1, month); 
            
            //Update Kematian
            writeDataKematian(workbook, sheet, month, year); 
            dataDesa(workbook, sheet, month); 
            
            //Update Pindah
            writeDataPindah(workbook, sheet3, month, year); 
            dataDesa(workbook, sheet3, month);
            
            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("D:\\Laporan Penduduk\\"+namabulann[month]+" "+tahun+".xlsx"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dataDesa(XSSFWorkbook workbook, XSSFSheet sheet, Integer month) throws SQLException{
        String sql = "select * from profil_desa";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            String desa = res.getString("desa");
            String kec = res.getString("kecamatan");
            String kab = res.getString("kabupaten");
            String prov = res.getString("provinsi"); 
            
            org.apache.poi.ss.usermodel.Row tgl = sheet.createRow(1);
            org.apache.poi.ss.usermodel.Row rowd = sheet.createRow(3);
            org.apache.poi.ss.usermodel.Row rowkec = sheet.createRow(4);
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            
            org.apache.poi.ss.usermodel.Cell cell = tgl.createCell(6);
            cell.setCellValue("PERIODE : "+namabulann[month]+" "+tahun);
            cell.setCellStyle(style);

            cell = rowd.createCell(0);
            cell.setCellValue("DESA                        : "+desa);

            cell = rowkec.createCell(0);
            cell.setCellValue("KECAMATAN        : "+kec);

            cell = rowd.createCell(11);
            cell.setCellValue("KABUPATEN     : "+kab);

            cell = rowkec.createCell(11);
            cell.setCellValue("PROVINSI          : "+prov);
        }
    }
    public void dataDesa1(XSSFWorkbook workbook, XSSFSheet sheet, Integer month) throws SQLException{
        String sql = "select * from profil_desa";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            String desa = res.getString("desa");
            String kec = res.getString("kecamatan");
            String kab = res.getString("kabupaten");
            String prov = res.getString("provinsi"); 
            
            org.apache.poi.ss.usermodel.Row tgl = sheet.createRow(1);
            org.apache.poi.ss.usermodel.Row rowd = sheet.createRow(3);
            org.apache.poi.ss.usermodel.Row rowkec = sheet.createRow(4);
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            
            org.apache.poi.ss.usermodel.Cell cell = tgl.createCell(8);
            cell.setCellValue("PERIODE : "+namabulann[month]+" "+tahun);
            cell.setCellStyle(style);

            cell = rowd.createCell(0);
            cell.setCellValue("DESA                        : "+desa);

            cell = rowkec.createCell(0);
            cell.setCellValue("KECAMATAN        : "+kec);

            cell = rowd.createCell(13);
            cell.setCellValue("KABUPATEN     : "+kab);

            cell = rowkec.createCell(13);
            cell.setCellValue("PROVINSI          : "+prov);
        }
    }
    private void writeDataKematian(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year) throws SQLException {
        month += 1;
        String sql = "SELECT * FROM kematian WHERE MONTH(tgl_lapor) = '"+month+"' AND YEAR(tgl_lapor) = '"+year+"' order by tgl_lapor asc";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int rowCount = 8;
        int no = 1;
        
        while (res.next()) {
            String NIK = res.getString("nik");
            String Nama = res.getString("nama");
            String jk = res.getString("jk");
            String tl = res.getString("tl");
            String tgl_lahir = format2.format(res.getDate("tgl_lahir"));
            String gol_dar = res.getString("gol_dar");
            String no_agama = res.getString("no_agama");
            String no_shdrt = res.getString("no_shdrt");
            String no_pekerjaan = res.getString("no_pekerjaan");
            String ayah = res.getString("ayah");
            String ibu = res.getString("ibu");
            String tgl_kematian = format2.format(res.getDate("tgl_kematian"));
            String tgl_lapor = format2.format(res.getDate("tgl_lapor"));
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);           
 
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            //no
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount++);         
            cell.setCellValue(no);
            cell.setCellStyle(style);
            no +=1;
            
            //nik
            cell = row.createCell(columnCount++);
            cell.setCellValue(NIK);
 
            //nama
            cell = row.createCell(columnCount++);
            cell.setCellValue(Nama);
            
            //jk
            cell = row.createCell(columnCount++);
            cell.setCellValue(jk);
            cell.setCellStyle(style);
            
            //tl
            cell = row.createCell(columnCount++);
            cell.setCellValue(tl);
            
            //tgl_lahir
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_lahir);
            cell.setCellStyle(style);
            
            //gol_dar
            cell = row.createCell(columnCount++);
            cell.setCellValue(gol_dar);
            cell.setCellStyle(style);
            
            //no_agama
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_agama);
            cell.setCellStyle(style);
            
            //no_shdrt
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_shdrt);
            cell.setCellStyle(style);
            
            //no_pekerjaan
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_pekerjaan);
            cell.setCellStyle(style);
            
            //ibu
            cell = row.createCell(columnCount++);
            cell.setCellValue(ibu);
            
            //ayah
            cell = row.createCell(columnCount++);
            cell.setCellValue(ayah);

            //tgl_kematian
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_kematian);
            cell.setCellStyle(style);
            
            //tgl_lapor
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_lapor);
            cell.setCellStyle(style);
        }
        bawahan(rowCount, sheet, workbook);
    }
    private void PerkembanganKematian(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year, org.apache.poi.ss.usermodel.Row row) throws SQLException {
        //kematian
        String sql = "SELECT SUM(CASE WHEN jk = '1' THEN 1 ELSE 0 END) AS MaleCount, SUM(CASE WHEN jk = '2' THEN 1 ELSE 0 END) AS FemaleCount, COUNT(jk) AS total FROM kematian WHERE MONTH(tgl_lapor) = '"+month+"' AND YEAR(tgl_lapor) = '"+year+"'";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int columnCount = 6;
        while (res.next()) {
            String laki = res.getString(1);
            String cewe = res.getString(2);
            String total = res.getString(3);
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont font1 = workbook.createFont();
            font1.setBold(true);
            style.setFont(font1);
            row.setHeight((short)1200);
            //laki
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount++);         
            cell.setCellValue(laki);
            cell.setCellStyle(style);
            //cewe
            cell = row.createCell(columnCount++);
            cell.setCellValue(cewe);
            cell.setCellStyle(style);
            //total
            cell = row.createCell(columnCount++);
            cell.setCellValue(total);
            cell.setCellStyle(style);
        }
    }
     private void PerkembanganPindah(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year, org.apache.poi.ss.usermodel.Row row) throws SQLException {
        //pindah
        String sql1 = "SELECT SUM(CASE WHEN jk = '1' THEN 1 ELSE 0 END) AS MaleCount, SUM(CASE WHEN jk = '2' THEN 1 ELSE 0 END) AS FemaleCount, COUNT(jk) AS total FROM pindah WHERE MONTH(tgl_pindah) = '"+month+"' AND YEAR(tgl_pindah) = '"+year+"'";
        java.sql.Connection conn1 = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm1 = conn1.createStatement();
        ResultSet res1 = stm1.executeQuery(sql1);
        int columnCount1 = 9;
        while (res1.next()) {
            String laki = res1.getString(1);
            String cewe = res1.getString(2);
            String total = res1.getString(3);
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont font1 = workbook.createFont();
            font1.setBold(true);
            style.setFont(font1);
            row.setHeight((short)1200);
            //laki
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount1++);         
            cell.setCellValue(laki);
            cell.setCellStyle(style);
            //cewe
            cell = row.createCell(columnCount1++);
            cell.setCellValue(cewe);
            cell.setCellStyle(style);
            //total
            cell = row.createCell(columnCount1++);
            cell.setCellValue(total);
            cell.setCellStyle(style);
        }
     }
      private void PerkembanganKedatangan(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year, org.apache.poi.ss.usermodel.Row row) throws SQLException {
        //kedatangan
        String sql2 = "SELECT SUM(CASE WHEN jk = '1' THEN 1 ELSE 0 END) AS MaleCount, SUM(CASE WHEN jk = '2' THEN 1 ELSE 0 END) AS FemaleCount, COUNT(jk) AS total FROM kedatangan WHERE MONTH(tgl_entry) = '"+month+"' AND YEAR(tgl_entry) = '"+year+"'";
        java.sql.Connection conn2 = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm2 = conn2.createStatement();
        ResultSet res2 = stm2.executeQuery(sql2);
        int columnCount2 = 12;
        while (res2.next()) {
            String laki = res2.getString(1);
            String cewe = res2.getString(2);
            String total = res2.getString(3);
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont font1 = workbook.createFont();
            font1.setBold(true);
            style.setFont(font1);
            row.setHeight((short)1200);
            //laki
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount2++);         
            cell.setCellValue(laki);
            cell.setCellStyle(style);
            //cewe
            cell = row.createCell(columnCount2++);
            cell.setCellValue(cewe);
            cell.setCellStyle(style);
            //total
            cell = row.createCell(columnCount2++);
            cell.setCellValue(total);
            cell.setCellStyle(style);
        }
      }
       private void PerkembanganKelahiran(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year, org.apache.poi.ss.usermodel.Row row) throws SQLException {
        //kelahiran
        String sql3 = "SELECT SUM(CASE WHEN jk = '1' THEN 1 ELSE 0 END) AS MaleCount, SUM(CASE WHEN jk = '2' THEN 1 ELSE 0 END) AS FemaleCount, COUNT(jk) AS total FROM kelahiran WHERE MONTH(tgl_lahir) = '"+month+"' AND YEAR(tgl_lahir) = '"+year+"'";
        java.sql.Connection conn3 = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm3 = conn3.createStatement();
        ResultSet res3 = stm3.executeQuery(sql3);
        int columnCount3 = 3;
        while (res3.next()) {
            String laki = res3.getString(1);
            String cewe = res3.getString(2);
            String total = res3.getString(3);
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER); 
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont font1 = workbook.createFont();
            font1.setBold(true);
            style.setFont(font1);
            row.setHeight((short)1200);
            //laki
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount3++);         
            cell.setCellValue(laki);
            cell.setCellStyle(style);
            //cewe
            cell = row.createCell(columnCount3++);
            cell.setCellValue(cewe);
            cell.setCellStyle(style);
            //total
            cell = row.createCell(columnCount3++);
            cell.setCellValue(total);
            cell.setCellStyle(style);
        }
    }
    private void writeDataPerkembangan(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year) throws SQLException {
        month += 1;
        int rowCount = 10;
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(9);
        PerkembanganKematian( workbook, sheet, month, year, row);
        PerkembanganPindah( workbook, sheet, month, year, row);
        PerkembanganKedatangan( workbook, sheet, month, year, row);
        PerkembanganKelahiran( workbook, sheet, month, year, row);
        bawahan1(rowCount, sheet, workbook);
    }
    private void writeDataPindah(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year) throws SQLException {
        month += 1;
        String sql = "SELECT * FROM pindah WHERE MONTH(tgl_pindah) = '"+month+"' AND YEAR(tgl_pindah) = '"+year+"' order by tgl_pindah asc";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int rowCount = 8;
        int no = 1;
        
        while (res.next()) {
            String no_kk = res.getString("no_kk");
            String NIK = res.getString("nik");
            String Nama = res.getString("nama");
            String jk = res.getString("jk");
            String tl = res.getString("tl");
            String tgl_lahir = format2.format(res.getDate("tgl_lahir"));
            String gol_dar = res.getString("gol_dar");
            String no_agama = res.getString("no_agama");
            String no_shdrt = res.getString("no_shdrt");
            String no_pekerjaan = res.getString("no_pekerjaan");
            String ayah = res.getString("ayah");
            String ibu = res.getString("ibu");
            String tgl_pindah = format2.format(res.getDate("tgl_pindah"));
            String tgl_entry = format2.format(res.getDate("tgl_update"));
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);           
 
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            //no
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount++);         
            cell.setCellValue(no);
            cell.setCellStyle(style);
            no +=1;
            
            //no kk
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_kk);
            
            //nik
            cell = row.createCell(columnCount++);
            cell.setCellValue(NIK);
 
            //nama
            cell = row.createCell(columnCount++);
            cell.setCellValue(Nama);
            
            //jk
            cell = row.createCell(columnCount++);
            cell.setCellValue(jk);
            cell.setCellStyle(style);
            
            //tl
            cell = row.createCell(columnCount++);
            cell.setCellValue(tl);
            
            //tgl_lahir
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_lahir);
            cell.setCellStyle(style);
            
            //gol_dar
            cell = row.createCell(columnCount++);
            cell.setCellValue(gol_dar);
            cell.setCellStyle(style);
            
            //no_agama
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_agama);
            cell.setCellStyle(style);
            
            //no_shdrt
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_shdrt);
            cell.setCellStyle(style);
            
            //no_pekerjaan
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_pekerjaan);
            cell.setCellStyle(style);
            
            //ibu
            cell = row.createCell(columnCount++);
            cell.setCellValue(ibu);
            
            //ayah
            cell = row.createCell(columnCount++);
            cell.setCellValue(ayah);

            //tgl_kematian
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_pindah);
            cell.setCellStyle(style);
            
            //tgl_lapor
            if (tgl_entry != "01/01/1000"){
                tgl_entry ="";
                cell = row.createCell(columnCount++);
                cell.setCellValue(tgl_entry);
                cell.setCellStyle(style);
            }else{
                cell = row.createCell(columnCount++);
                cell.setCellValue(tgl_entry);
                cell.setCellStyle(style);
            }
            
        }
        bawahan(rowCount, sheet, workbook);
    }
    private void writeDataKelahiran(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year) throws SQLException {
        month += 1;
        String sql = "SELECT * FROM kelahiran WHERE MONTH(tgl_entry) = '"+month+"' AND YEAR(tgl_entry) = '"+year+"' order by tgl_lahir asc";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int rowCount = 8;
        int no = 1;
        
        while (res.next()) {
            String no_kk = res.getString("no_kk");
            String NIK = res.getString("nik");
            String Nama = res.getString("nama");
            String jk = res.getString("jk");
            String tl = res.getString("tl");
            String tgl_lahir = format2.format(res.getDate("tgl_lahir"));
            String gol_dar = res.getString("gol_dar");
            String no_agama = res.getString("no_agama");
            String no_shdrt = res.getString("no_shdrt");
            String ayah = res.getString("ayah");
            String ibu = res.getString("ibu");
            String tgl_entry = format2.format(res.getDate("tgl_entry"));
            String ket = res.getString("ket");
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);           
 
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            //no
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount++);         
            cell.setCellValue(no);
            cell.setCellStyle(style);
            no +=1;
            
            //no_kk
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_kk);
            
            //nik
            cell = row.createCell(columnCount++);
            cell.setCellValue(NIK);
 
            //nama
            cell = row.createCell(columnCount++);
            cell.setCellValue(Nama);
            
            //jk
            cell = row.createCell(columnCount++);
            cell.setCellValue(jk);
            cell.setCellStyle(style);
            
            //tl
            cell = row.createCell(columnCount++);
            cell.setCellValue(tl);
            
            //tgl_lahir
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_lahir);
            cell.setCellStyle(style);
            
            //gol_dar
            cell = row.createCell(columnCount++);
            cell.setCellValue(gol_dar);
            cell.setCellStyle(style);
            
            //no_agama
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_agama);
            cell.setCellStyle(style);
            
            //no_shdrt
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_shdrt);
            cell.setCellStyle(style);
            
            //ibu
            cell = row.createCell(columnCount++);
            cell.setCellValue(ibu);
            
            //ayah
            cell = row.createCell(columnCount++);
            cell.setCellValue(ayah);
            
            //tgl_lapor
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_entry);
            cell.setCellStyle(style);
            
            //ket
            cell = row.createCell(columnCount++);
            cell.setCellValue(ket);
        }
        bawahan(rowCount, sheet, workbook);
    }
    private void writeDataKedatangan(XSSFWorkbook workbook, XSSFSheet sheet, Integer month, Integer year) throws SQLException {
        month += 1;
        String sql = "SELECT * FROM kedatangan WHERE MONTH(tgl_entry) = '"+month+"' AND YEAR(tgl_entry) = '"+year+"' order by tgl_entry asc";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int rowCount = 8;
        int no = 1;
        
        while (res.next()) {
            String no_kk = res.getString("no_kk");
            String NIK = res.getString("nik");
            String Nama = res.getString("nama");
            String jk = res.getString("jk");
            String tl = res.getString("tl");
            String tgl_lahir = format2.format(res.getDate("tgl_lahir"));
            String gol_dar = res.getString("gol_dar");
            String no_agama = res.getString("no_agama");
            String no_shdrt = res.getString("no_shdrt");
            String ayah = res.getString("ayah");
            String ibu = res.getString("ibu");
            String tgl_entry = format2.format(res.getDate("tgl_entry"));
            String ket = res.getString("ket");
            
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);           
 
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            //no
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount++);         
            cell.setCellValue(no);
            cell.setCellStyle(style);
            no +=1;
            
            //no_kk
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_kk);
            
            //nik
            cell = row.createCell(columnCount++);
            cell.setCellValue(NIK);
 
            //nama
            cell = row.createCell(columnCount++);
            cell.setCellValue(Nama);
            
            //jk
            cell = row.createCell(columnCount++);
            cell.setCellValue(jk);
            cell.setCellStyle(style);
            
            //tl
            cell = row.createCell(columnCount++);
            cell.setCellValue(tl);
            
            //tgl_lahir
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_lahir);
            cell.setCellStyle(style);
            
            //gol_dar
            cell = row.createCell(columnCount++);
            cell.setCellValue(gol_dar);
            cell.setCellStyle(style);
            
            //no_agama
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_agama);
            cell.setCellStyle(style);
            
            //no_shdrt
            cell = row.createCell(columnCount++);
            cell.setCellValue(no_shdrt);
            cell.setCellStyle(style);
            
            //ibu
            cell = row.createCell(columnCount++);
            cell.setCellValue(ibu);
            
            //ayah
            cell = row.createCell(columnCount++);
            cell.setCellValue(ayah);
            
            //tgl_lapor
            cell = row.createCell(columnCount++);
            cell.setCellValue(tgl_entry);
            cell.setCellStyle(style);
            
            //ket
            cell = row.createCell(columnCount++);
            cell.setCellValue(ket);
        }
        bawahan(rowCount, sheet, workbook);
    }
    public void bawahan(Integer Row, XSSFSheet sheet, XSSFWorkbook workbook) throws SQLException{
        Integer Row1 ,Row2;
        
        //kepala desa sindangpakuon
        String sql = "SELECT * FROM petugas WHERE jabatan = 'Kepala Desa Sindangpakuon'";
        String sql1 = "SELECT * FROM petugas WHERE jabatan = 'Petugas Registrasi'";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        java.sql.Connection conn1 = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm1 = conn1.createStatement();
        ResultSet res = stm.executeQuery(sql);
        ResultSet res1 = stm1.executeQuery(sql1);
        
        //style satu
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setUnderline(FontUnderline.SINGLE);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        //style dua
        CellStyle style1 = workbook.createCellStyle();
        XSSFFont font1 = workbook.createFont();
        font1.setBold(true);
        style1.setFont(font1);
        style1.setAlignment(HorizontalAlignment.CENTER);
            
        //style tiga
        CellStyle style2 = workbook.createCellStyle();
        XSSFFont font2 = workbook.createFont();
        style2.setAlignment(HorizontalAlignment.CENTER);

        Row +=2;
        Row1 = Row + 1;
        Row2= Row1 + 3;
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(Row);
        org.apache.poi.ss.usermodel.Row row1 = sheet.createRow(Row1);
        org.apache.poi.ss.usermodel.Row row2 = sheet.createRow(Row2);
            
        if (res.next()) {
            //mengetahui
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(2);
            cell.setCellValue("Mengetahui :");
            cell.setCellStyle(style1);

            //jabatan
            org.apache.poi.ss.usermodel.Cell cell1 = row1.createCell(2);
            cell1.setCellValue("Kepala Desa Sindangpakuon");
            cell1.setCellStyle(style2);
            
            //mengetahui
            org.apache.poi.ss.usermodel.Cell cell2 = row2.createCell(2);
            cell2.setCellValue(res.getString("nama"));
            cell2.setCellStyle(style);
        }
        if(res1.next()){
            //tgl
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(10);
            cell.setCellValue("Sumedang, "+hari+" "+namabulan[bulan]+" "+tahun);
            cell.setCellStyle(style2);
            
            //tgl
            org.apache.poi.ss.usermodel.Cell cell1 = row1.createCell(10);
            cell1.setCellValue("Petugas Registrasi");
            cell1.setCellStyle(style1);
            
            //tgl
            org.apache.poi.ss.usermodel.Cell cell2 = row2.createCell(10);
            cell2.setCellValue(res1.getString("nama"));
            cell2.setCellStyle(style);
            
        }
    }
    public void bawahan1(Integer Row, XSSFSheet sheet, XSSFWorkbook workbook) throws SQLException{
        Integer Row1 ,Row2;
        
        //kepala desa sindangpakuon
        String sql = "SELECT * FROM petugas WHERE jabatan = 'Kepala Desa Sindangpakuon'";
        String sql1 = "SELECT * FROM petugas WHERE jabatan = 'Petugas Registrasi'";
        java.sql.Connection conn = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm = conn.createStatement();
        java.sql.Connection conn1 = (java.sql.Connection) DBConfig.getDatabase();
        java.sql.Statement stm1 = conn1.createStatement();
        ResultSet res = stm.executeQuery(sql);
        ResultSet res1 = stm1.executeQuery(sql1);
        
        //style satu
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setUnderline(FontUnderline.SINGLE);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        //style dua
        CellStyle style1 = workbook.createCellStyle();
        XSSFFont font1 = workbook.createFont();
        font1.setBold(true);
        style1.setFont(font1);
        style1.setAlignment(HorizontalAlignment.CENTER);
            
        //style tiga
        CellStyle style2 = workbook.createCellStyle();
        XSSFFont font2 = workbook.createFont();
        style2.setAlignment(HorizontalAlignment.CENTER);

        Row +=2;
        Row1 = Row + 1;
        Row2= Row1 + 3;
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(Row);
        org.apache.poi.ss.usermodel.Row row1 = sheet.createRow(Row1);
        org.apache.poi.ss.usermodel.Row row2 = sheet.createRow(Row2);
            
        if (res.next()) {
            //mengetahui
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(3);
            cell.setCellValue("Mengetahui :");
            cell.setCellStyle(style1);

            //jabatan
            org.apache.poi.ss.usermodel.Cell cell1 = row1.createCell(3);
            cell1.setCellValue("Kepala Desa Sindangpakuon");
            cell1.setCellStyle(style2);
            
            //mengetahui
            org.apache.poi.ss.usermodel.Cell cell2 = row2.createCell(3);
            cell2.setCellValue(res.getString("nama"));
            cell2.setCellStyle(style);
        }
        if(res1.next()){
            //tgl
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(13);
            cell.setCellValue("Sumedang, "+hari+" "+namabulan[bulan]+" "+tahun);
            cell.setCellStyle(style2);
            
            //tgl
            org.apache.poi.ss.usermodel.Cell cell1 = row1.createCell(13);
            cell1.setCellValue("Petugas Registrasi");
            cell1.setCellStyle(style1);
            
            //tgl
            org.apache.poi.ss.usermodel.Cell cell2 = row2.createCell(13);
            cell2.setCellValue(res1.getString("nama"));
            cell2.setCellStyle(style);
            
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

        txtmonth = new com.toedter.calendar.JMonthChooser();
        txtyear = new com.toedter.calendar.JYearChooser();
        btndownload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btndownload.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btndownload.setText("Download");
        btndownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndownloadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Export Data ke Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btndownload)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndownload))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 210));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btndownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndownloadActionPerformed
        try {
            Integer month, year, hasil; 
            month = txtmonth.getMonth();
            year = txtyear.getYear();
            
            export(month, year);
            JOptionPane.showMessageDialog(null, "Export Data Selesai");
        } catch (SQLException ex) {
            Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndownloadActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndownload;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JMonthChooser txtmonth;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
