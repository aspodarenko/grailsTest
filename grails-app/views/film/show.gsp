<%--
  Created by IntelliJ IDEA.
  User: corwin
  Date: 6/28/13
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

</head>

<body>
   <g:each var="film" in="${films}">
       <p>${film}</p>
   </g:each>
   <g:form action="add">
       <p>Name <g:textField name="name"/>
       </p>
       <p>Description <g:textField name="description"/>
       </p>
       <g:submitButton name="add" value="add"/>
   </g:form>


</body>
</html>