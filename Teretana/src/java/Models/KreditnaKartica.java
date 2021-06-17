
package Models;

/**
 *
 * @author Jovana
 */
public class KreditnaKartica {
    private String VrstaKartice;
    private String BrojKartice;
    private Integer DatumIstekaMesec;
    private Integer DatumIstekaGodina;

    public KreditnaKartica() {}

    public KreditnaKartica(String VrstaKartice, String BrojKartice, Integer DatumIstekaMesec, Integer DatumIstekaGodina) {
        this.VrstaKartice = VrstaKartice;
        this.BrojKartice = BrojKartice;
        this.DatumIstekaMesec = DatumIstekaMesec;
        this.DatumIstekaGodina = DatumIstekaGodina;
    }

    public String getBrojKartice() {
        return BrojKartice;
    }

    public Integer getDatumIstekaGodina() {
        return DatumIstekaGodina;
    }

    public Integer getDatumIstekaMesec() {
        return DatumIstekaMesec;
    }

    public String getVrstaKartice() {
        return VrstaKartice;
    }

    public void setBrojKartice(String BrojKartice) {
        this.BrojKartice = BrojKartice;
    }

    public void setDatumIstekaGodina(Integer DatumIstekaGodina) {
        this.DatumIstekaGodina = DatumIstekaGodina;
    }

    public void setDatumIstekaMesec(Integer DatumIstekaMesec) {
        this.DatumIstekaMesec = DatumIstekaMesec;
    }

    public void setVrstaKartice(String VrstaKartice) {
        this.VrstaKartice = VrstaKartice;
    }

   
}
