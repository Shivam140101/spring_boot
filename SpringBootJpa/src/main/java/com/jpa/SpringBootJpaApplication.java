package com.jpa;

import com.jpa.entity.User;
import com.jpa.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);

		UserRepo bean = context.getBean(UserRepo.class);

//		User user = new User();
//		user.setName("Shivam");
//		user.setCity("San Francisco");
//		user.setStatus("Active");
//
//		User user1 = bean.save(user);
//		System.out.println(user1);

		// Create Object of User
//		User user1 = new User();
//		user1.setName("Thor");
//		user1.setCity("Asgard");
//		user1.setStatus("God Of Thunder");
//
//		User user2 = new User();
//		user2.setName("Loki");
//		user2.setCity("TVA");
//		user2.setStatus("God Of Mischief");

		// Saving Single User
//		User resultUser = bean.save(user2);

//		List<User> users = List.of(user1, user2);
//		Iterable<User> userIterable = bean.saveAll(users);
//
//		userIterable.forEach(System.out::println);
//
//		System.out.println("Saved User "+userIterable);
//		System.out.println("done");


		// Update the user of id = 1
//		Optional<User> optional = bean.findById(1);
//		User user = optional.get();
//		user.setName("Iron Man");
//		user.setCity("New York");
//		user.setStatus("I am Iron Man");
//		User result = bean.save(user);
//		System.out.println(result);

		// How to get Data
//		Iterable<User> itr = bean.findAll();
//        for (User user : itr) {
//            System.out.println(user);
//        }

//		itr.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User user) {
//				System.out.println(user);
//			}
//		});

//		itr.forEach(System.out::println);

		//Deleting the user Element
//		bean.deleteById(1);
//		System.out.println("deleted");
//		System.out.println("yoo");
//		System.out.println("Test");

//		List<User> byName = bean.findByName("Thor");
//		byName.forEach(System.out::println);

//		List<User> byNameAndCity = bean.findByNameAndCity("Thor", "Asgard");
//		byNameAndCity.forEach(System.out::println);

//		List<User> startingWith = bean.findByNameStartingWith("T");
//		startingWith.forEach(System.out::println);

//		List<User> allUsers = bean.getAllUsers();
//		allUsers.forEach(System.out::println);

//		List<User> byName = bean.getUserByName("Thor");
//		byName.forEach(System.out::println);

		List<User> nameAndCity = bean.getUserByNameAndCity("Thor", "Asgard");
		nameAndCity.forEach(System.out::println);

	}

}
