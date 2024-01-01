//package com.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Timestamp; // Import Timestamp class
//import java.util.Date;
//import com.DAO.JobDAO;
//import com.DB.DBConnect;
//import com.entity.Job;
//
//@WebServlet("/addJob")
//public class AddPostServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String title = req.getParameter("title");
//            String location = req.getParameter("location");
//            String category = req.getParameter("category");
//            String status = req.getParameter("status");
//            String desc = req.getParameter("desc");
//
//            Job j = new Job();
//            j.setTitle(title);
//            j.setDescription(desc);
//            j.setLocation(location);
//            j.setStatus(status);
//            j.setCategory(category);
//
//            // Create a Timestamp with the current date and time
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//            j.setPdate(timestamp); // Set the date in the Job object
//
//            HttpSession session = req.getSession();
//
//            Connection conn = DBConnect.getConn();
//            PreparedStatement ps = null;
//            boolean f = false;
//
//            try {
//                String sql = "INSERT INTO job(title, description, category, status, location, pdate) VALUES (?, ?, ?, ?, ?, ?)";
//                ps = conn.prepareStatement(sql);
//                ps.setString(1, j.getTitle());
//                ps.setString(2, j.getDescription());
//                ps.setString(3, j.getCategory());
//                ps.setString(4, j.getStatus());
//                ps.setString(5, j.getLocation());
//                ps.setTimestamp(6, j.getPdate());
//
//                int i = ps.executeUpdate();
//                if (i == 1) {
//                    f = true;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                // Close the PreparedStatement
//                if (ps != null) {
//                    try {
//                        ps.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            if (f) {
//                session.setAttribute("succMsg", "Job Post Successfully...");
//                resp.sendRedirect("addJob.jsp");
//            } else {
//                session.setAttribute("succMsg", "Something went wrong on the server");
//                resp.sendRedirect("addJob.jsp");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JobDAO;
import com.DB.DBConnect;
import com.entity.Job;

@WebServlet("/addJob")
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		try {
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");

			Job j = new Job();
			j.setTitle(title);
			j.setDescription(desc);
			j.setLocation(location);
			j.setStatus(status);
			j.getCategory();

			HttpSession session = req.getSession();

			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f = dao.addJob(j);
			if (f) {
				session.setAttribute("succMsg", "Job Post Sucessfully…");
				resp.sendRedirect("addJob.jsp");

			} else {
				session.setAttribute("succMsg", "Something went wrong on server");
				resp.sendRedirect("addJob.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
