<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
        
        
        <div id="templatemo_content_right">
       		<h1>My Profile</h1>
       		<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       		<table class="table table-hover table-dark m-auto" style="width:500px">
						<thead class="thead-dark">
									<tr>
										<th style="text-align: left;"><a class="btn btn-info" href="#">My Profile</a> </th>
										<th style="text-align: right;"><a class="btn btn-warning" href="customerC?action=edit&cust_id=${custObj.custId }">Edit</a></th>
										
									</tr>
									<tr>
										<th colspan="2">
											<core:if test="${msg!=null}">
												<span class="success">${msg}</span>
											</core:if>
											<core:if test="${errormsg!=null}">
												<span class="error">${errormsg}</span>
											</core:if>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Customer Id</td><td>${custObj.custId }</td>
									</tr>
									<tr>
										<td>Full Name </td><td><span style="font-variant: small-caps;"> ${custObj.custFName} ${custObj.custLName}</span></td>
									</tr>
									<tr>
										<td>Email Id </td><td> ${custObj.custEmailId} </td>
									</tr>
				 			<tr>
										<td>Mobile No </td><td>${custObj.custMobileNo}</td>
									</tr>
									<tr>
										<td>Password </td><td> ${custObj.custPassword} </td>
									</tr>
									<tr>
										<td>Address </td><td> ${custObj.custAddress} </td>
									</tr>
									<tr>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="2" style="text-align: center;">
											<a class="btn btn-danger" 
											   onclick="return confirm('Do you really want to delete this customer ')"
										 	   href="customerC?action=delete&cust_id=${custObj.custId }">
								 	   	Delete
								 	 </a>
										</td>
									</tr>
								</tfoot>
							</table>
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>