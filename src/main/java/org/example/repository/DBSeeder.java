package org.example.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class DBSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args){

        //DELETE ALL
        this.userRepository.deleteAll();
        log.info("users have been deleted...");

        //CREATE
        User  lambda_user = new User("user",passwordEncoder.encode("user123"),"USER","");
        log.info("user : {}", lambda_user);
        User admin_user = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        log.info("admin : {}", admin_user);
        User manager_user = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");
        log.info("manager : {}", manager_user);


        List<User> users = Arrays.asList(lambda_user,admin_user,manager_user);
        //SAVE
        userRepository.saveAll(users);
        log.info("INITIALIZED DATABASE");
    }
}
