/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;

import DAO.programDAO;
import Models.Program;
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
public class programRepo implements programDAO{
    
    
    Connection con;
    public programRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String URL =  "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public boolean insert(Program program) throws SQLException {
        
    String insert = "INSERT INTO `program`( `nazivPrograma`, `opis`, `cena`, `trajanje`) "
                        + "VALUES (?,?,?,?) ";
        try {
            PreparedStatement pst = con.prepareStatement(insert);
            
            
            pst.setString(1, program.getNazivPrograma());
            pst.setString(2, program.getOpis());
            pst.setDouble(3, program.getCena());
            pst.setString(4, program.getTrajanje());
            
         
            pst.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            return false;
        }
        
    
    }

    @Override
    public ArrayList<Program> lista() throws SQLException {
        
    ArrayList<Program> programi = new ArrayList<Program>();
        try {
           
             String select = "select *from program";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Program program = new Program();
                 program.setProgramId(rs.getInt("programId"));
                 program.setNazivPrograma(rs.getString("nazivPrograma"));
                 program.setOpis(rs.getString("opis"));
                 program.setCena(rs.getDouble("cena"));
                 program.setTrajanje(rs.getString("trajanje"));
               
                 programi.add(program);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return programi; 
    
    
    }

    @Override
    public Program select(String Id) throws SQLException {
    
         Program program = new Program();
        try {
            String select = "select * from program where programId = " + Id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                program.setProgramId(rs.getInt("programId"));
                program.setNazivPrograma(rs.getString("nazivPrograma"));
                program.setOpis(rs.getString("opis"));
                program.setCena(rs.getDouble("cena"));
                program.setTrajanje(rs.getString("trajanje"));
            }
        } catch (SQLException ex) {
           Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
        return program;
    
    
    
    }

    @Override
    public boolean update(Program program) throws SQLException {
        
        
       
        try {
            
             String update = "UPDATE program SET nazivPrograma = ?,opis = ?,cena = ?,trajanje = ? WHERE programId = ?";      
                
         
            PreparedStatement pst = con.prepareStatement(update);

            pst.setString(1, program.getNazivPrograma());
            pst.setString(2, program.getOpis());
            pst.setDouble(3, program.getCena());
            pst.setString(4, program.getTrajanje());
            pst.setInt(5, program.getProgramId());
            
            pst.executeUpdate();
            
            return true;
           
        } catch (SQLException e) {
          return false;
        }
       
    
    }

    @Override
    public void brisanje(String Id) throws SQLException {
        
    try {
          
            String delete = "delete from  program where programId = " + Id;
            PreparedStatement ps  = con.prepareStatement(delete);

            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Program> listaRekreacija() throws SQLException {
    
         ArrayList<Program> programi = new ArrayList<Program>();
        try {
           
             String select = "select * from program where trajanje = '45'";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Program program = new Program();
                 program.setProgramId(rs.getInt("programId"));
                 program.setNazivPrograma(rs.getString("nazivPrograma"));
                 program.setOpis(rs.getString("opis"));
                 program.setCena(rs.getDouble("cena"));
                 program.setTrajanje(rs.getString("trajanje"));
               
                 programi.add(program);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return programi; 
    
    
    
    }

    @Override
    public ArrayList<Program> listaTreniranje() throws SQLException {
        
         ArrayList<Program> programi = new ArrayList<Program>();
        try {
           
             String select = "select * from program where trajanje = '60'";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Program program = new Program();
                 program.setProgramId(rs.getInt("programId"));
                 program.setNazivPrograma(rs.getString("nazivPrograma"));
                 program.setOpis(rs.getString("opis"));
                 program.setCena(rs.getDouble("cena"));
                 program.setTrajanje(rs.getString("trajanje"));
               
                 programi.add(program);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return programi; 
    
    
    
    }

    @Override
    public ArrayList<Program> listaMrsavljenje() throws SQLException {
     
     ArrayList<Program> programi = new ArrayList<Program>();
        try {
           
             String select = "select * from program where trajanje = '100'";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Program program = new Program();
                 program.setProgramId(rs.getInt("programId"));
                 program.setNazivPrograma(rs.getString("nazivPrograma"));
                 program.setOpis(rs.getString("opis"));
                 program.setCena(rs.getDouble("cena"));
                 program.setTrajanje(rs.getString("trajanje"));
               
                 programi.add(program);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return programi; 
    
    
    }

    @Override
    public ArrayList<Program> listaZatezanje() throws SQLException {
    
         ArrayList<Program> programi = new ArrayList<Program>();
        try {
           
             String select = "select * from program where trajanje = '80'";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Program program = new Program();
                 program.setProgramId(rs.getInt("programId"));
                 program.setNazivPrograma(rs.getString("nazivPrograma"));
                 program.setOpis(rs.getString("opis"));
                 program.setCena(rs.getDouble("cena"));
                 program.setTrajanje(rs.getString("trajanje"));
               
                 programi.add(program);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(programRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return programi; 
    
    
    
    }
}
