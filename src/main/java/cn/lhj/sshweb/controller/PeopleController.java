package cn.lhj.sshweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.lhj.sshweb.model.People;
import cn.lhj.sshweb.service.PeopleService;

@Controller
public class PeopleController{
	@RequestMapping(value = {"/people"})
	public String testPeople(HttpServletRequest req,HttpServletResponse resp) {
		ServletContext servletContext = req.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		PeopleService peopleService = (PeopleService) applicationContext.getBean("peopleService");
		return "people";
	}
}
