<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="menu" /></title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<h1>
			<s:text name="menu" />
		</h1>

		<s:url namespace="/vue" action="hrefAddCompte" id="urlTag"></s:url>
		<s:a href="%{urlTag}">
			<s:text name="addCompte" />
		</s:a>
		<BR>
		<s:url namespace="/vue" action="hrefDelCompte" id="urlTag"></s:url>
		<s:a href="%{urlTag}">
			<s:text name="delCompte" />
		</s:a>
		<BR>
		<s:url namespace="/vue" action="hrefUpdateCompte" id="urlTag"></s:url>
		<s:a href="%{urlTag}">
			<s:text name="updateCompte" />
		</s:a>
		<BR>
		<s:url namespace="/vue" action="ListCompte" id="urlTag" />
		<s:a href="%{urlTag}">
			<s:text name="listCompte" />
		</s:a>
	</s:div>
</body>
</html>