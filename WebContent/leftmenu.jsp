<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Publisher</h1>
                <ul>
                <core:forEach var="publisher" items="${publishers}">	
                    <li><a href="bookC?action=searchbypublisher&publisher=${publisher}">${publisher}</a></li>
                </core:forEach>
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Author</h1>
                <ul>
                    <li><a href="#">demo....</a></li>
                    
            	</ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div>
        </div> <!-- end of content left -->