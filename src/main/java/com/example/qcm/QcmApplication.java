package com.example.qcm;

import com.example.qcm.repository.RoleRepository;
import com.example.qcm.repository.UserRepository;
import com.example.qcm.repository.entity.Role;
import com.example.qcm.repository.entity.RoleEnum;
import com.example.qcm.repository.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class QcmApplication {

    public static void main(String[] args) {
        SpringApplication.run(QcmApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Role role1 = new Role(RoleEnum.ROLE_USER);
                Role role2 = new Role(RoleEnum.ROLE_ADMIN);
                List<Role> roleList = Arrays.asList(role1, role2);
                roleRepository.saveAll(roleList);

                User userAdmin = new User("admin", "admin", Arrays.asList(role2));
                userRepository.save(userAdmin);


            }
        };
    }


}
