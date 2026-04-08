package gestionzoo.main;
import gestionzoo.entities.*;
import gestionzoo.exceptions.ZooFullException;
import gestionzoo.exceptions.AgeException;

import java.util.Scanner;
public class ZooManagement {
    int nbrCages;
    String zooName;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ZooManagement firstZoo = new ZooManagement();

        System.out.println("Veuillez saisir le nom du zoo : ");
        firstZoo.zooName = sc.nextLine();
        while (firstZoo.zooName.isEmpty()) {
            System.out.println("Le nom ne peut pas etre vide ");
            firstZoo.zooName = sc.nextLine();
        }

        System.out.println("Veuillez saisir le nombre de cages : ");
        firstZoo.nbrCages = sc.nextInt();
        while (firstZoo.nbrCages < 0) {
            System.out.println("Le nombre de cages doit etre positif");
            firstZoo.nbrCages = sc.nextInt();
        }


        System.out.println("Welcome to " + firstZoo.zooName + ". We have " + firstZoo.nbrCages + " cages .");

        sc.close();

        Animal lion = new Animal("Felidae", "Simba", 4, true);

        Zoo myZoo = new Zoo(firstZoo.zooName, "Ariana", firstZoo.nbrCages);


        Animal chat = new Animal("Felidae", "mimi", 4, true);
        Zoo myZoo2 = new Zoo("myZoo2", "Tunis", 3);

        Animal eagle = new Animal("Birds", "Sky", 3, false);
        Animal elephant = new Animal("Mammals", "Dumbo ", 10, true);

        myZoo.displayZoo();
        myZoo2.displayZoo();

        System.out.println(myZoo);
        System.out.println(lion.toString());
        System.out.println(eagle);


        for (int i = 0; i < 5; i++) {

            Animal a;

            // 👉 test cas invalide (âge négatif)
            if (i == 2) {
                a = new Animal("family", "badAnimal", -5, true);
            } else {
                a = new Animal("family", "animal " + i, 2, true);
            }

            try {
                myZoo2.addAnimal(a);
                System.out.println("Animal " + i + " ajouté avec succès.");
            } catch (AgeException e) {
                System.out.println("Erreur âge : " + e.getMessage());
            } catch (ZooFullException e) {
                System.out.println("Erreur zoo : " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

            System.out.println("Nombre total d’animaux : " + myZoo2.getAnimalCount());
        }
        myZoo2.displayAnimals();

        Zoo myZoo3 = new Zoo("myZoo3", "Sfax", 23);

        try {
            myZoo3.addAnimal(eagle);
            myZoo3.addAnimal(elephant);
        } catch (ZooFullException | AgeException e) {
            System.out.println(e.getMessage());
        }

        myZoo3.displayAnimals();
        System.out.println(myZoo3.searchAnimal(elephant));
        System.out.println(myZoo3.searchAnimal(eagle));

        Animal eagle2 = new Animal("Birds", "Sky", 3, false);
        System.out.println(myZoo3.searchAnimal(eagle2));

        myZoo3.removeAnimal(eagle);
        myZoo3.displayAnimals();

        System.out.println("Zoo2 full ? " + myZoo2.isZooFull());
        System.out.println("Zoo3 full ? " + myZoo3.isZooFull());

        Zoo bigger = Zoo.comparerZoo(myZoo2, myZoo3);
        System.out.println("Zoo with more animals: " + bigger.getName());



        Terrestrial t2 = new Terrestrial("Felines", "Simba", 4, true, 4);
        Dolphin d2 = new Dolphin("Cetaceans", "Flipper", 6, true, "ocean", 35.5f);
        Penguin p2 = new Penguin("Birds", "Pingu", 3, false, "ice", 50.0f);

        System.out.println(t2);
        System.out.println(d2);
        System.out.println(p2);

        d2.swim();
        p2.swim();

        myZoo.addAquaticAnimal(d2);
        myZoo.addAquaticAnimal(p2);
        myZoo.swimAllAquatics();
    }
}