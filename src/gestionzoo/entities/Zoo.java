package gestionzoo.entities;
import gestionzoo.exceptions.ZooFullException;
import gestionzoo.exceptions.AgeException;
public class Zoo {

    private Animal [] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private static final int MAX_ANIMALS = 25;
    private int animalCount = 0;
    private Aquatic [] aquaticAnimals = new Aquatic[MAX_ANIMAL_AQUATIC];
    private static final int MAX_ANIMAL_AQUATIC = 10;
    private int aquaticCount = 0;

    public void setName(String n){
        if (n == null || n.trim().isEmpty()) {
            throw new IllegalArgumentException("tn.esprit.gestionzoo.entities.Zoo name cannot be empty!");
        }
        this.name=n;
    }
    public void setCity(String c){
        this.city=c;
    }
    public Animal[] getAnimals() {
        return animals;
    }
    public int getAnimalCount (){
        return this.animalCount;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    public Zoo () {
        this.nbrCages = 20;
        this.animals = new Animal[MAX_ANIMALS];
    }

    public Zoo (String n, String c,int nbr) {

        setName(n);
        this.city=c;

        if (nbr>MAX_ANIMALS){
            this.nbrCages=MAX_ANIMALS;
        } else{
            this.nbrCages= nbr;
        }

        this.animals=new Animal[25];

    }

    public void displayZoo (){

        System.out.println("zoo name : " + name);
        System.out.println("city : " + city);
        System.out.println("number of cages : " + nbrCages);

    }

    @Override
    public String toString(){
        return "tn.esprit.gestionzoo.entities.Zoo {" + "name = " + name + ", " + "city = " + city + ", "+ "Cages = " + nbrCages +"}";

    }


    public void addAnimal(Animal animal) throws ZooFullException,AgeException{
        if (animal == null){
            throw new IllegalArgumentException("Animal cannot be null");
        }

        if (animal.getAge() < 0) {
            throw new AgeException();
        }
        if (isZooFull()) {
            throw new ZooFullException();
        }

        for (int i=0;i<animalCount;i++){
            if (animals[i].getName().equalsIgnoreCase(animal.getName())){
                throw new IllegalArgumentException("Animal already exists in the zoo");
            }
        }

        animals[animalCount] = animal;
        animalCount++;

    }

    public void displayAnimals(){

        if (animalCount == 0){
            System.out.println("No animals in the zoo");
            return;
        }
        for (int i=0 ; i<animalCount ; i++){
            System.out.println(animals[i]);
        }

    }

    public int searchAnimal (Animal animal){
        for (int i=0;i<animalCount;i++){
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }

        }
        return -1;

    }

    public boolean removeAnimal (Animal animal){
        int index = searchAnimal(animal);

        if (index == -1){
            return false;
        }

        for (int i=index; i<animalCount-1; i++){
            animals[i] = animals[i+1];
        }
        animals[animalCount-1] = null;
        animalCount--;

        return true;
    }

    public boolean isZooFull(){
        return animalCount>=nbrCages;
    }

    public static Zoo comparerZoo (Zoo z1, Zoo z2){
        if (z1.animalCount > z2.animalCount){
            return z1;

        }else {
            return z2;
        }
    }

    public void addAquaticAnimal(Aquatic aquatic) {

        if (aquatic == null) {
            System.out.println("Cannot add null aquatic animal.");
        }

        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("Aquatic animals list is full (max 10).");
        }

        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;

        System.out.println("Aquatic animal added: " + aquatic.getName());
    }

    public void swimAllAquatics(){
        if (aquaticCount == 0){
            System.out.println("No aquatic animals");
        }
        for (int i=0; i< aquaticCount; i++){
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth(){
        float maxDepth = 0;
        for (int i=0; i<aquaticCount; i++){
            if (aquaticAnimals[i] instanceof Penguin){
                Penguin p = (Penguin) aquaticAnimals[i];

                if (p.getSwimmingDepth()> maxDepth){
                    maxDepth = p.getSwimmingDepth();

                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticByType(){
        int nb_peng = 0;
        int nb_dolp = 0;
        for (int i = 0 ; i<aquaticCount ; i++){
            if (aquaticAnimals[i] instanceof Penguin){
                nb_peng++;
            }
            else if (aquaticAnimals[i] instanceof Dolphin){
                nb_dolp++;
            }
        }
        System.out.println("Number of Penguins: " + nb_peng);
        System.out.println("Number of Dolphins: " + nb_dolp);
    }

}