//package com.entity;
//
//import com.google.protobuf.Timestamp;
//
//public class Job {
//	private int id;
//	private String title;
//	private String description;
//	private String category;
//	private String status;
//	private String location;
//	private java.sql.Timestamp pdate;
//	
//	public Job(String title, String description, String category, String status, String location, java.sql.Timestamp pdate) {
//		super();
//		this.title = title;
//		this.description = description;
//		this.category = category;
//		this.status = status;
//		this.location = location;
//		this.pdate = pdate;
//	}
//	public Job() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	public java.sql.Timestamp getPdate() {
//		return pdate;
//	}
//	public void setPdate(java.sql.Timestamp timestamp) {
//		this.pdate = 
//				timestamp;
//	}
//	
//
//}

package com.entity;

public class Job {
	private int id;
	private String title;
	private String description;
	private String category;
	private String status;
	private String location;
	private String pdate;
	
	public Job(String title, String description, String category, String status, String location, String pdate) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.location = location;
		this.pdate = pdate;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	

}


