package DTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DAO.StudenDao;

public class StudentDTO {

	
		public static void main(String[] args) {
			
			EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("hibernate");
			EntityManager entityManager = 
					entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = 
					entityManager.getTransaction();
			
			entityTransaction.begin();
			
			StudenDao student1 = new StudenDao();
			student1.setId(1);
			student1.setName("zoro");
			student1.setMail("zoro@gmail.com");
			student1.setMarks(70);
			student1.setAdd("Pune");
			
			
			entityManager.persist(student1);
			
			entityTransaction.commit();
			
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			
		}



}
