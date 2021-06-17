/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;

import Controllers.BrisanjeRezervacije;
import DAO.rezervacijaDAO;
import Models.Rezervacija;
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
public class rezervacijaRepo implements rezervacijaDAO {

    Connection con;

    public rezervacijaRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        String URL = "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean insert(Rezervacija rezervacija) throws SQLException {

        String insert = "INSERT INTO `rezervacija`(`korisnikId`,`treningId`,`status`,`teretanaId`,`placeno`)"
                + " VALUES (?,?,?,?,?)";
        try {

            PreparedStatement pst = con.prepareStatement(insert);

            pst.setInt(1, rezervacija.getKorisnikId());
            pst.setInt(2, rezervacija.getTreningId());
            pst.setBoolean(3, rezervacija.getStatus());
            pst.setInt(4, rezervacija.getTeretanaId());
            pst.setBoolean(5, rezervacija.getPlaceno());

            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    @Override
    public ArrayList<Rezervacija> aktivneRezervacije(String Id) throws SQLException {

        ArrayList<Rezervacija> rezervacije = new ArrayList<>();
        /*  Statement st;
         try {
         String upit = "select r.rezervacijaId, t.datum,t.vreme, r.status"
         + " from  rezervacija r join trening t on r.treningId= t.treningId"
         + "where r.status = 1 and "
         + "(t.datum >= date(now()) and t.vreme > time(now()) "
         + "and t.treningId = " + Id;

         st = con.createStatement();
         ResultSet rs = st.executeQuery(upit);

         while (rs.next()) {
         Rezervacija rezervacija = new Rezervacija();
         rezervacija.setRezervacijaId(rs.getInt("rezervacijaId"));
         rezervacija.trening.setDatum(rs.getString("datum"));
         rezervacija.trening.setVreme(rs.getString("vreme"));
         rezervacija.setStatus(rs.getBoolean("status"));
         rezervacije.add(rezervacija);
         }

         } catch (SQLException ex) {
         Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
         con.close();
         }*/

        return rezervacije;

    }

    @Override
    @SuppressWarnings("empty-statement")
    public ArrayList<Rezervacija> lista() throws SQLException {

        ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        try {

            String select = "select r.rezervacijaId, r.teretanaId, k.imeKorisnika as 'ime', t.datum as 'datum', t.vreme as 'vreme', t.trajanje as 'trajanje', t.opis as 'opis', t.cena as 'cena',r.placeno,  r.status "
                    + " from rezervacija r  join korisnik k on r.korisnikId = k.korisnikId join trening t on r.treningId = t.treningId  where t.datum > date(now())";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setRezervacijaId(rs.getInt("rezervacijaId"));
                rezervacija.setTeretanaId(rs.getInt("teretanaId"));
                //rezervacija.teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                rezervacija.korisnik.setImeKorisnika(rs.getString("ime"));
                rezervacija.trening.setDatum(rs.getString("datum"));
                rezervacija.trening.setVreme(rs.getString("vreme"));
                rezervacija.trening.setTrajanje(rs.getString("trajanje"));
                rezervacija.trening.setOpis(rs.getString("opis"));
                rezervacija.trening.setCena(rs.getInt("cena"));
                rezervacija.setPlaceno(rs.getBoolean("placeno"));
                rezervacija.setStatus(rs.getBoolean("status"));
                rezervacije.add(rezervacija);
            }

        } catch (SQLException ex) {
            Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return rezervacije;
    }

    @Override
    public boolean brisanje(String Id) throws SQLException {

        try {
            String delete = "delete from  rezervacija where rezervacijaId = " + Id;

            PreparedStatement psDelete = con.prepareStatement(delete);

            psDelete.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BrisanjeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    @Override
    public boolean aktivnaRezervacija(Integer Id) throws SQLException {
        /* Statement st;
         try {

         String upit = "select rezervacijaId "
         + "from rezervacija "
         + "where datum >= date(now()) and rezervacijaId = " + Id;

         st = con.createStatement();
         ResultSet rs = st.executeQuery(upit);

         if (rs.next()) {
         return true;
         }

         } catch (SQLException ex) {
         Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
         return false;
         } finally {
         con.close();
         }
         */
        return false;

    }

    @Override
    public boolean isteklaRezervacija(Integer Id) throws SQLException {

        /*   Statement st;
         try {

         String upit = "select rezervacijaId "
         + "from rezervacija "
         + "where datum < date(now()) and rezervacijaId = " + Id;

         st = con.createStatement();
         ResultSet rs = st.executeQuery(upit);

         if (rs.next()) {
         return true;
         }

         } catch (SQLException ex) {
         Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
         return false;
         } finally {
         con.close();
         }*/
        return false;

    }

    @Override
    @SuppressWarnings("empty-statement")
    public ArrayList<Rezervacija> listaAktivnih() throws SQLException {

        ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        try {

            String select = "select r.rezervacijaId,k.korisnikId, k.imeKorisnika as 'ime', t.datum as 'datum', t.vreme as 'vreme', t.trajanje as 'trajanje', t.opis as 'opis',t.cena as 'cena',r.placeno, r.status "
                    + " from rezervacija r join korisnik k on r.korisnikId = k.korisnikId join trening t on r.treningId = t.treningId  where t.datum > date(now())  ";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setRezervacijaId(rs.getInt("rezervacijaId"));
               // rezervacija.setTeretanaId(rs.getInt("teretanaId"));
                // rezervacija.teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                rezervacija.setKorisnikId(rs.getInt("korisnikId"));
                rezervacija.korisnik.setImeKorisnika(rs.getString("ime"));
                rezervacija.trening.setDatum(rs.getString("datum"));
                rezervacija.trening.setVreme(rs.getString("vreme"));
                rezervacija.trening.setTrajanje(rs.getString("trajanje"));
                rezervacija.trening.setOpis(rs.getString("opis"));
                rezervacija.trening.setCena(rs.getInt("cena"));
                rezervacija.setPlaceno(rs.getBoolean("placeno"));
                rezervacija.setStatus(rs.getBoolean("status"));
                rezervacije.add(rezervacija);
            }

        } catch (SQLException ex) {
            Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return rezervacije;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public ArrayList<Rezervacija> listaIsteklih() throws SQLException {

        ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        try {

            String select = "select r.rezervacijaId,k.korisnikId, k.imeKorisnika as 'ime', t.datum as 'datum', t.vreme as 'vreme', t.trajanje as 'trajanje', t.opis as 'opis',t.cena as 'cena',r.placeno, r.status "
                    + " from rezervacija r join korisnik k on r.korisnikId = k.korisnikId join trening t on r.treningId = t.treningId where t.datum < date(now()) ";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setRezervacijaId(rs.getInt("rezervacijaId"));
                // rezervacija.setTeretanaId(rs.getInt("teretanaId"));
                //rezervacija.teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                rezervacija.setKorisnikId(rs.getInt("korisnikId"));
                rezervacija.korisnik.setImeKorisnika(rs.getString("ime"));
                rezervacija.trening.setDatum(rs.getString("datum"));
                rezervacija.trening.setVreme(rs.getString("vreme"));
                rezervacija.trening.setTrajanje(rs.getString("trajanje"));
                rezervacija.trening.setOpis(rs.getString("opis"));
                rezervacija.trening.setCena(rs.getInt("cena"));
                rezervacija.setPlaceno(rs.getBoolean("placeno"));
                rezervacija.setStatus(rs.getBoolean("status"));
                rezervacije.add(rezervacija);
            }

        } catch (SQLException ex) {
            Logger.getLogger(rezervacijaRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return rezervacije;
    }

    @Override
    public boolean updateRezervacije(Rezervacija rezervacija) throws SQLException {

        try {

            String update = "UPDATE rezervacija SET placeno = ? WHERE rezervacijaId = ?";

            PreparedStatement pst = con.prepareStatement(update);

            pst.setBoolean(1, rezervacija.getPlaceno());
            pst.setInt(2, rezervacija.getRezervacijaId());

            pst.executeUpdate();

             
            return true;
            
        } catch (SQLException e) {
                
            return false;
            
        }
    }
}
