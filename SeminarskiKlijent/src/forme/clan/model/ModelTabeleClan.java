/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.clan.model;

import domen.Clan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleClan extends AbstractTableModel {

    private List<Clan> lista;
    private String[] kolone = {"ime", "prezime", "email", "adresa"};

    public ModelTabeleClan(List<Clan> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIme();
            case 1:
                return c.getPrezime();
            case 2:
                return c.getEmail();
            case 3:
                return c.getAdresa();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public Clan vratiIzabranogClana(int index){
        return lista.get(index);
    }

    public int naKomJeReduClan(Clan clan) {
        return lista.indexOf(clan);
    }

}
