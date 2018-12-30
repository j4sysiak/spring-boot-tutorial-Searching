<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jwp"%>
 
 
<div class="row">
	<div class="col-md-12 results-noresult">
		<c:if test="${empty results}">
   			No results.
		</c:if>
	</div>
</div>


 
 
 <c:forEach var="result" items="${results}">
 
 <c:url var="profilePhoto" value="/profilephoto/${result.userId}" />
 <c:url var="profileLink" value="/profile/${result.userId}" />
 
 <div class="row">
	<div class="col-md-12">
	
		<div class="results-photo">
 			<a href="${profileLink}"><img id="profilePhotoImage" src="${profilePhoto}" /></a>
 		</div>
 		
 		<div class="results-details">
 			<div class="results-name">
 				<a href="${profileLink}"><c:out value="${result.firstname}"/> <c:out value="${result.surname}"/></a>
 			</div>
 			
 			<c:forEach var="interest" items="${result.interests}">
 	 			${interest}
 	 		</c:forEach>
 		</div>
   
	</div>
</div>

 </c:forEach>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 