package domain;
import domain.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda extends Entity{
    private ArrayList<Tort> torturi;
    private Date data;

    public Comanda(int id,Date dataComanda) {
        super(id);
        torturi=new ArrayList<>();
        this.data=dataComanda;
    }

    public ArrayList<Tort>  getTorturi(){return torturi;}
    public Date getData(){return data;}
    public void setData(Date data){this.data=data;}
    public void setTorturi(ArrayList<Tort> torturi){this.torturi=torturi;}

    public void addTorturi(Tort tort){torturi.add(tort);}

    @Override
    public String toString(){
        return "Comanda { "+ "ID: " +getID() + " Data:" + data + "Torturi: " + torturi+ '}' ;

    }
}
