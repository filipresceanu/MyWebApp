package com.company.mywebapp;

import com.company.mywebapp.model.User;
import com.company.mywebapp.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class IUserRepositoryTests {
    @Autowired
    private IUserRepository repo;

    @Test
    public void testAddNew()
    {
        User user=new User();
        user.setEmail("alex.res@gmail.com");
        user.setPassword("rresjoii123456");
        user.setFirstName("Alex");
        user.setLastName("Resceanu");

        User savedUser= repo.save(user);
    }

    @Test
    public void testListAll(){
        Iterable<User>users= repo.findAll();
        for(User user:users)
        {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testUpdate()
    {
        Integer userId=1;
        Optional<User> optionaluser=repo.findById(userId);
        User user=optionaluser.get();
        user.setPassword("tata1are1");
        repo.save(user);

    }

    @Test
    public void testGet()
    {
        Integer userId=2;
        Optional<User> optionaluser=repo.findById(userId);
        System.out.println(optionaluser.get());

    }

    @Test
    public void testDelete()
    {
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionaluser=repo.findById(userId);
    }
}
