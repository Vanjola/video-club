/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.film.model;

import domen.Film;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleFilm extends AbstractTableModel {

    private List<Film> list;
    private String[] kolone = {"naziv", "broj primeraka", "godina", "polica", "zanr", "reziser"};

    public ModelTabeleFilm(List<Film> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film f = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getNaziv();
            case 1:
                return f.getBrojPrimeraka();
            case 2:
                return f.getGodina();
            case 3:
                return f.getPolica();
            case 4:
                return f.getZanr();
            case 5:
                return f.getReziser();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

  
    public Film vratiIzabraniFilm(int index){
        return list.get(index);
    }
}
