package Furniture;

public class Chair extends AbstractFurniture { // Класс-наследник - стул
    private String material;
    private String color;

    public Chair(String name, double price, String material, String color) {
        super(name, price);
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a chair: " + getName());
        commonAssemblySteps();
    }
    public void changeColor(String newColor) {
        System.out.println("Changing color of the chair to " + newColor);
        this.color = newColor;
    }

    public void chairSpecificMethod() {
        System.out.println("This is a method specific to the Chair class.");
    }
}
