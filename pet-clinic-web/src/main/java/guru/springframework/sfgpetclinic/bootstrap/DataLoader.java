package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        //Create pet type 1
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        // Create pet type 2
        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        //Create onwer 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Grant");
        owner1.setLastName("Murphy");
        owner1.setAddress("123 Breden Court");
        owner1.setCity("Republic of Dave");
        owner1.setTelephone("8675309");
        ownerService.save(owner1);
        //Create onwer 1 pet
        Pet gantsPet = new Pet();
        gantsPet.setPetType(savedDogPetType);
        gantsPet.setOwner(owner1);
        gantsPet.setBirthDate(LocalDate.now());
        gantsPet.setName("Dozer");
        owner1.getPets().add(gantsPet);

        //Create owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("James");
        owner2.setLastName("Brown");
        owner2.setAddress("345 Breden Court");
        owner2.setCity("Republic of Dave");
        owner2.setTelephone("8675309");

        //Create owner 2 pet
        Pet jamesCat = new Pet();
        jamesCat.setPetType(savedCatPetType);
        jamesCat.setOwner(owner2);
        jamesCat.setBirthDate(LocalDate.now());
        jamesCat.setName("Crappy");
        owner2.getPets().add(jamesCat);

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
