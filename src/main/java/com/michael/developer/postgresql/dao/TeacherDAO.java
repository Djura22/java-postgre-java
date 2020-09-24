package com.michael.developer.postgresql.dao;

import com.michael.developer.postgresql.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface TeacherDAO extends CrudRepository<Teacher, UUID> {}

