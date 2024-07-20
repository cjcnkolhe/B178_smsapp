package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Controller
public class AdminController {

	@Autowired
	StudentServiceI ssi;
	int a=10;
	int b=20;
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		
		  if(username.equals("ADMIN") && password.equals("ADMIN")) {
			  List<Student> list=ssi.getALLStudents();
			  m.addAttribute("data", list);
			  return "adminscreen";
		  }else {
			  m.addAttribute("msg","login creaditial invalid");
			  return "login";
		  }
		
		
		
	}
	@RequestMapping("/enroll_student")
	public String saveStudentDetails(@ModelAttribute Student s) {
		   ssi.saveData(s);
		
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
		List<Student> list=ssi.getStudentByBatch(batchNumber);
		   if(list.size()>0)
		   {
			   m.addAttribute("data", list);
			   return "adminscreen";
		   }else {
			   List<Student> list1=ssi.getALLStudents();
			   m.addAttribute("data", list1);
			   m.addAttribute("message","no record found for this batch "+batchNumber);
			   return "adminscreen";
		   }

	}
	
	@RequestMapping("/fees")
	public String feesChange(@RequestParam("id") int studentId,Model m) {
		     Student s   =ssi.getSingleData(studentId);
		     m.addAttribute("st", s);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payFees(@RequestParam("studentid")int studentId,@RequestParam("ammount") double ammount,Model m) {
		
		             ssi.updateStudentFees(studentId,ammount);
		             List<Student> list=ssi.getALLStudents();
		             m.addAttribute("data",list);
		return "adminscreen";
	}
	
	
	
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int studentId,Model m) {
		     ssi.deleteStudent(studentId);
		     List<Student> list=ssi.getALLStudents();
             m.addAttribute("data",list);
		return "adminscreen";
	}
	
	
}
