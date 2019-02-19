package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Services.*;
import guru.springframework.sfgpetclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        //Create pet type 1
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        // Create pet type 2
        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        //Create the specialties
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry.");
        Speciality savedDentistry = specialtyService.save(dentistry);

        //Create owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Grant");
        owner1.setLastName("Murphy");
        owner1.setAddress("123 Breden Court");
        owner1.setCity("Republic of Dave");
        owner1.setTelephone("8675309");
        ownerService.save(owner1);
        //Create owner 1 pet
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
        Visit catVisit = new Visit();
        catVisit.setPet(jamesCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Cat");

        visitService.save(catVisit);
        System.out.println("Loaded owners");

        //create first vet
        Vet vet1 = new Vet();
        vet1.setFirstName("Robin");
        vet1.setLastName("Brooks");
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        //create second vet
        Vet vet2 = new Vet();
        vet2.setFirstName("Joe");
        vet2.setLastName("Samuel");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
