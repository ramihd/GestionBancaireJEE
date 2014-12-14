<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<table border="1">
			<tr>
				<td><s:url id="url" action="loginPage">
						<s:param name="request_locale">fr</s:param>
					</s:url> <s:a href="%{url}">
						<s:text name="fr" />
					</s:a></td>
				<td><s:url id="url" action="loginPage">
						<s:param name="request_locale">en</s:param>
					</s:url> <s:a href="%{url}">
						<s:text name="en" />
					</s:a></td>
			</tr>
		</table>
		<hr>
		<h4>
			<s:text name="data" />
		</h4>
		<s:form action="MenuAB" cssClass="form-horizental">
			<s:div cssClass="form-group">
				<s:textfield name="login" cssClass="form-control"
					label="%{getText('login')}" />
			</s:div>
			<s:div cssClass="form-group">
				<s:textfield name="password" cssClass="form-control"
					label="%{getText('password')}" />
			</s:div>
			<s:div cssClass="form-group">
				<s:div cssClass="control-group">
					<s:div>
						<s:submit cssClass="btn btn-success" />
					</s:div>
				</s:div>
			</s:div>
		</s:form>
		<hr>
	</s:div>
</body>
</html>