package gestionzoo.entities;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public Aquatic() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + ", Aquatic{habitat='" + habitat + "'}";
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Aquatic)) {
            return false;
        }

        Aquatic other = (Aquatic) obj;

        return this.getName().equalsIgnoreCase(other.getName())
                && this.getAge() == other.getAge()
                && this.habitat.equalsIgnoreCase(other.habitat);
    }
}