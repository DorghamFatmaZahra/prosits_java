package gestionzoo.entities;

public class Penguin extends Aquatic{
    protected float swimmingDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public Penguin() {
        super();
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }
    @Override
    public String toString() {
        return super.toString() + ", Penguin{swimmingDepth='" + swimmingDepth + "'}";
    }
    @Override
    public void swim() {
        System.out.println("This penguin is swimming.");
    }
}