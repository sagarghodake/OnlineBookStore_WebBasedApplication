<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
						<th style="text-align: left;"><a class="btn btn-info" href="#">Placed Order Details</a> </th>
						
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
					<th>Order Id</th><th>${order.orderId }</th>
				</tr>
				<tr>
					<th  align="center">Order Items</th>
					<th >
						<table class="table table-hover table-dark m-auto">
							<tr>
								<th>Name</th><th>Quantity</th><th>Price</th>
							</tr>
						<core:forEach var="cart" items="${order.orderedCartItems}">
							<tr>
								<th>${cart.book.bookName }</th><th>${cart.cartQuantity} </th><th>${cart.book.bookPrice }</th>
							</tr>
							</core:forEach>
						</table>
					</th>
				</tr>
				<tr>
					<th>Order Amount</th><th>${order.totalAmount}</th>
				</tr>
				<tr>
					<th>Order Date</th>
					<th>
						<fmt:parseDate var="date" value="${order.orderDate }" pattern="yyyy-MM-dd'T'hh:mm:ss"/>
						<fmt:formatDate value="${date}" type="both" dateStyle="medium" timeStyle="short"/>
					
					</th>
				</tr>
				<tr>
					<th>Order Status</th><th>${order.orderStatus }</th>
				</tr>
			</tbody>
		</table>
         <div class="cleaner_with_height">&nbsp;</div>
           
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>