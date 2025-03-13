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
public class SOIzmeniFilm extends SistemskaOperacija{
    
    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Film)){
            throw new Exception("Prosledjeni objekat nije klase Film");
        }
        
        Film film = (Film) podatak;
        
        List<Film> listaFilmova = (List<Film>)(List<?>)DbBroker.getInstanca().ucitajListu(film);
        
        for(Film f: listaFilmova){
            if(f.getIdFilma() != film.getIdFilma() && f.getNaziv().equalsIgnoreCase(film.getNaziv())){
                throw new Exception("Film sa prosledjenim nazivom vec postoji.");
            }
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Film film = (Film) podatak;
        
        DbBroker.getInstanca().izmeni(film);
        
        return film;
    }
}
