/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Jovana
 */
public class Program {
    
    private Integer programId;
    private String nazivPrograma;
    private String opis;
    private Double cena;
    private String trajanje;

    public Program() {
    }

    public Program(Integer programId, String nazivPrograma, String opis, Double cena, String trajanje) {
        this.programId = programId;
        this.nazivPrograma = nazivPrograma;
        this.opis = opis;
        this.cena = cena;
        this.trajanje = trajanje;
    }

    public String getNazivPrograma() {
        return nazivPrograma;
    }

    public void setNazivPrograma(String nazivPrograma) {
        this.nazivPrograma = nazivPrograma;
    }


    public Double getCena() {
        return cena;
    }

    public String getOpis() {
        return opis;
    }

    public Integer getProgramId() {
        return programId;
    }

    

    public String getTrajanje() {
        return trajanje;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

   

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }
    
    
     
}
