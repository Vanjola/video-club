/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.film;

import db.DbBroker;
import domen.Film;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SOUcitajListuFilmova extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {

    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        return (List<Film>)(List<?>) DbBroker.getInstanca().ucitajListu(new Film());
    }
    
}
