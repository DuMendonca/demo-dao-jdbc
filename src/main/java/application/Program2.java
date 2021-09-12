package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n\n =====TEST 1: seller findById ======\n");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n\n =====TEST 2: seller findAll ======\n");
        List<Department> listAll = departmentDao.findAll();
        listAll.forEach(seller1 -> System.out.println(seller1));

        System.out.println("\n\n =====TEST 3: seller insert ======\n");
        Department newDepartment = new Department(null, "DepartmentTESTE");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n\n =====TEST 4: seller update ======\n");
        department = departmentDao.findById(1);
        department.setName("Martha Wayne");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n\n =====TEST 5: seller delete ======\n");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}