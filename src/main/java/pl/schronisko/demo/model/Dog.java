package pl.schronisko.demo.model;

public class Dog extends Animal {
    public Dog(String name, int idNumber, String description, String photoPath, String species) {
        super(name, idNumber, description, photoPath, species);
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
