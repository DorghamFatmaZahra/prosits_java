package gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public void setFamily(String f){
        this.family=f;
    }
    public void setName(String n){
        this.name=n;
    }
    public void setAge(int age){
        if (age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif !");
        }
        this.age=age;
    }
    public void setIsMammal(boolean is){
        this.isMammal=is;
    }

    public String getFamily(){
        return this.family;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean getIsMammal(){
        return this.isMammal;
    }

    public Animal () {

    }

    public Animal (String f,String n,int age,boolean ism) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif !");
        }
        this.family=f;
        this.name=n;
        this.age=age;
        this.isMammal=ism;

    }

    @Override
    public String toString(){
        return "tn.esprit.gestionzoo.entities.Animal {" + "name = " + name + ", " + "family = " + family + ", "+ "age = " + age + ", " + "is mammal = " +isMammal + "}";

    }
}
