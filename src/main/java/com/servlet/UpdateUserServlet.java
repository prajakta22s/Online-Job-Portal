package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.User;

public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		try {
		    int id = Integer.parseInt(req.getParameter("id"));
		    String name = req.getParameter("name");
		    String qua = req.getParameter("qua");
		    String email = req.getParameter("email");
		    String ps = req.getParameter("ps");
		    
		    UserDAO dao = new UserDAO(DBConnect.getConn());
		    User u = new User();  // Assuming your User class has this constructor
		    u.setId(id);
		    u.setName(name);
		    u.setEmail(email);
		    u.setPassword(ps);
		    u.setQualification(qua);
		    
		    boolean isSuccess = dao.updateUser(u);  // Assuming the method in your DAO is named updateUser
		    
		    HttpSession session = req.getSession();  // Fix the getSession method call
		    
		    if (isSuccess) {
		        session.setAttribute("successMsg", "Profile Updated Successfully");
		        resp.sendRedirect("home.jsp");
		    } else {
		        session.setAttribute("errorMsg", "Something went wrong on the server");
		        resp.sendRedirect("home.jsp");
		    }
		} catch (Exception e) {
		    e.printStackTrace();  // Corrected the method name here
		}

	}
	

}
