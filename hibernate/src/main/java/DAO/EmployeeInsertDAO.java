package DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import DTO.EmpDTO;

public class EmployeeInsertDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();

			EmpDTO emp1 = new EmpDTO();
			emp1.setId(1);
			emp1.setName("roronoa");
			emp1.setDesignation("swordsman");
			emp1.setSalary(10000000);

			EmpDTO emp2 = new EmpDTO();
			emp2.setId(2);
			emp2.setName("sanji");
			emp2.setDesignation("cook");
			emp2.setSalary(10000000);

			manager.persist(emp1);
			manager.persist(emp2);

			transaction.commit();
		} finally {
			closeConnection();
		}
	}

}