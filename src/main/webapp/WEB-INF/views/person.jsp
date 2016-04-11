<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">

<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Firstname</th>
        <th>Lastname</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${person.getId()}</td>
        <td>${person.getName()}</td>
        <td>${person.getSurname()}</td>
    </tr>
    </tbody>
</table>
</body>

</html>
