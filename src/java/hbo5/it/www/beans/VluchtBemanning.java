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
public class VluchtBemanning {
    private int id;
    private String taak;
    private int bemanningslid_id;
    private int vlucht_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public int getBemanningslid_id() {
        return bemanningslid_id;
    }

    public void setBemanningslid_id(int bemanningslid_id) {
        this.bemanningslid_id = bemanningslid_id;
    }

    public int getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }
}
