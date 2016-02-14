<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Open Csv</title>
		
		<script type="text/javascript">
			function submitform(fileName) {
				document.displayCsvForm.selectedCsv.value = fileName;
				document.displayCsvForm.submit();
			}
		</script>
	</head>

	<body>
		<p>CSV Files:</p>
		
		<form name="displayCsvForm" action="/csv" method="post">
			<input type="hidden" name="selectedCsv" value="-" />
			<table>
				<c:forEach items="${csvFiles}" var="file">
					<tr>
						<td>
							<c:out value="${file.name}"/>
						</td>
						<td>
							<button type="button" onclick="submitform('${file.name}')">Display CSV file</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>