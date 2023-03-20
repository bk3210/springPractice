package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShapeController {
	
	@RequestMapping(value="/circle/{x:.+}", method=RequestMethod.GET)
	public String circle(Model model, @PathVariable("x")double x) {
		System.out.println("x: " + x);
		
		model.addAttribute("x", x);
		model.addAttribute("result", x*x*3.14);
		return "circle";
	}
	
	@RequestMapping(value="/rectangle/{x}/{y}", method=RequestMethod.GET)
	public String rectangle(Model model, @PathVariable("x")int x, @PathVariable("y")int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", x*y);
		return "rectangle";
	}
	
	@RequestMapping(value="/triangle/{x}/{y}", method=RequestMethod.GET)
	public String triangle(Model model, @PathVariable("x")int x, @PathVariable("y")int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", (x*y)/2);
		return "triangle";
	}

}
