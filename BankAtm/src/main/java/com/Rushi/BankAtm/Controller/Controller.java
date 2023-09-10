package com.Rushi.BankAtm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rushi.BankAtm.DAO.ResoNotFound;
import com.Rushi.BankAtm.DAO.UserRepo;
import com.Rushi.BankAtm.Model.User;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class Controller 
{
	@Autowired
	private UserRepo repo;
	
	
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		return repo.findAll();
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user)
	{
		int accTemp = user.getAcc_num();
		System.out.println(accTemp);
		System.out.println(user.getAcc_num());
//		System.out.println(user.getFirst_name());
//		System.out.println(user.getLast_name());
//		System.out.println(user.getMail_id());
//		repo.save(user);
		return user;
	}
	
	@PostMapping("/userupdate")
	public ResponseEntity<User> updatePin(@RequestBody User user) 
	{
		User user1 = repo.findById(user.getAcc_num()).orElseThrow(()-> new ResoNotFound());
		user1.setPin(user.getPin());
		user1.setAmount(user.getAmount());
		User updateUser = repo.save(user1);
		return ResponseEntity.ok(updateUser);
	}
}
