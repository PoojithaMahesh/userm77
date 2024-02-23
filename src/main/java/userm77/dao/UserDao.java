package userm77.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import userm77.dto.User;

public class UserDao {

	public void saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	public void updateUser(int id,User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
//			that id is present so i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setId(id);
			entityManager.merge(user);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present in the dataBase");
		}
	}
	
	public void findUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
            System.out.println(dbUser);
			
		}else {
			System.out.println("Sorry id is not present in the dataBase");
		}
	}
	public void deleteUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
           EntityTransaction entityTransaction=entityManager.getTransaction();
           entityTransaction.begin();
           entityManager.remove(dbUser);
           entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present in the dataBase");
		}
	}
	
}
