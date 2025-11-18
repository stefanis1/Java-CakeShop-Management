package domain;

public abstract class Entity {
    private int id;
    public Entity(int id){this.id=id;}

    public int getID(){return this.id;}
    public void setID(int id){this.id=id;}

    @Override
    public String toString(){
        return "Entity{"+"id="+id+"}";
    }
}
