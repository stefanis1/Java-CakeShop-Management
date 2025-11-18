package Repository;

import Exceptions.RepositoryExceptions;
import domain.Entity;

import java.util.ArrayList;

public class Repository <T extends Entity > implements IRepo<T>{

    private ArrayList<T> elems;

    public Repository(){this.elems=new ArrayList<>();}

    @Override
    public void addElems(T elem){elems.add(elem);}

    @Override
    public boolean isIn(int id){
        for(T elem: elems )
        {
            if(elem.getID()==id)
                return true;
        }
        return false;
    }
    @Override
    public void RemoveElem (int id ){
        boolean find=false;
        for (int i =0; i<elems.size();i++)
        {
            if(elems.get(i).getID()==id){
                elems.remove(i);
                i--;
                find=true;
            }
        }
        if(!find){
            throw new RepositoryExceptions("Nu exista elementul cu id-ul " +id+ " in repo ");
        }
    }

    @Override
    public void deleteElem(T elem ){elems.remove(elem);}

    public ArrayList<T> getElems (){return elems;}

    public T getById(int id ){
        for (T elem :elems ){
            if(elem.getID()==id)
                return elem;
        }
        return null;

    }

    @Override
    public void UpdateElem(T newElem) {
        boolean find=false;
        for (int i = 0; i < elems.size(); i++){
            if (elems.get(i).getID() == newElem.getID()){
                elems.set(i, newElem);
                find=true;
                return;
            }
        }
        if(!find) {
            throw new RepositoryExceptions("Nu exista elementul  "+newElem+ "in repo.");
        }
    }

    @Override
    public int size() {return elems.size();}


    @Override
    public String toString(){
        return "Repository{ "+"Elements: "+elems+'}';
    }


}
