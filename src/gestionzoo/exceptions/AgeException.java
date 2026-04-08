package gestionzoo.exceptions;

public class AgeException extends Exception{
    public AgeException() {
        super("Âge d’animal invalide : l’âge ne peut pas être négatif.");
    }

    public AgeException(String message) {
        super(message);
    }

}
