<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
   	<style>
		.error{
			color:red;
		}
	</style>	     
     <script type="text/javascript">
	$(function(){		
		/* $.validator.addMethod("password",function(value,element){
			isPassword = value.match("^[A-Z]+[a-z0-9,@_]{5,}$")
			return isPassword==value;
		}); */

		$(".loginform").validate({
			rules:{
				usertype:{
					required:true
				},
				username:{
					required:true,
					email:true
				},
				/* password:{
					required:true,
					password:true,
					minlength:3,
					maxlength:8
				} */
			},
			messages:{
				usertype:{
					required:"Please Select Usertype"
				},
				username:{
					required:"Please Enter a Mobile No or Email Id",
					email:"Enter valid Email Id......"
				},
				/* password:{
					required:"Please Enter password",
					password:"Please enter valid password<br/>should be start with Capital letter and also contain digits and @ _ only"
				} */
			}
		});
		
	});
	

</script>   
        <div id="templatemo_content_right">
        
     		<h1>Login Form</h1>
       	 	<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>   
        	<form class="loginform" action="loginC" method="post">
        		<input type="hidden" name="action" value="login">
				<table class="table table-bordered w-75 m-auto" >
					<tr>
						<td><label class="text-white"><strong>Usertype</strong></label ></td>
						<td>
							<select class="form-control" id="usertype" name="usertype" >
								<option value="">Select</option>
								<option>Admin</option>
								<option>Customer</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label class="text-white"><strong>Username</strong></label ></td>
						<td>
							<input class="form-control" type="text" id="username" name="username" placeholder="mobile Number or Email Id">
						</td>
					</tr>
					<tr>
						<td><label class="text-white"><strong>Password</strong></label ></td>
						<td>
							<input class="form-control" type="password" id="password" name="password" placeholder="e.g Abc@123">
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2">
							<a href="customerform.jsp">New User Click here</a><br/>
							<a href="forgetpasswordform.jsp">Forget Password</a>
						</td>	
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input class="btn btn-warning"  type="reset" value="Clear"/>
							<input class="btn btn-success"  type="submit" value="Login"/>
						</td>
					</tr>
				</table>
			</form>
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>