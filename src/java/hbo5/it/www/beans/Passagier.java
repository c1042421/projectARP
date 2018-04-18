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
    private Integer id;
    private Integer ingeschreven;
    private Integer ingecheckt;
    private Integer klasse_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIngeschreven() {
        return ingeschreven;
    }

    public void setIngeschreven(Integer ingeschreven) {
        this.ingeschreven = ingeschreven;
    }

    public Integer getIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(Integer ingecheckt) {
        this.ingecheckt = ingecheckt;
    }

    public Integer getKlasse_id() {
        return klasse_id;
    }

    public void setKlasse_id(Integer klasse_id) {
        this.klasse_id = klasse_id;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public Integer getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(Integer vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

    public Integer getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(Integer persoon_id) {
        this.persoon_id = persoon_id;
    }
    private String plaats;
    private Integer vlucht_id;
    private Integer persoon_id;
}
