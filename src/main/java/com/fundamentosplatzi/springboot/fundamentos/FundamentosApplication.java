package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		log.info(myBeanWithProperties.function());
		log.info(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
		try {
			// Error
			int value = 10/0;
			log.debug("Mi valor: " + value);
		} catch (Exception e) {
			log.error("Esto es un error al dividir entre cero " + e.getMessage());
		}
	}
}
