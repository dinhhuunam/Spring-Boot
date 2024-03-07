package com.luv2.code.cruddemo;

import com.luv2.code.cruddemo.dao.StudentDao;
import com.luv2.code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args){
//		return runner -> {
//			System.out.println("Hello world");
//		};
//	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);

			//createMultipleStudent(studentDao);

			//readStudent(studentDao);

			//queryForStudent(studentDao);

			//queryForStudentByLastName(studentDao);

			//updateStudent(studentDao);

			//deleteStudent(studentDao);

			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students");
		int numberRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: "+numberRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDao.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student... ");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDao.update(myStudent);

		//display the update student
		System.out.println("Update student: "+myStudent);
	}

	private void queryForStudentByLastName(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.findByLastName("Apple");
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDao studentDao) {

		//get a list of students
		List<Student> theStudents = studentDao.findAll();
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("Create new student object ... ");
		Student tempStudent = new Student("Paul", "Doe","paul@luve2.com");
		//save the student
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);
		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id "+theId);
		Student myStudent = studentDao.findById(theId);
		//display student
		System.out.println("Fount the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		//create the multiple students
		System.out.println("Create 3 students object ... ");
		Student tempStudent1 = new Student("Paul", "Doe","paul@luve2.com");
		Student tempStudent2 = new Student("Mary", "Public","mary@luve2.com");
		Student tempStudent3 = new Student("Bonita", "Apple","bonita@luve2.com");
		//save student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("Create new student object ... ");
		Student tempStudent = new Student("Paul", "Doe","paul@luve2.com");
		//save student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);
		//display the id of student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}