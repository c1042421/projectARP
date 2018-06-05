/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;
/**
 *
 * @author c1042486
 */
public class Passagier {
    private int id;
    private boolean ingeschreven;
    private boolean ingecheckt;
    private int klasse_id;
    private String plaats;
    private int vlucht_id;
    private int persoon_id;
    private Persoon persoon;

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
    
    private Vliegtuigklasse klasse;
    
    private Vlucht vlucht;

    public Vliegtuigklasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Vliegtuigklasse klasse) {
        this.klasse = klasse;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIngeschreven() {
        return ingeschreven;
    }

    public void setIngeschreven(boolean ingeschreven) {
        this.ingeschreven = ingeschreven;
    }

    public boolean getIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(boolean ingecheckt) {
        this.ingecheckt = ingecheckt;
    }

    public int getKlasse_id() {
        return klasse_id;
    }

    public void setKlasse_id(int klasse_id) {
        this.klasse_id = klasse_id;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public int getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    @Override
    public String toString() {
        return ingecheckt?"INGECHECKT":"NIET INGECHECKT";
    }
    
    
}
