package com.example.demo.Repo;

import com.example.demo.Entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, ObjectId> {
}
