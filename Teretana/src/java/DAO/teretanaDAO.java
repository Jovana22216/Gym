/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Teretana;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jovana
 */
public interface teretanaDAO {
    
    boolean insert(Teretana teretana, Part part) throws SQLException;
    void fotografije(HttpServletRequest request, HttpServletResponse response, String teretanaId)
            throws ServletException, IOException, SQLException ;
    ArrayList<Teretana> lista() throws SQLException;
    Teretana select(String Id) throws SQLException;
    boolean update(Teretana teretana, Part part) throws SQLException, IOException;
    void brisanje (String Id) throws SQLException;
     Teretana selectByUsername(String username) throws SQLException;

}
