<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<br>
<script src="<%= baseUrl %>/script.js"></script>

<input type="hidden" id="baseUrl" value="<%= baseUrl %>"/>