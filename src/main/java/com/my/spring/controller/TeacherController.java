package com.my.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.model.Teacher;
import com.my.spring.service.TeacherService;

@Controller
public class TeacherController {
	
private TeacherService teacherService;
	
	@Autowired
	@Qualifier(value="teacherService")
	public void setTeacherService(TeacherService teacherService){
		this.teacherService=teacherService;
	}
	
	@RequestMapping(value={"/teachers","/"},method=RequestMethod.GET)
	public String ListTeacher(Model model){
		model.addAttribute("teacher", new Teacher());
		model.addAttribute("listTeachers", teacherService.listTeacher());
		return "teacher";
	}
	
	@RequestMapping(value="/teachers/add",method=RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher){
		
		if (teacher.getId()==0){
			System.out.println("new teacher");
			teacherService.addTeacher(teacher);
		}
		else{
			//update
			teacherService.updateTeacher(teacher);
		}
		
		return "redirect:/teachers";
	}
	
	@RequestMapping("/teacher/remove/{id}")
	public String removeTeacher(@PathVariable("id") int id){
		
		teacherService.removeTeacher(id);
		return "redirect:/teachers";
	}
	
	@RequestMapping("/teacher/edit/{id}")
	public String editSubject(@PathVariable("id") int id,Model model){
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		model.addAttribute("listTeachers", teacherService.listTeacher());
		return "teacher";
	}
}
