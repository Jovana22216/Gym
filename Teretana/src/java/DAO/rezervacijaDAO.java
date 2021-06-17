/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Rezervacija;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public interface rezervacijaDAO {
    
    boolean insert(Rezervacija rezervacija) throws SQLException;
    //boolean  updateStatusRezervacije(String Id) throws SQLException;
    ArrayList<Rezervacija>  aktivneRezervacije(String Id) throws SQLException;
   // boolean  dostupna(Rezervacija rezervacija) throws SQLException;
    ArrayList<Rezervacija> lista() throws SQLException;
    ArrayList<Rezervacija> listaAktivnih() throws SQLException;
    ArrayList<Rezervacija> listaIsteklih() throws SQLException;
    boolean brisanje(String Id) throws SQLException;
    boolean aktivnaRezervacija(Integer Id) throws SQLException;
   boolean isteklaRezervacija(Integer Id) throws SQLException;
   boolean  updateRezervacije( Rezervacija rezervacija) throws SQLException;
   
}
