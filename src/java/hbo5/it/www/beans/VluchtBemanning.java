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
    private Integer id;
    private String taak;
    private Integer bemanningslid_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public Integer getBemanningslid_id() {
        return bemanningslid_id;
    }

    public void setBemanningslid_id(Integer bemanningslid_id) {
        this.bemanningslid_id = bemanningslid_id;
    }

    public Integer getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(Integer vlucht_id) {
        this.vlucht_id = vlucht_id;
    }
    private Integer vlucht_id;
}