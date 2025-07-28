import java.util.*;
import java.util.stream.Collectors;

class Pet {
    private String type;
    private int age;
    private boolean isAdopted;

    public Pet(String type, int age) {
        this.type = type;
        this.age = age;
        this.isAdopted = false;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void markAsAdopted() {
        this.isAdopted = true;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Age: " + age + ", Adopted: " + isAdopted;
    }
}

class PetAdoptionPortal<T extends Pet> {
    private List<T> pets;

    public PetAdoptionPortal() {
        this.pets = new ArrayList<>();
    }

    public void addPet(T pet) {
        pets.add(pet);
    }

    public List<T> filterAvailablePets(String type, int maxAge) {
        return pets.stream()
                .filter(pet -> !pet.isAdopted())
                .filter(pet -> pet.getType().equalsIgnoreCase(type))
                .filter(pet -> pet.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public void markPetAsAdopted(T petToAdopt) {
        for (T pet : pets) {
            if (pet.equals(petToAdopt)) {
                pet.markAsAdopted();
                return;
            }
        }
    }

    public List<T> getAllPets() {
        return new ArrayList<>(pets);
    }
}

public class PetAdoption {
    public static void main(String[] args) {
        PetAdoptionPortal<Pet> portal = new PetAdoptionPortal<>();
        Pet dog1 = new Pet("Dog", 3);
        Pet cat1 = new Pet("Cat", 2);
        Pet dog2 = new Pet("Dog", 5);
        Pet bird1 = new Pet("Bird", 1);
        Pet cat2 = new Pet("Cat", 4);
        Pet reptile1 = new Pet("Reptile", 6);

        portal.addPet(dog1);
        portal.addPet(cat1);
        portal.addPet(dog2);
        portal.addPet(bird1);
        portal.addPet(cat2);
        portal.addPet(reptile1);

        System.out.println("All pets in the portal:");
        portal.getAllPets().forEach(System.out::println);
        System.out.println();

        System.out.println("Filtering for available Dogs under 4 years old:");
        List<Pet> availableDogs = portal.filterAvailablePets("Dog", 3);
        availableDogs.forEach(System.out::println);
        System.out.println();

        System.out.println("Marking Cat (age 2) as adopted:");
        portal.markPetAsAdopted(cat1);
        System.out.println(cat1);
        System.out.println();

        System.out.println("Filtering for available Cats under 5 years old after adoption:");
        List<Pet> availableCats = portal.filterAvailablePets("Cat", 5);
        availableCats.forEach(System.out::println);
        System.out.println();

        System.out.println("All pets in the portal after adoption:");
        portal.getAllPets().forEach(System.out::println);
    }
}
