<%--
  Created by IntelliJ IDEA.
  User: corwin
  Date: 6/28/13
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
<g:each var="hall" in="${halls}">
    <p>${hall}</p>
</g:each>
<g:form action="add">
    <g:textField name="name"/>
    <g:textField name="placesCount"/>
    <g:submitButton name="add" value="add"/>
</g:form>

</body>
</html>