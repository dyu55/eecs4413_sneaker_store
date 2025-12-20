package edu.yorku.sneaker_store_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(excludeName = "org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration")
public class SneakerStoreBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(SneakerStoreBackendApplication.class, args);
    }


}
