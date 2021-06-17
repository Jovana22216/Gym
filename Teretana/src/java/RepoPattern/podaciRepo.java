/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;

import DAO.podaciDAO;
import Models.Podaci;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana
 */
public class podaciRepo implements podaciDAO {
     Connection con;
    public podaciRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String URL =  "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public boolean insert(Podaci podaci) throws SQLException {
      try {
            String insert = "INSERT INTO `podaci`(korisnikId,zahtev, kilaza, pritisak, aktivnost, pol)"
                   
                    + " VALUES (?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(insert);
            
            pst.setInt(1, podaci.getKorisnikId());
            pst.setString(2, podaci.getZahtev());
            pst.setDouble(3, podaci.getKilaza());
            pst.setString(4, podaci.getPritisak());
            pst.setString(5, podaci.getAktivnost());
            pst.setString(6, podaci.getPol());
            
           pst.executeUpdate();
           
           return true;
        } catch (SQLException e) {
         
        } 
       
        return false;
        
    }

    @Override
    public Podaci select(String Id) throws SQLException {
     Podaci podaci = new Podaci();
        try {
            String select = "select * from podaci where podatakId = " + Id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                podaci.setPodatakId(rs.getInt("podatakId"));
                podaci.setKorisnikId(rs.getInt("korisnikId"));
                podaci.setZahtev(rs.getString("zahtev"));
                podaci.setKilaza(rs.getDouble("kilaza"));
                podaci.setPritisak(rs.getString("pritisak"));
                podaci.setAktivnost(rs.getString("aktivnost"));
                podaci.setPol(rs.getString("pol"));
            }
            
        } catch (SQLException ex) {
           Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
        return podaci;  
    
    }

    @Override
    public ArrayList<Podaci> lista() throws SQLException {
    
        ArrayList<Podaci> podaciLista = new ArrayList<Podaci>();
        try {
           
             String select = "select * from podaci where podatakId=(SELECT MAX(podatakId) FROM podaci) " ;
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                Podaci podaci = new Podaci();
                podaci.setPodatakId(rs.getInt("podatakId"));
                podaci.setKorisnikId(rs.getInt("korisnikId"));
                podaci.setZahtev(rs.getString("zahtev"));
                podaci.setKilaza(rs.getDouble("kilaza"));
                podaci.setPritisak(rs.getString("pritisak"));
                podaci.setAktivnost(rs.getString("aktivnost"));
                podaci.setPol(rs.getString("pol"));
                podaciLista.add(podaci);
             }
 
        } catch (SQLException ex) {
            Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           con.close();
        }
       
    return podaciLista;
    
    
    }

    @Override
    public boolean update(Podaci podaci) throws SQLException, IOException {
     try {

            String update = "UPDATE podaci SET zahtev = ?,kilaza = ?, pritisak = ?, aktivnost = ?, pol = ? where podatakId = ?";

            PreparedStatement pst = con.prepareStatement(update);

            pst.setString(1, podaci.getZahtev());
            pst.setDouble(2, podaci.getKilaza());
            pst.setString(3, podaci.getPritisak());
            pst.setString(4, podaci.getAktivnost());
            pst.setString(5, podaci.getPol());
            pst.setInt(6, podaci.getPodatakId());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }    
    }

    @Override
    public void brisanje(String Id) throws SQLException {
       
     try {
          
            String delete = "delete from  podaci where podatakId = " + Id;
            PreparedStatement ps  = con.prepareStatement(delete);

            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Podaci> listaPodataka() throws SQLException {
     ArrayList<Podaci> podaciLista = new ArrayList<Podaci>();
        try {
           
             String select = "select * from podaci  " ;
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                Podaci podaci = new Podaci();
                podaci.setPodatakId(rs.getInt("podatakId"));
                podaci.setKorisnikId(rs.getInt("korisnikId"));
                podaci.setZahtev(rs.getString("zahtev"));
                podaci.setKilaza(rs.getDouble("kilaza"));
                podaci.setPritisak(rs.getString("pritisak"));
                podaci.setAktivnost(rs.getString("aktivnost"));
                podaci.setPol(rs.getString("pol"));
                podaciLista.add(podaci);
             }
 
        } catch (SQLException ex) {
            Logger.getLogger(podaciRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           con.close();
        }
       
    return podaciLista;
      
    
    }
}
