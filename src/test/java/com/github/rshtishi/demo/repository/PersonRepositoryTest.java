package com.github.rshtishi.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.rshtishi.demo.entity.Person;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	@Order(1)
	void testFindAll() {
		// setup
		// execute
		List<Person> persons = personRepository.findAll();
		// verify
		int expectedSize = 0;
		assertEquals(expectedSize, persons.size());
	}

	@Test
	@Order(2)
	public void testDeleteByID() {
		// setup
		String id = "1";
		// execute
		personRepository.deleteById(id);
		// verify
		List<Person> persons = personRepository.findAll();
		int expectedSize = 0;
		assertEquals(expectedSize, persons.size());

	}

	@Test
	@Order(3)
	void testSave() {
		// setup
		Person person = new Person("1", "Rando Shtishi", 28);
		// execute
		personRepository.save(person);
		// verify
		int expectedSize = 1;
		List<Person> persons = personRepository.findAll();
		assertEquals(expectedSize, persons.size());
	}

	@Test
	@Order(4)
	void testFindById() {
		// setup
		String id = "1";
		// execute
		Optional<Person> optionalPerson = personRepository.findById("1");
		// verify
		assertTrue(optionalPerson.isPresent());
	}

	@Test
	@Order(5)
	public void testDelete() {
		// setup
		String id = "1";
		Optional<Person> optionalPerson = personRepository.findById("1");
		// execute
		personRepository.delete(optionalPerson.get());
		// verify
		List<Person> persons = personRepository.findAll();
		int expectedSize = 0;
		assertEquals(expectedSize, persons.size());

	}

}
