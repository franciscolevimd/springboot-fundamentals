package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class FundamentosApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;
	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBeanWithDependency myBeanWithDependency;
	@Autowired
	private MyBeanWithProperties myBeanWithProperties;
	@Autowired
	private UserPojo userPojo;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentsEaxmple();
		logExamples();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser() {
		log.info("### Usuario con el método findByUserEmail: "
				+ userRepository.findByUserEmail("arisaurusrex@mail.com")
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario.")));
		userRepository.findAndSort("Fat", Sort.by("id").descending())
				.stream()
				.forEach(user -> log.info("### User with sort method " + user));
		userRepository.findByName("Ariana")
				.stream()
				.forEach(user -> log.info("### User with query method: " + user));
		log.info("### User with query method by email and name: "
				+ userRepository.findByEmailAndName("jessica@mail.com", "Jessica")
				.orElseThrow(() -> new RuntimeException("The user could't be found.")));
		userRepository.findByNameLike("%na%")
				.stream()
				.forEach(user -> log.info("### User with query method like: " + user));
		userRepository.findByNameOrEmail("Carla", "dana@mail.com")
				.stream()
				.forEach(user -> log.info("### User with query method or: " + user));
		userRepository.findByBirthDateBetween(
				LocalDate.of(2000, 1, 1),
				LocalDate.of(2021, 12, 31))
				.stream()
				.forEach(user -> log.info("### User with query method between: " + user));
		userRepository.findByNameLikeOrderByIdDesc("%na")
				.stream()
				.forEach(user -> log.info("### User with query method like an order by: " + user));
		userRepository.findByNameContainingOrderByIdAsc("na")
				.stream()
				.forEach(user -> log.info("### User with query method containing an order by: " + user));

		log.info("### User with named parameters is. " + userRepository.getAllByBirthDateAndEmail(
				LocalDate.of(2018, 9, 12),
				"fatsy@mail.com"
		).orElseThrow(() -> new RuntimeException("The user could't be found.")));
	}

	private void saveUsersInDataBase() {
		List<User> users = Arrays.asList(
				new User(
						0L,
						"Ana",
						"ana@mail.com",
						LocalDate.of(1985, 10, 16),
						null),
				new User(
						0L,
						"Carla",
						"carlaconc@mail.com",
						LocalDate.of(1995, 2, 23),
						null),
				new User(
						0L,
						"Ariana",
						"arisaurusrex@mail.com",
						LocalDate.of(2005, 3, 22),
						null),
				new User(
						0L,
						"Norma",
						"norma@mail.com",
						LocalDate.of(1980, 1, 06),
						null),
				new User(
						0L,
						"Jessica",
						"jessica@mail.com",
						LocalDate.of(1995, 2, 23),
						null),
				new User(
						0L,
						"Brenda",
						"brenda@mail.com",
						LocalDate.of(2015, 11, 8),
						null),
				new User(
						0L,
						"Daniela",
						"dana@mail.com",
						LocalDate.of(1998, 03, 17),
						null),
				new User(
						0L,
						"Fatima Belem Guadalupe",
						"fatsy@mail.com",
						LocalDate.of(2018, 9, 12),
						null)
		);
		users.stream().forEach(userRepository::save);
	}

	private void componentsEaxmple() {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		log.info(myBeanWithProperties.function());
		log.info(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
	}

	private void logExamples() {
		try {
			// Error
			int value = 10/0;
			log.debug("Mi valor: " + value);
		} catch (Exception e) {
			log.error("Esto es un error al dividir entre cero " + e.getMessage());
		}
	}
}
