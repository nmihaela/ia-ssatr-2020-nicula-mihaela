/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.biblioteca.model;

/**
 *
 * @author Mihaela
 */
public class Cartea {
     private Integer ID;
    private String GEN;
    private String AUTOR;
    private String NUME;
    private Integer AN_PUBL;
    private Integer NR_PAG;
    
     public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getGEN(){
        return GEN;
    }
     public void setGEN(String GEN) {
        this.GEN = GEN;
    }
     
     public String getAUTOR(){
        return AUTOR;
    }
     public void setAUTOR(String AUTOR) {
        this.AUTOR = AUTOR;
    }
     
     public String getNUME(){
        return NUME;
    }
     public void setNUME(String NUME) {
        this.NUME = NUME;
    }
     
      public Integer getAN_PUBL() {
        return AN_PUBL;
    }
    public void setAN_PUBL(Integer AN_PUBL) {
        this.AN_PUBL = AN_PUBL;
    }
    
     public Integer getNR_PAG() {
        return NR_PAG;
    }
    public void setNR_PAG(Integer NR_PAG) {
        this.NR_PAG = NR_PAG;
    }
    
     @Override
    public String toString() {
        return "Carte{" + "ID=" + ID + ",, GEN=" + GEN + ", AUTOR=" + AUTOR + ", NUME=" + NUME + ", AN_PUBL=" + AN_PUBL + ", NR_PAG=" + NR_PAG + '}'+"\n";
    }
}
