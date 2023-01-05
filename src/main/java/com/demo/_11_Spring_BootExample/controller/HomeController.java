package com.demo._11_Spring_BootExample.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo._11_Spring_BootExample.model.Employee;


@Controller
public class HomeController {

	@Autowired
	private SessionFactory sf;

	@RequestMapping("/")
	public String openLoginPage() {

		return "login";
	}

	@RequestMapping("/regpage")
	public String openRegPage() {

		return "registration";
	}

	@RequestMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {

		Session session = sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();

		return "login";
	}

}
