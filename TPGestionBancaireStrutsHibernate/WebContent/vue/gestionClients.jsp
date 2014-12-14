<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="gestionClients" /></title>
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<div>
			<h1>
				<s:text name="gestionClients" />
			</h1>
			<s:url namespace="/vue" action="hrefAddClient" id="urlTag"></s:url>
			<s:a href="%{urlTag}">
				<s:text name="addClient" />
			</s:a>
			<BR>
			<s:url namespace="/vue" action="hrefDelClient" id="urlTag"></s:url>
			<s:a href="%{urlTag}">
				<s:text name="delClient" />
			</s:a>
			<BR>
			<s:url namespace="/vue" action="hrefUpdateClient" id="urlTag"></s:url>
			<s:a href="%{urlTag}">
				<s:text name="updateClient" />
			</s:a>
			<BR>

			<s:url namespace="/vue" action="listClients" id="urlTag"></s:url>
			<s:a href="%{urlTag}">
				<s:text name="listClients" />
			</s:a>
		</div>
	</s:div>
</body>
</html>