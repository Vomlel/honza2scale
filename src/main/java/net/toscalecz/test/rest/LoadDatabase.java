package net.toscalecz.test.rest;

import net.toscalecz.test.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Pepa", Hashing.hashThisString("1234"))));
            log.info("Preloading " + repository.save(new User("Pepka", Hashing.hashThisString("2345"))));
        };
    }
}
