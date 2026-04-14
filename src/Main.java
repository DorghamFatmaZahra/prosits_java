import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(3, "Ali", "Sami", "Informatique", 2);
        Employe e2 = new Employe(1, "Ben Salah", "Amira", "RH", 1);
        Employe e3 = new Employe(2, "Khaled", "Nour", "Informatique", 1);
        Employe e4 = new Employe(4, "Mansour", "Lina", "Finance", 3);
        Employe e5 = new Employe(5, "Abid", "Yassine", "Informatique", 1);


        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);
        societe.ajouterEmploye(e5);

        System.out.println("\n--- Liste initiale ---");
        societe.displayEmploye();

        System.out.println("\nRecherche de 'Ali' : " + societe.rechercherEmploye("Ali"));

        System.out.println("Recherche de e3 : " + societe.rechercherEmploye(e3));

        societe.trierEmployeParId();
        System.out.println("\n--- Tri par ID ---");
        societe.displayEmploye();

        societe.trierEmployeParNomDépartementEtGrade();
        System.out.println("\n--- Tri par département, puis grade, puis nom ---");
        societe.displayEmploye();

        System.out.println("\n--- Employés du département Informatique ---");
        List<Employe> listeDep = societe.rechercherParDepartement("Informatique");
        for (Employe e : listeDep) {
            System.out.println(e);
        }

        societe.supprimerEmploye(e2);
        System.out.println("\n--- Après suppression ---");
        societe.displayEmploye();
    }
}