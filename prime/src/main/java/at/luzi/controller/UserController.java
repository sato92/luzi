package at.luzi.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.luzi.entity.User;
import at.luzi.service.UserService;

@Named
@ViewScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = -9134311787452480002L;

	@Inject
	private UserService userService;

	private User user;

	@PostConstruct
	public void init() {
		user = userService.createUser();
	}

	public void saveUser() {
		user = userService.saveUser(user);
	}

	public User getUser() {
		return user;
	}

}
