<%@ include file="/init.jsp" %>


<%
String status=request.getParameter("status");

%>

<p><%=(status==null ? "":status) %></p>

<portlet:actionURL name="handleForm" var="actionURL" />

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/display.jsp"></portlet:param>
</portlet:renderURL>

<aui:form action="<%= actionURL%>" style="margin-top: 2rem;padding: 0px 200px 0px 200px;">
	<aui:input type="text" id="expiry" name="expiry"/>
	<aui:button-row>
		<aui:button type="submit" value="send"/>
	</aui:button-row>
</aui:form>
<br>
<a style="margin-left: 200px;" href="<%=viewURL%>">Link to display page</a>

