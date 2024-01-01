package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.User;
@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		try {
		    String name = req.getParameter("name");
		    
		    String email = req.getParameter("email");
		    String password = req.getParameter("password");
		    String qualification = req.getParameter("qualification");
		    
		    
		    UserDAO dao = new UserDAO(DBConnect.getConn());
		    User u = new User(name, email, password,qualification,"User"); // Assuming your User class constructor takes name, email, password, and qualification
		    boolean f = dao.addUser(u);
		    
		    HttpSession session = req.getSession();
		    
		    if (f) {
		        session.setAttribute("succMsg", "Registration Successfully");
		        resp.sendRedirect("signup.jsp");
		    } else {
		        session.setAttribute("succMsg", "Registration Failed. Please try again.");
		        resp.sendRedirect("signup.jsp");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	
}
