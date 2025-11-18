package Service;

import Repository.Repository;
import domain.Comanda;
import domain.Tort;
import Repository.IRepo;
import java.util.ArrayList;

public class ServiceComanda {
    private final IRepo<Comanda> repo;

    public ServiceComanda(IRepo<Comanda> repo){this.repo=repo;}

    public void addComanda(Comanda comanda){
        repo.addElems(comanda);
    }

    public Comanda getComanda(int id){return repo.getById(id);}

    public void deleteComanda(int id){repo.RemoveElem(id);}

    public ArrayList<Comanda> getAllComanda() {return repo.getElems();}

    public void updateComanda(Comanda c){repo.UpdateElem(c);}

    public int sizeComanda(){return repo.size();}

    public void addTortToComanda(int ComandaId, Tort t){
        Comanda com=repo.getById(ComandaId);
        if(com!=null){
            com.addTorturi(t);
        }
        else System.out.println("Comanda cu id-ul "+ComandaId+"nu exista");
    }

    @Override
    public String toString(){
        return "ServiceComanda{ "+"Torturi: "+repo+'}';
    }
}
