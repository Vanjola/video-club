/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.rezervacija.model;

import domen.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleRezervacija extends AbstractTableModel {

    private List<Rezervacija> list;
    private String[] kolone = {"datum rezervacije", "status", "clan", "zaposleni"};

    public ModelTabeleRezervacija(List<Rezervacija> list) {
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
        Rezervacija r = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

                return sdf.format(r.getDatumRezervacije());
            case 1:
                if (r.isStatusRezervacije()) {
                    return "Vracena";
                }
                return "Nije vracena";
            case 2:
                return r.getClan();
            case 3:
                return r.getZaposleni();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Rezervacija vratiIzabranuRezervaciju(int index) {
        return list.get(index);
    }

}
