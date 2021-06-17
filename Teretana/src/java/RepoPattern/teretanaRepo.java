/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoPattern;
import DAO.teretanaDAO;
import Models.Teretana;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 *
 * @author Jovana
 */
public class teretanaRepo implements teretanaDAO{

    
     Connection con;
    public teretanaRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String URL =  "jdbc:mysql://localhost:3306/teretana", USER = "root", PASS = "";
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public boolean insert(Teretana teretana, Part part) throws SQLException {
       
        String insert = "INSERT INTO `teretana`( nazivTeretane, telefonTeretane, adresaTeretane, grad, email, opis, fotografija) "
                        + "VALUES (?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pst = con.prepareStatement(insert);
            
            pst.setString(1, teretana.getNazivTeretane());
            pst.setString(2, teretana.getTelefonTeretane());
            pst.setString(3, teretana.getAdresaTeretane());
            pst.setString(4, teretana.getGrad());
            pst.setString(5, teretana.getEmail());
            
            pst.setString(6, teretana.getOpis());
             InputStream is = part.getInputStream();
            pst.setBlob(7,is);
            
            pst.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            return false;
        } catch (IOException ex) {
           
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public void fotografije(HttpServletRequest request, HttpServletResponse response, String teretanaId) throws ServletException, IOException, SQLException {
        
    Statement stmt;
            try {

                stmt = con.createStatement();
                byte[] imgData = null;
                ResultSet rs = stmt.executeQuery("select fotografija from teretana where teretanaId = " + teretanaId);
                while (rs.next()) 
                {
                    Blob image = rs.getBlob(1);
                    imgData = image.getBytes(1,(int)image.length());
                }
                response.setContentType("image/jpg");
                try (OutputStream o = response.getOutputStream()) {
                    o.write(imgData);
                    o.flush();
                }
            } catch (SQLException ex) {

            }
            finally{
                con.close();
            }
    
    }

    @Override
    public ArrayList<Teretana> lista() throws SQLException {
        
     ArrayList<Teretana> teretane = new ArrayList<Teretana>();
        try {
           
             String select = "select * from teretana";
        
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select);
             
             while(rs.next()){
                 Teretana teretana = new Teretana();
                 teretana.setTeretanaId(rs.getInt("teretanaId"));
                 teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                 teretana.setTelefonTeretane(rs.getString("telefonTeretane"));
                 teretana.setAdresaTeretane(rs.getString("adresaTeretane"));
                 teretana.setGrad(rs.getString("grad"));
                 teretana.setEmail(rs.getString("email"));
                 teretana.setOpis(rs.getString("Opis"));
                 teretana.setFotografija(rs.getBlob("fotografija"));
                 teretane.add(teretana);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return teretane; 
    
    }

    @Override
    public Teretana select(String Id) throws SQLException {
    
        Teretana teretana = new Teretana();
        try {
            String select = "select * from teretana where teretanaId = " + Id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                teretana.setTeretanaId(rs.getInt("teretanaId"));
                teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                teretana.setTelefonTeretane(rs.getString("telefonTeretane"));
                teretana.setAdresaTeretane(rs.getString("adresaTeretane"));
                teretana.setGrad(rs.getString("grad"));
                teretana.setEmail(rs.getString("email"));
                teretana.setOpis(rs.getString("opis"));
                teretana.setFotografija(rs.getBlob("fotografija"));
            }
        } catch (SQLException ex) {
           Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
        return teretana;
    
    }

    @Override
    public boolean update(Teretana teretana, Part part) throws SQLException, IOException {
       
         
        String fotografija = "fotografija = ?,";
        
        String update = "update teretana "
                      + "set nazivTeretane = ?,"
                      + "telefonTeretane = ?,"
                      + "adresaTeretane = ?,"
                      + "grad = ?,"
                      + "email = ?,";
        
        if (part.getSize()!=0)
            update += fotografija;
    
        update += "opis = ?"+
                  "where teretanaId = ?";      
                
         
        try {
            PreparedStatement pst = con.prepareStatement(update);

            pst.setString(1, teretana.getNazivTeretane());
            pst.setString(2, teretana.getTelefonTeretane());
            pst.setString(3, teretana.getAdresaTeretane());
            pst.setString(4, teretana.getGrad());
            pst.setString(5, teretana.getEmail());
            
            InputStream is;
            
            if(part.getSize()!=0){
                is = part.getInputStream();
                pst.setBlob(6, is);
                pst.setString(7,teretana.getOpis());
                pst.setInt(8, teretana.getTeretanaId());
            }
            else{
                pst.setString(6, teretana.getOpis());
                pst.setInt(7, teretana.getTeretanaId());
            }

            pst.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
          return false;
        }
       
    
    }

    @Override
    public void brisanje(String Id) throws SQLException {
        
    try {
          
            String delete = "delete from  teretana where teretanaId = " + Id;
            PreparedStatement ps  = con.prepareStatement(delete);

            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
    public Teretana selectByUsername(String username) throws SQLException {
    
         Teretana teretana = new Teretana();
        try {
            String select = "select * from teretana where nazivTeretane = '" + username +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                teretana.setTeretanaId(rs.getInt("teretanaId"));
                teretana.setNazivTeretane(rs.getString("nazivTeretane"));
                teretana.setTelefonTeretane(rs.getString("telefonTeretane"));
                teretana.setAdresaTeretane(rs.getString("adresaTeretane"));
                teretana.setGrad(rs.getString("grad"));
                teretana.setEmail(rs.getString("email"));
                teretana.setOpis(rs.getString("opis"));
                teretana.setFotografija(rs.getBlob("fotografija"));
                }
        
        } catch (SQLException ex) {
            Logger.getLogger(teretanaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();
        }
       
      
        return teretana;
    }

}
