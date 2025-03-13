/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.film;

import db.DbBroker;
import domen.Film;
import java.util.List;
import so.SistemskaOperacija;
import java.sql.*;

/**
 *
 * @author vanja
 */
public class SOObrisiFilm extends SistemskaOperacija{
 
    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Film)){
            throw new Exception("Prosledjeni objekat nije klase Film");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        try{   
            Film film = (Film) podatak;

            DbBroker.getInstanca().obrisi(film);

            return film;
        }catch(SQLIntegrityConstraintViolationException ex){
            ex.printStackTrace();
            throw new Exception("Ne mozete obrisati ovaj film jer se koristi kao stavka u nekoj rezervaciji.");
        }
    }
}
