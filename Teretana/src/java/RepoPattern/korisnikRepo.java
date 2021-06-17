/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;

import DAO.korisnikDAO;
import Models.Korisnik;
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
public class korisnikRepo implements korisnikDAO{

    Connection con;
    public korisnikRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String URL =  "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    @Override
    public boolean logovanje(String username, String password) throws SQLException {
        
     String provera = "select * from korisnik where korisnickoIme = '" + username+ "'  and sifra = '"+ password+"'";
        
        PreparedStatement pst;        
        try {
            pst = con.prepareStatement(provera);
            ResultSet rs =  pst.executeQuery(provera);
            while(rs.next())
                return  true;
        
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
        
       
      
        return false;
    }

    public String Rola(String username, String password) throws SQLException {
    String select = "select rolaId from korisnik where sifra = '"+ password + "' and korisnickoIme = '" + username + "'";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next())
                return rs.getString("rolaId");
            
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
        
        return "Greska";   
    
    }

    @Override
    public Korisnik select(String Id) throws SQLException {
    
            Korisnik korisnik = new Korisnik();
        try {
            String select = "select * from korisnik where korisnikId = " + Id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

             while(rs.next()){
                korisnik.setKorisnikId(rs.getInt("korisnikId"));
                korisnik.setImeKorisnika(rs.getString("imeKorisnika"));
                korisnik.setPrezimeKorisnika(rs.getString("prezimeKorisnika"));
                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                korisnik.setEmail(rs.getString("email"));
                korisnik.setTelefonKorisnika(rs.getString("telefonKorisnika"));
                korisnik.setAdresaKorisnika(rs.getString("adresaKorisnika"));
                korisnik.setGradKorisnika(rs.getString("gradKorisnika"));
                korisnik.setRolaId(rs.getString("rolaId"));
                }
        
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
      
        return korisnik;
    
    }

    @Override
    public Korisnik selectByUsername(String username) throws SQLException {
    
         Korisnik korisnik = new Korisnik();
        try {
            String select = "select * from korisnik where korisnickoIme = '" + username +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                korisnik.setKorisnikId(rs.getInt("korisnikId"));
                korisnik.setImeKorisnika(rs.getString("imeKorisnika"));
                korisnik.setPrezimeKorisnika(rs.getString("prezimeKorisnika"));
                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                korisnik.setEmail(rs.getString("email"));
                korisnik.setTelefonKorisnika(rs.getString("telefonKorisnika"));
                korisnik.setAdresaKorisnika(rs.getString("adresaKorisnika"));
                korisnik.setGradKorisnika(rs.getString("gradKorisnika"));
                korisnik.setRolaId(rs.getString("rolaId"));
                }
        
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
       
      
        return korisnik;
    }

    @Override
    public boolean insert(Korisnik korisnik) throws SQLException {
        
    try {
            String insertToKorisnik = "INSERT INTO `korisnik`(imeKorisnika, prezimeKorisnika, korisnickoIme, sifra, email, telefonKorisnika,"
                    + " adresaKorisnika, gradKorisnika, rolaId)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = con.prepareStatement(insertToKorisnik);
            
            pst.setString(1, korisnik.getImeKorisnika());
            pst.setString(2, korisnik.getPrezimeKorisnika());
            pst.setString(3, korisnik.getKorisnickoIme());
            pst.setString(4, korisnik.getSifra());
            pst.setString(5, korisnik.getEmail());
            pst.setString(6, korisnik.getTelefonKorisnika());
            pst.setString(7, korisnik.getAdresaKorisnika());
            pst.setString(8, korisnik.getGradKorisnika());
            
            pst.setInt(9, 3);
            
            
           pst.executeUpdate();
           
           return true;
        } catch (SQLException e) {
         
        } 
       
        return false;
    
    }

    @Override
    public void brisanje(String Id) throws SQLException {
    
          try {
            String delete = "delete from  korisnik where korisnikId = " + Id;
            PreparedStatement ps  = con.prepareStatement(delete);

            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public ArrayList<Korisnik> lista() throws SQLException {
       
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        try {
           
             String select = "select * from korisnik where rolaId = 3 ";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Korisnik korisnik = new Korisnik();
                 korisnik.setKorisnikId(rs.getInt("korisnikId"));
                 korisnik.setImeKorisnika(rs.getString("imeKorisnika"));
                 korisnik.setPrezimeKorisnika(rs.getString("prezimeKorisnika"));
                 korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                 korisnik.setEmail(rs.getString("email"));
                 korisnik.setTelefonKorisnika(rs.getString("telefonKorisnika"));
                 korisnik.setAdresaKorisnika(rs.getString("adresaKorisnika"));
                 korisnik.setGradKorisnika(rs.getString("gradKorisnika"));
                 korisnik.setRolaId(rs.getString("rolaId"));
                 korisnici.add(korisnik);
             }
 
        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           con.close();
        }
       
        
        
        return korisnici; 
    
    
    }

    @Override
    public boolean update(Korisnik korisnik) throws SQLException {
       
        
       String update = "update korisnik "
                      + "set imeKorisnika = ?,"
                      + "prezimeKorisnika = ?,"
                      + "korisnickoIme = ?,"
                      + "email = ?,"
                      + "telefonKorisnika = ?,"
                      + "adresaKorisnika = ?,"
                      + "gradKorisnika = ? "
                      + " where korisnikId = ?";
         
        try {
           
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, korisnik.getImeKorisnika());
            pst.setString(2, korisnik.getPrezimeKorisnika());
            pst.setString(3, korisnik.getKorisnickoIme());
            pst.setString(4, korisnik.getEmail());
            pst.setString(5, korisnik.getTelefonKorisnika());
            pst.setString(6, korisnik.getAdresaKorisnika());
            pst.setString(7, korisnik.getGradKorisnika()); 
            
            
                pst.setInt(8, korisnik.getKorisnikId());
           

            pst.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            
          return false;
          
        }
    }

      @Override
    public boolean promenaLozinke(String username, String staraLozinka, String novaLozinka) throws SQLException {
        String select = "select sifra from korisnik where korisnickoIme = '" + username + "' and sifra = '" + staraLozinka + "'";
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            if (rs.next()) {
                String update = "update korisnik set sifra = '" + novaLozinka + "' where korisnickoIme = '" + username + "'";
                st.executeUpdate(update);
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(korisnikRepo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            con.close();
        }
    

    }
    
}
