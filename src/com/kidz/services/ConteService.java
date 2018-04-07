/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.services;

import com.kidz.Iservice.IConteService;
import com.kidz.entities.Conte;
import com.kidz.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ConteService implements IConteService{
    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    @Override
    public void createConte(Conte c) {
         try {
            String req = "INSERT INTO conte (TitreC,resume,contenu,image,minage,maxage,catC,Maison_ed,auteur,enable) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, c.getTitreC());
            st.setString(2, c.getResume());
            st.setString(3, c.getContenu());
            st.setString(4, c.getImage());
            st.setInt(5, c.getMinage());
            st.setInt(6, c.getMaxage());
            st.setString(7, c.getCatC());
            st.setString(8, c.getMaison_ed());
            st.setString(9, c.getAuteur());
            st.setBoolean(10, true);
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Conte> getAll() {
      ArrayList<Conte> listContes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from conte");
            while (rs.next()) {
                System.out.println("votre conte");
                listContes.add(new Conte(
                        // rs.getInt("idCon"),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                        
                ));
            }
           
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listContes;    }

    @Override
    public void update(Conte c) {
         try {
            String req = "UPDATE `conte` SET `TitreC` = ?, `resume`= ?,`contenu`= ?,`image`= ?,`minage`= ?"
                    + ",`maxage`= ?,`catC`= ?,`Maison_ed`= ?,`auteur`= ?, `enable`= ? WHERE `idCon` = ?";
            PreparedStatement st = conn.prepareStatement(req);
           st.setString(1, c.getTitreC());
            st.setString(2, c.getResume());
            st.setString(3, c.getContenu());
            st.setString(4, c.getImage());
            st.setInt(5, c.getMinage());
            st.setInt(6, c.getMaxage());
            st.setString(7, c.getCatC());
            st.setString(8, c.getMaison_ed());
            st.setString(9, c.getAuteur());
            st.setBoolean(10, true);
            st.setInt(11, c.getIdCon());
             System.out.println(st);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int idCon) {
        try {
            String req= "DELETE FROM `conte` WHERE `conte`.`idCon` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, idCon);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Conte> consulterListeConteAvecId() {
        System.out.println("com.kidz.services.ConteService.consulterListeConteAvecId()");
        String query = "SELECT `idCon`,`TitreC`, `resume`, `contenu`, `minage`, `maxage`, `catC`,`Maison_ed`,`auteur` FROM `conte`";
        List<Conte> res = new ArrayList<Conte>();
        PreparedStatement statement = null;

        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("idCon");
                String TitreC = result.getString("TitreC");
                String resume = result.getString("resume");
                String contenu = result.getString("contenu");
               int minage = result.getInt("minage");
               int maxage = result.getInt("maxage");

                String catC = result.getString("catC");

                String Maison_ed = result.getString("Maison_ed");
               
                String auteur = result.getString("auteur");
                res.add(new Conte(id, TitreC, resume, contenu, minage, maxage,  catC, Maison_ed,auteur));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }

    
}
