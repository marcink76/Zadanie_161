package pl.schronisko.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.schronisko.demo.model.Animal;
import pl.schronisko.demo.model.Cat;
import pl.schronisko.demo.model.Dog;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animalList;

    public AnimalRepository() {
        animalList = new ArrayList<>();
        animalList.add(new Dog("Burek", 0, "Pies po przejsciach", "images=1", "pies"));
        animalList.add(new Dog("Murzyn", 1, "Pies bez oka", "images=1", "pies"));
        animalList.add(new Cat("Klakier", 2, "Kot jakiśtam", "images=1", "kot"));
        animalList.add(new Cat("Stefan", 3, "Gópi kot", "images=1", "kot"));
    }

    public List<Animal> getAll() {
        return animalList;
    }


    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }
}
