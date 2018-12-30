<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jwp"%>
 
 <c:if test="${empty results}">
 	No results.
 </c:if>
 
 
 <c:forEach var="result" items="${results}">
  
 	<p>
 	 <strong>${result.userId} ${result.firstname} ${result.surname}</strong> 
 	 
 	 <c:forEach var="interest" items="${result.interests}">
 	 	${interest}
 	 </c:forEach>
    </p>
 	 
 </c:forEach>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 