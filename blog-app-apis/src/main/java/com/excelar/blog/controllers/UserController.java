package com.excelar.blog.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelar.blog.payloads.UserDto;
import com.excelar.blog.services.UserService;

@RestController
@RequestMapping("/apis/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto createUserDto = this.userService.createUser(userDto);

		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {

		UserDto udatedUser = this.userService.updateUser(userDto,uid);

		return ResponseEntity.ok(udatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser( @PathVariable("userId") Integer uid) {

		this.deleteUser(uid);
		return new ResponseEntity(
				Map.of("message","User Deleted Successfully"),HttpStatus.OK);
	}
}
