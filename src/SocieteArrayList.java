import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {

    private ArrayList<Employe> employes;

    public SocieteArrayList() {
        employes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employe t) {
        if (!employes.contains(t)) {
            employes.add(t);
            System.out.println("Employé ajouté avec succès.");
        } else {
            System.out.println("Employé déjà existant.");
        }
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe t) {
        return employes.contains(t);
    }

    @Override
    public void supprimerEmploye(Employe t) {
        if (employes.remove(t)) {
            System.out.println("Employé supprimé avec succès.");
        } else {
            System.out.println("Employé introuvable.");
        }
    }

    @Override
    public void displayEmploye() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé.");
        } else {
            for (Employe e : employes) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        employes.sort(new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int depCompare = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());

                if (depCompare != 0) {
                    return depCompare;
                }

                int gradeCompare = Integer.compare(e1.getGrade(), e2.getGrade());

                if (gradeCompare != 0) {
                    return gradeCompare;
                }

                return e1.getNom().compareToIgnoreCase(e2.getNom());
            }
        });
    }
}