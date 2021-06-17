/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Podaci;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public interface podaciDAO {

    boolean insert(Podaci podaci) throws SQLException;

    Podaci select(String Id) throws SQLException;

    ArrayList<Podaci> lista() throws SQLException;
    ArrayList<Podaci> listaPodataka() throws SQLException;

    boolean update(Podaci podaci) throws SQLException, IOException;
    
    void brisanje(String Id) throws SQLException;

}
