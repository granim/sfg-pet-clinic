package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Grant");
        owner1.setLastName("Murphy");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("James");
        owner2.setLastName("Brown");

        ownerService.save(owner2);
        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Robin");
        vet1.setLastName("Brooks");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Joe");
        vet2.setLastName("Samuel");

        vetService.save(vet2);

        System.out.println("Loaded Vets");

    }
}
