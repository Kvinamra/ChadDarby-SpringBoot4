package com.springtest.demo;

import com.springtest.demo.dao.AppDAO;
import com.springtest.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.StandardEmitterMBean;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourse(appDAO);

			//hb-04-one-to-many-uni
			//createCourseAndReviews(appDAO);
			//findCourseAndReviewsByCourseId(appDAO);
			//deleteCourseAndReviews(appDAO);

			/* hb-05-many-to-many */
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 2;

		System.out.println("Deleting Student with id " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Deleted Student with id " + theId);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("System Design - A to Z");
		Course tempCourse2 = new Course("Basic Java - A to Z");
		Course tempCourse3 = new Course("Java Advanced - A to Z");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		tempStudent.addCourse(tempCourse3);

		System.out.println("Updating student : " + tempStudent);
		System.out.println("Associated courses : " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Updated student : " + tempStudent);
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 1;
		Course theCourse = appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println(theCourse);
		System.out.println(theCourse.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("DSA - A to Z");

		Student student1 = new Student("Vinamra", "Kishore", "k***2@gmail.com");
		Student student2 = new Student("Naman", "Kishor", "k***n@gmail.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course : " + course);
		System.out.println("Saving the student : " + course.getStudents());

		appDAO.save(course);

		System.out.println("Course saved successfully");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting Course with id " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted Course with id " + theId);
	}

	private void findCourseAndReviewsByCourseId(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding the course with id " + theId);
		Course theCourse = appDAO.findCourseAndReviewByCourseId(theId);
		System.out.println("Course : "  + theCourse);
		System.out.println("Reviews : "  + theCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course theCourse = new Course("System Design - A to Z");

		theCourse.addReview(new Review("This is a test review"));
		theCourse.addReview(new Review("This is a test2 review"));
		theCourse.addReview(new Review("This is a test3 review"));

		System.out.println("Saving the course");
		System.out.println(theCourse);
		System.out.println(theCourse.getReviews());

		appDAO.save(theCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 13;
		System.out.println("Deleting course id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding course by id " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course by id " + theId);
		tempCourse.setTitle("Air Guitar - All in One Guide");
		appDAO.update(tempCourse);
		System.out.println("Updated course by id " + theId);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor by id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating the instructor by id " + theId);
		tempInstructor.setLastName("KISHORE");
		appDAO.update(tempInstructor);
		System.out.println("Updated the instructor by id " + theId);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("find Instructor id : " + theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor : " + instructor);
		System.out.println("The associated courses : " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor by id " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor found: " + instructor);

		System.out.println("Find courses for instructor id : " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		System.out.println("Courses found: " + courses);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor by id " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor found: " + instructor);
		System.out.println("The associated courses " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Vinamra", "Kishore", "kishorevinamra1612@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.mindfreaks.com", "learning");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Create some courses
		Course tempCourse1 = new Course("The Jungle Book - The ultimate Guide");
		Course tempCourse2 = new Course("Microsoft - The ultimate Guide");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving the instructor : " + tempInstructor);
		System.out.println("Saving the instructor : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Deleting instructor detail id : " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor detail id : " + theId);
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("The instructor detail : " + theInstructorDetail);
		System.out.println("The associated instructor :" + theInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor id : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id : " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("The instructor : " + theInstructor);
		System.out.println("The associated instructor details :" + theInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Vinamra", "Kishore", "kishorevinamra1612@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.mindfreaks.com", "learning");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor : " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

}
