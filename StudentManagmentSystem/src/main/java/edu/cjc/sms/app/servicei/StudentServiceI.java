package edu.cjc.sms.app.servicei;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

	void saveData(Student s);

	List<Student> getALLStudents();

	List<Student> getStudentByBatch(String batchNumber);

	Student getSingleData(int studentId);

	void updateStudentFees(int studentId, double ammount);

	void deleteStudent(int studentId);

}
