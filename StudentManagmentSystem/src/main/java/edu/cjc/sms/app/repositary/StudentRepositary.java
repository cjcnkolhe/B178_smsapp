package edu.cjc.sms.app.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;
@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>
{
List<Student> findAllByBatchNumber(String batchNumber);
}
