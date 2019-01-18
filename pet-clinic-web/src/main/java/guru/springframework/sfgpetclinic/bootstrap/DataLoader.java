package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(){
        ownerService = new OwnerServiceMap();
        verService = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
