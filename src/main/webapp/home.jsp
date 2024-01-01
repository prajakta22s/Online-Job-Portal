<%@ page import="com.DAO.JobDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.Job" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User: View Job</title>
    <%@ include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
    <%@ include file="all_component/navbar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h5 class="text-center text-primary">All Jobs</h5>

                <c:if test="${not empty succMsg}">
                    <h4 class="text-center text-danger">${succMsg}</h4>
                    <c:remove var="succMsg" />
                </c:if>

                <div class="card">
                    <div class="card-body">
                        <form class="form-inline" action="more_view.jsp" method="get">
                            <div class="form-group col-md-5 mt-1">
                                <h5>Location</h5>
                                <!-- Add your location options here -->
                            </div>
                            <div class="form-group col-md-4 mt-1">
                                <h5>Category</h5>
                                <!-- Add your category options here -->
                            </div>
                            <div class="form-group col-md-5">
                                <label>Location</label>
                                <select name="loc" class="custom-select" id="inlineFormcustomSelectPref">
                                    <option selected>Choose...</option>
                                    <!-- Your location options -->
                                    <option value="Odisha">Odisha</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Gujurat">Gujurat</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
									<option value="Delhi">Delhi</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Chennai">Chennai</option>
									<option value="Hyderabad">Hyderabad</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label>Category</label>
                                <select class="custom-select" name="cat" id="inlineFormcustomSelectPref">
                                    <option selected>Choose...</option>
                                    <!-- Your category options -->
                                    <option value="IT">IT</option>
									<option value="Developer">Developer</option>
									<option value="Banking">Banking</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
                                </select>
                            </div>
                            <button class="btn btn-success">Submit</button>
                        </form>
                    </div>
                </div>

                <% 
                JobDAO dao = new JobDAO(DBConnect.getConn());
                List<Job> list = dao.getAllJobsForUser();
                for (Job j : list) {
                %>
                <div class="card mt-2">
                    <div class="card-body">
                        <div class="text-center text-primary">
                            <i class="far fa-clipboard fa-2x"></i>
                        </div>
                        <h6><%= j.getTitle() %></h6>

                        <% 
                        String description = j.getDescription();
                        if (description.length() > 0 && description.length() < 120) { 
                        %>
                            <p><%= description %></p>
                        <% } else { %>
                            <p><%= description.substring(0, Math.min(description.length(), 120)) %>...</p>
                        <% } %>

                        <br>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control form-control-sm" value="Location: <%= j.getLocation() %>" readonly>
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control form-control-sm" value="Category: <%= j.getCategory() %>" readonly>
                            </div>
                        </div>
                        <h6>Publish Date: <%= j.getPdate().toString() %></h6>
                        <div class="text-center">
                            <a href="one_view.jsp?id=<%= j.getId() %>" class="btn btn-sm bg-success text-white">View More</a>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
