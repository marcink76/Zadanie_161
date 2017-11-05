package pl.schronisko.demo.model;

public class Animal {
    String name;
    int idNumber;
    String description;
    String species;
    String photoPath;

    public Animal(String name, int idNumber, String description, String photoPath, String species) {
        this.name = name;
        this.idNumber = idNumber;
        this.description = description;
        this.photoPath = photoPath;
        this.species = species;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", description='" + description + '\'' +
                '}';
    }
}

