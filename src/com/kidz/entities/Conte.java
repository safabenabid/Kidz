/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.entities;

import javafx.beans.property.StringProperty;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author ASUS
 */
public class Conte {
    private int idCon;
    private String TitreC;
    private String resume;
    private String contenu;
    private String image;
    private int minage;
    private int maxage;
    private String catC;
    private String Maison_ed;
    private String auteur;
    private boolean enable;

    public Conte() {
    }

    public Conte(int idCon, String TitreC, String resume, String contenu, int minage, int maxage, String catC, String Maison_ed, String auteur) {
        this.idCon = idCon;
        this.TitreC = TitreC;
        this.resume = resume;
        this.contenu = contenu;
        //this.image = image;
        this.minage = minage;
        this.maxage = maxage;
        this.catC = catC;
        this.Maison_ed = Maison_ed;
        this.auteur = auteur;
        //this.enable = enable;
    }

    public Conte(String TitreC, String resume, String contenu, String image, int minage, int maxage, String catC, String Maison_ed, String auteur, boolean enable) {
        this.TitreC = TitreC;
        this.resume = resume;
        this.contenu = contenu;
        this.image = image;
        this.minage = minage;
        this.maxage = maxage;
        this.catC = catC;
        this.Maison_ed = Maison_ed;
        this.auteur = auteur;
        this.enable = enable;
    }

    public Conte(String TitreC, String resume, String contenu, int minage, int maxage, String catC, String Maison_ed, String auteur) {
        this.TitreC = TitreC;
        this.resume = resume;
        this.contenu = contenu;
        this.minage = minage;
        this.maxage = maxage;
        this.catC = catC;
        this.Maison_ed = Maison_ed;
        this.auteur = auteur;
    }

    

    public int getIdCon() {
        return idCon;
    }

    public String getTitreC() {
        return TitreC;
    }
   
            
 

    public String getResume() {
        return resume;
    }

    public String getContenu() {
        return contenu;
    }

    public String getImage() {
        return image;
    }

    public int getMinage() {
        return minage;
    }

    public int getMaxage() {
        return maxage;
    }

    public String getCatC() {
        return catC;
    }

    public String getMaison_ed() {
        return Maison_ed;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }

    public void setTitreC(String TitreC) {
        this.TitreC = TitreC;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMinage(int minage) {
        this.minage = minage;
    }

    public void setMaxage(int maxage) {
        this.maxage = maxage;
    }

    public void setCatC(String catC) {
        this.catC = catC;
    }

    public void setMaison_ed(String Maison_ed) {
        this.Maison_ed = Maison_ed;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Conte{" + "TitreC=" + TitreC 
                + ", resume=" + resume
                + ", contenu=" + contenu 
                + ", minage=" + minage
                + ", maxage=" + maxage
                + ", catC=" + catC
                + ", Maison_ed=" + Maison_ed
                + ", auteur=" + auteur 
                + ", enable=" + enable + '}';
    }

    public void setMinage(ChoiceBox<?> minage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMaxage(ChoiceBox<?> maxage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMaison_ed(TextField maison) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCatC(ChoiceBox<?> categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAuteur(TextField aute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
    
}
