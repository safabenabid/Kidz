/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.Iservice;

import com.kidz.entities.Conte;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IConteService {
     public void createConte(Conte c);

    public List<Conte> getAll();
    public List<Conte> consulterListeConteAvecId();

    public void update(Conte c);

    public void delete(int idCon);
    
}
