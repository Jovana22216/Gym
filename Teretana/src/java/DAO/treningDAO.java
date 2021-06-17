/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Trening;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public interface treningDAO {
    
    boolean insert(Trening trening) throws SQLException; 
    ArrayList<Trening> lista() throws SQLException;
    Trening select(String Id) throws SQLException;
    boolean update(Trening trening) throws SQLException, IOException;
    void brisanje (String Id) throws SQLException;
    ArrayList<Trening> listaSelektovaneTeretane(String id) throws SQLException;
    Trening selectById(String id) throws SQLException;
    
   }
