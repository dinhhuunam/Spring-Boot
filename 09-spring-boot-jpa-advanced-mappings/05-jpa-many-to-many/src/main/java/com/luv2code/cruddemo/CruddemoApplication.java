package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
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

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){

		return runner -> {
			//createCourseAndStudent(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourse(appDAO);

			//addMoreCourseForStudent(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting student id: "+theId);

		appDAO.deleteStudentById(theId);

		System.out.println("DONE!!!");
	}

	private void addMoreCourseForStudent(AppDAO appDAO) {
		int theId = 4;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		//create more course
		Course tempCourse1 = new Course("Rubik 's Cube-How to speed Cube");
		Course tempCourse2 = new Course("Learn Javascript");

		//add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Saving student: "+tempStudent);
		System.out.println("Associated courses: "+tempStudent.getCourses());

		appDAO.update(tempStudent);
		System.out.println("DONE!!!");
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 3;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		System.out.println("Loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());

		System.out.println("DONE!!!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 12;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());

		System.out.println("DONE!!!");
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		//create a course
		Course tempCourse = new Course("Pacman - How to Score Million Point");

		//create a student
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Dinh","Nam","dinhnam.job@gmail.com");
		//add student to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		//save the course and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("Associated students: "+tempCourse.getStudents());

		appDAO.save(tempCourse);
		System.out.println("DONE!!!");
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: "+theId);

		//will delete course and associated reviews thanks to CascadeType.ALL
		appDAO.deleteCourseById(theId);

		System.out.println("DONE!!!");
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		//get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		//print the course
		System.out.println(tempCourse);
		//print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("DONE!!!");
	}

	private void createCourseAndReview(AppDAO appDAO) {
		//create a course
		Course tempCourse = new Course("Spring Boot Udemy");
		//add some reviews
		tempCourse.addReview(new Review("Great course...loved it"));
		tempCourse.addReview(new Review("I loved it so much"));
		tempCourse.addReview(new Review("Great course"));
		//save the course ... leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
		System.out.println("DONE!!!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 12;
		System.out.println("Deleting course id: "+theId);

		appDAO.deleteCourseById(theId);

		System.out.println("DONE!!!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 1;

		//find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update the course
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);
		System.out.println("DONE!!!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("DONE!!!");
	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {
		int theId = 1;
		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Temp Instructor: "+tempInstructor);
		System.out.println("the associated course: "+tempInstructor.getCourses());

		System.out.println("DONE!!!");
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Temp Instructor: "+tempInstructor);

		//find courses for instructor
		System.out.println("Finding course for instructor id: "+theId);
		List<Course> courses = appDAO.findCourseByInstructorId(theId);
		System.out.println(courses);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("The associated course: "+tempInstructor.getCourses());
		System.out.println("Done!!!");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Temp Instructor: "+tempInstructor);
		System.out.println("The associated course: "+tempInstructor.getCourses());

		System.out.println("DONE!!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create the instructor
		Instructor tempInstructor =
				new Instructor("Susan","Public","susan.public@luv2code.com");
		//create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtub.com",
						"Video Games");
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Piano Course");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
		//Note: this will ALSO save the courses
		//because of CascadeType.PERSIST

		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The course: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("DONE!!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor detail id: "+theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		//get the instructor detail object
		int theId = 5;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("Temp Instructor Detail: "+tempInstructorDetail);
		//print the associated instructor
		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());

		System.out.println("DONE!!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		//create the instructor
		Instructor tempInstructor =
				new Instructor("Chad","Darby","darby@luv2code.com");
		//create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www/.luv2code.com/youtube",
						"Luv 2 code!!!");
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		*/

		//create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu","Patel","madhu@luv2code.com");
		//create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www/.luv2code.com/youtube",
						"Guitar");
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//NOTE: this will ALSO save the details object
		//because of CascadeType.ALL
		//
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("DONE!!!");
	}
}
