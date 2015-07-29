<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="javascript">
	<%String contextPath = request.getContextPath();%>
</script>
<%
    String redirectURL = contextPath+"/home.action";
	System.out.println ("url :"+redirectURL);
    response.sendRedirect(redirectURL);
%>
 
 
 