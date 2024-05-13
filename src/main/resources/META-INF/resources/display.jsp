<%@ include file="/init.jsp" %>

<%@ page import="java.time.LocalDate" %>
<%
String expiry=(String)request.getAttribute("expiry");
LocalDate expiryDate = LocalDate.parse(expiry);
LocalDate currentDate = LocalDate.now();

if(expiryDate.isAfter(currentDate))
{
	//out.print("greater");
%>

<div id="expiryBanner" style="background-color: #ff0000; color: #ffffff; padding: 10px; text-align: center; position: fixed; bottom: 0; left: 0; width: 100%;"></div>

<%}%>

<h2 style="margin: 50px 50px 50px 50px;">Expiry date is <%=expiry %></h2>