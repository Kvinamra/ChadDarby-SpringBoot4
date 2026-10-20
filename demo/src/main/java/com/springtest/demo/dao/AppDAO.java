package com.springtest.demo.dao;

import com.springtest.demo.entity.Course;
import com.springtest.demo.entity.Instructor;
import com.springtest.demo.entity.InstructorDetail;
import com.springtest.demo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);

    // hb-04-one-to-many-uni
    void save(Course theCourse);
    Course findCourseAndReviewByCourseId(int theId);

    /* hb-05-many-to-many */
    Course findCourseAndStudentByCourseId(int theId);
    Student findStudentAndCoursesByStudentId(int theId);
    void update(Student tempStudent);
    void deleteStudentById(int theId);
}
