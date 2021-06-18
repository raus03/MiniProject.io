package com.quinta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.quinta.foody.dao.SignUpDao;
import com.quinta.foody.model.SignUp;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class SignUpDaoTest {
	@Autowired
	private SignUpDao repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser()
	{
		SignUp signup = new SignUp();
		signup.setEmail("aman@gmail.com");
	    signup.setPassword("aman2020");
	    signup.setFirstName("Aman");
	    signup.setLastName("Kumar");
	    
	    SignUp savedUser = repo.save(signup);
	    
	    SignUp existUser = entityManager.find(SignUp.class, savedUser.getId());


	    
	    assertThat(existUser.getEmail()).isEqualTo(signup.getEmail());
	}

}
