package pl.schronisko.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.schronisko.demo.database.WriteSQL;
import pl.schronisko.demo.model.Animal;
import pl.schronisko.demo.repository.AnimalRepository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private WriteSQL writeSQL;

    @GetMapping("/addanimalform")
    public String addAnimalform(Model model) {
        model.addAttribute("animal", new Animal());
        return "addanimal";
    }

    @PostMapping("/addanimal")
    public String addAnimal(Animal animal) throws SQLException {

        List<Animal> animalList = animalRepository.getAll();
        int max = 0;
        for (Animal animals : animalList) {
            if (animals.getIdNumber() > max) {
                max = animals.getIdNumber();
            }
        }
        animal.setIdNumber(max + 1);
        animalRepository.addAnimal(animal);
        writeSQL.writeSQL(animal);
        return "redirect:/showanimal";
    }



    @GetMapping("/showanimal")
    public String showAnimal(Model model) {
        List<Animal> animalList = animalRepository.getAll();
        model.addAttribute("animalList", animalList);
        return "index";
    }

    @PostMapping("/deleteanimal")
    public String deleteAnimal(@RequestParam int idNumber) {
        List<Animal> animalList = animalRepository.getAll();
        Iterator iterator = animalList.iterator();
        while (iterator.hasNext()) {
            Object animal = iterator.next();
            if (((Animal) animal).getIdNumber() == idNumber) {
                iterator.remove();
            }
        }
        return "redirect:/showanimal";
    }

    @GetMapping("/animal")
    public String animal(Model model,
                         @RequestParam int idNumber) {
        List<Animal> animalList = animalRepository.getAll();

        for (Animal animals : animalList) {
            if (animals.getIdNumber() == idNumber) {
                model.addAttribute("name", animals.getName());
                model.addAttribute("idNumber", animals.getIdNumber());
                model.addAttribute("description", animals.getDescription());
                model.addAttribute("species", animals.getSpecies());
            }
        }
        return "animal";
    }
}