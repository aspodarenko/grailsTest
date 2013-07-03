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
    <g:javascript library='jquery' />
    <g:javascript src="jquery/jquery-1.7.1.min.js"/>
  <title></title>
</head>
<script>
    function _after(response) {
        alert('hello');
    }
</script>
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
<g:form name="addSession"  >
    Sessions for the last film
    <p>Session price: <g:textField name="price"/></p>
    <p>Session time: <g:textField name="time"/></p>
    <p><g:select name="hallId" from="${halls}" optionKey="id"/> </p>
    <g:textField name="filmId" value="${filmId}" hidden="true"/>
    <g:submitToRemote action="add" controller="session" name="addSession" value="add session" update="sessionList"/>
</g:form>
<div id="sessionList"></div>

</body>
</html>