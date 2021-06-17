/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Program;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public interface programDAO {

    boolean insert(Program program) throws SQLException;

    ArrayList<Program> lista() throws SQLException;

    Program select(String Id) throws SQLException;

    boolean update(Program program) throws SQLException;

    void brisanje(String Id) throws SQLException;

   ArrayList<Program> listaRekreacija() throws SQLException;

    ArrayList<Program> listaTreniranje() throws SQLException;

    ArrayList<Program> listaMrsavljenje() throws SQLException;

    ArrayList<Program> listaZatezanje() throws SQLException;
}
