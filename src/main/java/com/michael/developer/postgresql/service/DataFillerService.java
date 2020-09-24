package com.michael.developer.postgresql.service;


import com.michael.developer.postgresql.dao.CourseDAO;
import com.michael.developer.postgresql.dao.TeacherDAO;
import com.michael.developer.postgresql.entities.Course;
import com.michael.developer.postgresql.entities.Teacher;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

public class DataFillerService {
    private final CourseDAO courseDAO;
    private final TeacherDAO teacherDAO;
    public DataFillerService(CourseDAO courseDAO, TeacherDAO teacherDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
    }
    @PostConstruct
    @Transactional
    public void fillData(){
        Teacher pj = new Teacher(
                "Professor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"

        );
        Teacher px = new Teacher(
                "Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com"
        );
        teacherDAO.save(pj);
        teacherDAO.save(px);

        Course mathematics = new Course("Mathematics", 20, (short) 10, pj);
        Course spanish = new Course("Spanish", 20, (short) 10, pj);
        Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100, pj);
        Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100, pj);
        Course introductionToPsychology = new Course("Introduction to psychology", 90, (short) 100, pj);
        courseDAO.save(mathematics);
        courseDAO.save(spanish);
        courseDAO.save(dealingWithUnknown);
        courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);
    }
}
