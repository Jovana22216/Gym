/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Korisnik;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public interface korisnikDAO {

    boolean insert(Korisnik korisnik) throws SQLException;

    boolean logovanje(String username, String password) throws SQLException;

    Korisnik select(String Id) throws SQLException;

    Korisnik selectByUsername(String username) throws SQLException;

    String Rola(String username, String password) throws SQLException;

    void brisanje(String Id) throws SQLException;

    ArrayList<Korisnik> lista() throws SQLException;

    boolean update(Korisnik korisnik) throws SQLException;

   boolean promenaLozinke(String username, String staraLozinka, String novaLozinka) throws SQLException;
   
}
