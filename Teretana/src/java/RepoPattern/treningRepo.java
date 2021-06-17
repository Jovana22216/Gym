/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;

import DAO.treningDAO;
import Models.Trening;
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
public class treningRepo implements treningDAO {

    Connection con;

    public treningRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        String URL = "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean insert(Trening trening) throws SQLException {
        String insert = "INSERT INTO `trening`( teretanaId, datum, vreme, trajanje, opis, cena) "
                + "VALUES (?,?,?,?,?,?) ";
        try {
            PreparedStatement pst = con.prepareStatement(insert);

            pst.setInt(1, trening.getTeretanaId());
            pst.setString(2, trening.getDatum());
            pst.setString(3, trening.getVreme());
            pst.setString(4, trening.getTrajanje());
            pst.setString(5, trening.getOpis());
            pst.setInt(6, trening.getCena());

            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Trening> lista() throws SQLException {

        ArrayList<Trening> treninzi = new ArrayList<>();
        try {

            String select = "select *from trening";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                Trening trening = new Trening();
                trening.setTreningId(rs.getInt("treningId"));
                trening.setTeretanaId(rs.getInt("teretanaId"));
                trening.setDatum(rs.getString("datum"));
                trening.setVreme(rs.getString("vreme"));
                trening.setTrajanje(rs.getString("trajanje"));
                trening.setOpis(rs.getString("opis"));
                trening.setCena(rs.getInt("cena"));

                treninzi.add(trening);
            }

        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return treninzi;

    }

    @Override
    public Trening select(String Id) throws SQLException {

        Trening trening = new Trening();
        try {
            String select = "select * from trening where treningId = " + Id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                trening.setTreningId(rs.getInt("treningId"));
                trening.setTeretanaId(rs.getInt("teretanaId"));
                trening.setDatum(rs.getString("datum"));
                trening.setVreme(rs.getString("vreme"));
                trening.setTrajanje(rs.getString("trajanje"));
                trening.setOpis(rs.getString("opis"));
                trening.setCena(rs.getInt("cena"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return trening;

    }

    @Override
    public boolean update(Trening trening) throws SQLException, IOException {

        try {

            String update = "UPDATE trening SET datum = ?,vreme = ?, trajanje = ?, opis = ?, cena = ? where treningId = ?";

            PreparedStatement pst = con.prepareStatement(update);

            pst.setString(1, trening.getDatum());
            pst.setString(2, trening.getVreme());
            pst.setString(3, trening.getTrajanje());
            pst.setString(4, trening.getOpis());
            pst.setInt(5, trening.getCena());
            pst.setInt(6, trening.getTreningId());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public void brisanje(String Id) throws SQLException {
        try {

            String delete = "delete from  trening where treningId = " + Id;
            PreparedStatement ps = con.prepareStatement(delete);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<Trening> listaSelektovaneTeretane(String id) throws SQLException {

        ArrayList<Trening> tr = new ArrayList<>();
        try {

            String select = "select * from trening where datum >= date(now()) and teretanaId = " + id;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                Trening trening = new Trening();
                trening.setTreningId(rs.getInt("treningId"));
                trening.setTeretanaId(Integer.parseInt(rs.getString("teretanaId")));
                trening.setDatum(rs.getString("datum"));
                trening.setVreme(rs.getString("vreme"));
                trening.setTrajanje(rs.getString("trajanje"));
                trening.setOpis(rs.getString("opis"));
                trening.setCena(rs.getInt("cena"));

                tr.add(trening);
            }

        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return tr;

    }

    @Override
    public Trening selectById(String id) throws SQLException {

        Trening trening = new Trening();
        try {
            String select = "select * from trening where treningId = '" + id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                trening.setTreningId(rs.getInt("treningId"));
                trening.setTeretanaId(rs.getInt("teretanaId"));
                trening.setDatum(rs.getString("datum"));
                trening.setVreme(rs.getString("vreme"));
                trening.setTrajanje(rs.getString("trajanje"));
                trening.setOpis(rs.getString("opis"));
                trening.setCena(rs.getInt("cena"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(treningRepo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return trening;

    }

}
