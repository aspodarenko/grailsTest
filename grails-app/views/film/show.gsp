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
  <title></title>
</head>
<body>
   <g:each var="film" in="${films}">
       <p>${film}</p>
   </g:each>
   <g:form action="add">
       <p>Name</p>
       <g:textField name="name"/>
       <p>Description</p>
       <g:textField name="description"/>
       <g:submitButton name="add" value="add"/>
   </g:form>
<g:formRemote name="addSession" update="sessionList"
              url="[controller: 'session', action:'addSession']">
    Book Id: <input name="id" type="text" />
</g:formRemote>
<div id="sessionList"></div>

</body>
</html>