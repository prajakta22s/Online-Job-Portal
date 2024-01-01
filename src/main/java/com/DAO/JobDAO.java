package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.DB.DBConnect;
import com.entity.Job;

public class JobDAO {
	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addJob(Job j) {
		boolean f=false;
		try {
			String sql="insert into jobs(title,description,category,status,location) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public List<Job> getAllJobs() {
	    List<Job> list = new ArrayList<>();
	    Job j = null;

	    try {
	        String sql = "select * from jobs order by id desc";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        //ps.setString(1, "Active");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            j = new Job();
	            j.setId(rs.getInt(1));
	            j.setTitle(rs.getString(2));
	            j.setDescription(rs.getString(3));
	            j.setCategory(rs.getString(4));
	            j.setStatus(rs.getString(5));
	            j.setLocation(rs.getString(6));
	            j.setPdate(rs.getTimestamp(7)+"");
	            // Add other setters as needed
	            list.add(j);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	
	public List<Job> getAllJobsForUser() {
	    List<Job> list = new ArrayList<>();
	    Job j = null;

	    try {
	        String sql = "select * from jobs where status=? order by id desc";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, "Active");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            j = new Job();
	            j.setId(rs.getInt(1));
	            j.setTitle(rs.getString(2));
	            j.setDescription(rs.getString(3));
	            j.setCategory(rs.getString(4));
	            j.setStatus(rs.getString(5));
	            j.setLocation(rs.getString(6));
	            j.setPdate(rs.getTimestamp(7)+"");
	            // Add other setters as needed
	            list.add(j);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public Job getJobById(int id) {
	    //List<Job> list = new ArrayList<>();
	    Job j = null;

	    try {
	        String sql = "SELECT * FROM jobs WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1,id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            j = new Job();
	            j.setId(rs.getInt(1));
	            j.setTitle(rs.getString(2));
	            j.setDescription(rs.getString(3));
	            j.setCategory(rs.getString(4));
	            j.setStatus(rs.getString(5));
	            j.setLocation(rs.getString(6));
	            j.setPdate(rs.getTimestamp(7)+"");
	            // Add other setters as needed
	            //list.add(j);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return j;

}
	public boolean updateJob(Job j) {
		boolean f=false;
		try {
			String sql="update jobs set title=?,description=?,category=?,status=?,location=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6,j.getId());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJob(int id) {
		boolean f=false;
		try {
			String sql="delete from jobs where id=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return f;
		
	}
	
	public List<Job> getJobsAndLocationAndCate(String category, String location) {
	    List<Job> list = new ArrayList<>();
	    //Connection conn = DBConnect.getConn(); // Assuming DBConnect has a static method getConn to get a connection
	    Job j;
	    try {
	        String sql = "SELECT * FROM jobs WHERE category = ? AND location = ? order by id desc";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, category);
	        ps.setString(2, location);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            j = new Job();
	            j.setId(rs.getInt(1));
	            j.setTitle(rs.getString(2));
	            j.setDescription(rs.getString(3));
	            j.setCategory(rs.getString(4));
	            j.setLocation(rs.getString(5));
	            j.setStatus(rs.getString(6));
	            j.setPdate(rs.getString(7));
	            list.add(j);
	        }
	        
	        //rs.close();
	        //ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception as needed
	    }
	  
	    return list;
	}
	
	
	public List<Job> getJobsOrLocationAndCate(String category, String location) {
	    List<Job> list = new ArrayList<>();
	    //Connection conn = DBConnect.getConn(); // Assuming DBConnect has a static method getConn to get a connection
	    Job j;
	    try {
	        String sql = "SELECT * FROM jobs WHERE category = ? OR location = ? order by id desc";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, category);
	        ps.setString(2, location);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            j = new Job();
	            j.setId(rs.getInt(1));
	            j.setTitle(rs.getString(2));
	            j.setDescription(rs.getString(3));
	            j.setCategory(rs.getString(4));
	            j.setLocation(rs.getString(5));
	            j.setStatus(rs.getString(6));
	            j.setPdate(rs.getString(7));
	            list.add(j);
	        }
	        
	        //rs.close();
	        //ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception as needed
	    }
	  
	    return list;
	}

}
