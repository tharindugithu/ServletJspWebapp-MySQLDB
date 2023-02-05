package com.tharindu.web;

import java.io.IOException;

import com.tharindu.web.dao.PersonDao;
import com.tharindu.web.model.Person;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class GetPersonController
 */
public class GetPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		 int id = Integer.parseInt(request.getParameter("pid"));
		 try {
			 PersonDao pdo = new PersonDao();
			 Person p = pdo.getPerson(id);
			 
			 request.setAttribute("person", p);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("showPerson.jsp");
			 rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


}
