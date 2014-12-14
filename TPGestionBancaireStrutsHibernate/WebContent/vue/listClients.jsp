<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="listClients" /></title>
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<h2>
			<s:text name="listClients" />
		</h2>
		<table border="1" class="table1">
			<tr>
				<th><s:text name="name" /></th>
				<th><s:text name="surname" /></th>
				<th>CIN</th>
				<th><s:text name="adresse" /></th>
				<th><s:text name="numTel" /></th>
			</tr>
			<s:iterator value="listClients">
				<tr>
					<td><s:property value="nom" /></td>
					<td><s:property value="prenom" /></td>
					<td><s:property value="cin" /></td>
					<td><s:property value="adresse" /></td>
					<td><s:property value="numTel" /></td>
					<s:url namespace="/vue" action="gestionComptes" id="urlTag">
						<s:param name="cin">
							<s:property value="cin" />
						</s:param>
						<s:param name="name">
							<s:property value="prenom" />
						</s:param>
					</s:url>
					<td><s:a href="%{urlTag}">
							<s:text name="gestionComptes" />
						</s:a></td>
				</tr>
			</s:iterator>
		</table>
		<BR>
		<s:url namespace="/vue" action="acceuilClient" id="urlTag"></s:url>
		<s:a href="%{urlTag}">
			<s:text name="acceuil" />
		</s:a>
	</s:div>
</body>
</html>