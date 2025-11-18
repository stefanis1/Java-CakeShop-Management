package Repository;

import domain.Entity;

import java.util.ArrayList;

public interface IRepo<T extends Entity> {

    void addElems(T elem);

    boolean isIn(int id);

    void RemoveElem(int id);

    T getById(int id);

    void deleteElem(T elem);

    ArrayList<T> getElems();

    void UpdateElem(T newElem);

    int size();
}
