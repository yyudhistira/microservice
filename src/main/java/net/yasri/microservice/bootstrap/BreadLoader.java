package net.yasri.microservice.bootstrap;

import net.yasri.microservice.domain.Bread;
import net.yasri.microservice.repositories.BreadRepository;
import net.yasri.microservice.web.model.BreadStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class BreadLoader implements CommandLineRunner {
    private final BreadRepository breadRepository;

    public BreadLoader(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBreadObjects();
    }

    private void loadBreadObjects() {
        if (breadRepository.count() == 0) {
            breadRepository.save(Bread.builder()
                .breadName("Roti1")
                .breadStyle("STUFFED_DINNER_ROLLS")
                .price(BigDecimal.valueOf(200))
                .quantityOnHand(10)
                .quantityOnHand(100)
                .upc(new Random().nextLong())
                .build());
            breadRepository.save(Bread.builder()
                .breadName("Roti2")
                .breadStyle("STUFFED")
                .price(BigDecimal.valueOf(10))
                .quantityOnHand(100)
                .quantityOnHand(200)
                .upc(new Random().nextLong())
                .build());
        }
    }
}
