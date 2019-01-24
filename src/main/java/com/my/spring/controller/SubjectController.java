package com.my.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.model.Subject;
import com.my.spring.service.SubjectService;

@Controller
public class SubjectController {

	private SubjectService subjectService;
	
	@Autowired
	@Qualifier(value="subjectService")
	public void setSubjectService(SubjectService subjectService){
		this.subjectService=subjectService;
	}
	
	@RequestMapping(value={"/subjects","/"},method=RequestMethod.GET)
	public String ListSubjects(Model model){
		model.addAttribute("subject", new Subject());
		model.addAttribute("listSubjects", subjectService.listSubjects());
		return "subject";
	}
	
	@RequestMapping(value="/subject/add",method=RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") Subject subject){
		
		if (subject.getId()==0){
			//new subject
			subjectService.addSubject(subject);
		}
		else{
			//update
			subjectService.updateSubject(subject);
		}
		
		return "redirect:/subjects";
	}
	
	@RequestMapping("/subject/remove/{id}")
	public String removeSubject(@PathVariable("id") int id){
		
		subjectService.removeSubject(id);
		return "redirect:/subjects";
	}
	
	@RequestMapping("/subject/edit/{id}")
	public String editSubject(@PathVariable("id") int id,Model model){
		model.addAttribute("subject", subjectService.getSubjectById(id));
		model.addAttribute("listSubjects", subjectService.listSubjects());
		return "subject";
	}
	
}
