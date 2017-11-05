package pl.schronisko.demo.model;

public class Cat extends Animal {
    public Cat(String name, int idNumber, String description, String photoPath, String species) {
        super(name, idNumber, description, photoPath, species);
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
