<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<core:if test="${action==null }">
	<core:set var="action" value="Register" scope="request"/>
</core:if>


	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
<style>
	.error{
		color:red;
	}
</style>	
	<script type="text/javascript">
		$(function(){
			
			$(".customerform").validate({
				rules:{
					custFName:{
						required:true,
						minlength:3
					},
					custEmailId:{
						required:true,
						minlength:3,
						email:true,
					},
				},
				messages:{
					custFName:{
						required:"Please Enter your First Name",
						minlength:"First name must be contain more then 3 Letters."
					}
				}
			});
			
	// Email Varification
	
		$("input[name=custEmailId]").keyup(function(){
			var emailid = this.value;
			
			var data = {action:"EmailVarification","custEmailId":emailid};
			
			$.post("customerC",data,function(response){
				
				$("#status").html(response);
				
				
			});
		})
			
		});
	</script>

        
        
        <div id="templatemo_content_right">
       	 	<h1>Customer Form</h1>
       	 	<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       		<h3>${action} Customer Details</h3>
        	<form class="customerform" action="customerC" method="post">
        		<input type="hidden" name="action" value="${action}">
        		<table class="table table-bordered w-75 m-auto">
        		
        		<core:if test="${action=='Update'}">
        			<tr>
        				<th><label class="text-white" for="custId">Id</label></th>
        				<td><input class="form-control" type="text" name="custId" value="${custObj.custId}" readonly></td>
        			</tr>
        		</core:if>
        			<tr>
        				<th><label class="text-white" for="custFName">First Name</label></th>
        				<td><input class="form-control" type="text" name="custFName" value="${custObj.custFName}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="custLName">Last Name</label></th>
        				<td><input class="form-control" type="text" name="custLName" value="${custObj.custLName}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="custEmailId">Email Id</label></th>
        				<td><input class="form-control" type="text" name="custEmailId" value="${custObj.custEmailId}"><span id="status"></span></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="custMobileNo">Mobile No</label></th>
        				<td><input class="form-control" type="text" name="custMobileNo" value="${custObj.custMobileNo}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="custPassword">Password</label></th>
        				<td><input class="form-control" type="password" name="custPassword" value="${custObj.custPassword}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="custAddress">Address</label></th>
        				<td><input class="form-control" type="text" name="custAddress" value="${custObj.custAddress}"></td>
        			</tr>
					<tr>
						<td colspan="2">
							<a href="login.jsp">Already Register Click here</a>
						</td>	
					</tr>
        			<tr>
        				<td align="right" colspan="2">
        					<input class="btn btn-success" type="submit" value="${action}">
        					<input class="btn btn-warning" type="reset" value="Clear">
        				</td>
        			</tr>
        		</table>
        	</form>
        
       
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>