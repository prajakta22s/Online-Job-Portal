<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
    <a class="navbar-brand" href="#">Job Portal</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            
            <c:choose>
                <c:when test="${userobj.role eq 'admin'}">
                    <li class="nav-item"><a class="nav-link" href="addJob.jsp"><i class="fa-solid fa-plus"></i>Post Job</a></li>
                    <li class="nav-item"><a class="nav-link" href="view_job.jsp"><i class="fa-solid fa-eye"></i>View Job</a></li>
                </c:when>
                
                <c:when test="${userobj.role eq 'user'}">
                    <li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal"><i class="fa-solid fa-user"></i>${userobj.name}</a></li>
                </c:when>
                
                <c:otherwise>
                    <li class="nav-item"><a class="nav-link" href="login.jsp"><i class="fa-solid fa-user"></i>Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="signup.jsp"><i class="fa-solid fa-right-to-bracket"></i>Signup</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
        
        <form class="form-inline my-2 my-lg-0">
            <c:choose>
                <c:when test="${userobj.role eq 'admin'}">
                    <a href="#" class="btn btn-light mr-1"><i class="fa-solid fa-user"></i>Admin</a>
                </c:when>
                
                <c:when test="${userobj.role eq 'user'}">
                    <a href="logout" class="btn btn-light"><i class="fa-solid fa-right-to-bracket"></i>Logout</a>
                </c:when>
                
                <c:otherwise>
                    <a href="login.jsp" class="btn btn-light mr-1"><i class="fa-solid fa-user"></i>Login</a>
                    <a href="signup.jsp" class="btn btn-light"><i class="fa-solid fa-right-to-bracket"></i>Signup</a>
                </c:otherwise>
            </c:choose>
        </form>
    </div>
</nav>




<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <!-- Modal content remains unchanged -->
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="card">
                    <div class="card-body">
                        <div class="text-center text-primary">
                            <i class="fas fa-user-circle fa-5x"></i>
                        </div>
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th scope="row">Name</th>
                                    <td>${userobj.name}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Qualification</th>
                                    <td>${userobj.qualification}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Email</th>
                                    <td>${userobj.email}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a href="edit_profile.jsp" class="btn btn-primary">Edit</a>
            </div>
        </div>
    </div>
</div>
