<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Analysis Tool</title>
	</head>
	<body>
		<p>Apps:</p>
			<form name="displayAppsForm" action="/main" method="get">
				<table>
					<tr>
						<th>Title</th>
						<th>Score</th>
						<th>Number of Downloads</th>
					</tr>
					<c:forEach items="${apps}" var="app">
						<tr>
							<td><c:out value="${app.title}"/></td>
							<td><c:out value="${app.score}"/></td>
							<td><c:out value="${app.numDownloads}"/></td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" name="main" value="Main" />
			</form>
	</body>
</html>