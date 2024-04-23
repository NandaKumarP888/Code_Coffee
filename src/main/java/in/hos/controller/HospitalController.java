package in.hos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hos.entity.Hospital;
import in.hos.service.IHospital;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private IHospital service;
	
	@GetMapping("/form")
	public String showReg() {
		return "HospitalRegister";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Hospital hospital,Model model) {
		Integer code=service.saveSpecialization(hospital);
		String message="Specialization'"+code+"'created";
		model.addAttribute("message", message);
		  return "HospitalRegister";
	}
	
	//3.display all rows
	@GetMapping("/all")
	public String getAll(@RequestParam(required=false)String message,Model model) {
		List<Hospital> list =service.getAllSpecialization();
		model.addAttribute("list",list);
		model.addAttribute("message",message);
		return "HospitalData";
	}
	
	//4.delete row by id and redirect to all 
	@GetMapping("/delete")
	public String delete(@RequestParam Integer code,RedirectAttributes attributes) {
		service.deleteSpecialization(code);
		attributes.addAttribute("message", "Employee '"+code+"'deleted");
		return "redirect:all";
	}
	
	//5.show data in edit page
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer code,Model model) {
		Hospital hos=service.getOneSpecialization(code);
		model.addAttribute("hospital", hos);
		return "HospitalEdit";
	}
	
	//6.on click update set to DB and redirect to all
	@PostMapping("/update")
	public String update(@ModelAttribute Hospital hospital,RedirectAttributes attributes) {
		service.updateSpecialization(hospital);
		String message="Specialization'"+hospital.getCode()+"'Updated";
		attributes.addAttribute("message", message);
		return "redirect:all";
	}

}

