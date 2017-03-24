package at.luzi.service;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import at.luzi.entity.User;

@Stateless
@LocalBean
@PermitAll
public class UserService {

	@Inject
	private EntityManager em;

	public User createUser() {
		User user = new User();
		return user;
	}

	public User saveUser(User user) {

		if (user.getId() == null) {
			user.setCreateTime(new Date());
			em.persist(user);
		} else {
			em.merge(user);
		}
		em.flush();

		return loadUser(user.getId());
	}

	public User loadUser(Integer id) {
		return em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
	}

}
