package domain;

public class Tort extends Entity {
    private String name;
    public Tort(int id ,String name){
    super(id);
    this.name=name;
    }
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    @Override
    public String toString(){
        return"Tort{ID:"+ getID()+" tip: "+name+'}';
    }

}

