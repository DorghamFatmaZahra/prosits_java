public class Main {
    public static void main(String[] args) {

        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(3, "Ali", "Sami", "Informatique", 2);
        Employe e2 = new Employe(1, "Meriem", "Amina", "RH", 1);
        Employe e3 = new Employe(2, "Karim", "Youssef", "Finance", 3);
        Employe e4 = new Employe(4, "Ali", "Nour", "Informatique", 1);
        Employe e5 = new Employe(3, "Ali", "Sami", "Informatique", 2); // même id et nom que e1

        // Ajout des employés
        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);
        societe.ajouterEmploye(e5); // ne doit pas être ajouté

        System.out.println("\n--- Liste des employés ---");
        societe.displayEmploye();

        // Recherche par nom
        System.out.println("\nRecherche par nom 'Ali' : " + societe.rechercherEmploye("Ali"));

        // Recherche par objet
        System.out.println("Recherche de e3 : " + societe.rechercherEmploye(e3));

        // Tri par id
        societe.trierEmployeParId();
        System.out.println("\n--- Après tri par id ---");
        societe.displayEmploye();

        // Tri par département puis grade puis nom
        societe.trierEmployeParNomDepartementEtGrade();
        System.out.println("\n--- Après tri par département, grade, nom ---");
        societe.displayEmploye();

        // Suppression
        societe.supprimerEmploye(e2);
        System.out.println("\n--- Après suppression de e2 ---");
        societe.displayEmploye();
    }
}