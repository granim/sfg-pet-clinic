package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("Grant");
        owner1.setLastName("Murphy");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("James");
        owner2.setLastName("Brown");

        ownerService.save(owner2);
        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Robin");
        vet1.setLastName("Brooks");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Joe");
        vet2.setLastName("Samuel");

        vetService.save(vet2);

        System.out.println("Loaded Vets");

    }
}
