package com.stackroute.SoulmateSpringboot.repository;

import com.stackroute.SoulmateSpringboot.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        User user=new User("tharun","Male",21);
        userRepository.save(user);
        User user1=userRepository.findById(user.getId()).get();
        assertNotNull(user1);
        assertEquals(user1.getFirstName(),user1.getFirstName());

    }
    @Test
    public void getAllUsersThenReturnListOfUsers(){
        User user=new User("tharun","male",21);
        User user1=new User("Nancy","Female",21);
        userRepository.save(user);
        userRepository.save(user1);
        List<User> userList=(List<User>) userRepository.findAll();
        assertEquals("Nancy",userList.get(1).getFirstName());
    }

}