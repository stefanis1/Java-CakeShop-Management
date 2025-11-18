package Service;

import Exceptions.TortException;
import Repository.Repository;
import domain.Tort;
import Repository.IRepo;
import java.util.ArrayList;

public class ServiceTort {
    private final IRepo<Tort> repo;

    public ServiceTort(IRepo<Tort> repo ){this.repo=repo;}

    public void addTort(Tort tort){
        if(tort.getName().length()<=3 || tort.getName()==null)
            throw new TortException("Tipul tortului trebuie sa aiba cel putin 3 caractere");

        if(repo.isIn(tort.getID()))
        {
            throw new TortException(tort.getID());
        }


        repo.addElems(tort);
    }
    public Tort getTort(int id ){return repo.getById(id);}

    public void RemoveTort(int id){repo.RemoveElem(id);}

    public void UpdateTort(Tort t){repo.UpdateElem(t);}

    public int sizeTort(){return repo.size();}

    public ArrayList<Tort> getAllTort(){return repo.getElems();}

    @Override
    public String toString(){
        return "ServiceTort{ "+"Torturi: "+repo+'}';
    }


}
