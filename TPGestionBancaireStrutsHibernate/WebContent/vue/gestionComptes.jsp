<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="style1.css">
<title><s:text name="gestionComptes" /></title>
</head>
<body>
	<s:div cssClass="container">
		<h2>
			<s:text name="addCompte" />
		</h2>
		<s:form action="addCompte">
			<s:textfield name="cin" label="CIN" readonly="true" />
			<s:textfield name="name" label="%{getText('name')}" />
			<s:textfield name="sold" label="%{getText('sold')}" />
			<s:div cssClass="control-group">
				<s:div>
					<s:submit cssClass="btn btn-success" />
				</s:div>
			</s:div>
		</s:form>
		<h2>
			<s:text name="listCompte" />
		</h2>
		<table border="1" class="table1">
			<tr>
				<th>RIB</th>
				<th><s:text name="client" /></th>
				<th><s:text name="sold" /></th>
			</tr>
			<s:iterator value="listComptes">
				<tr>
					<td><s:property value="rib" /></td>
					<td><s:property value="nomClient" /></td>
					<td><s:property value="solde" /></td>
					<s:url namespace="/vue" action="delCompte" id="urlTag">
						<s:param name="rib">
							<s:property value="rib" />
						</s:param>
						<s:param name="cin">
							<s:property value="cin" />
						</s:param>
						<s:param name="name">
							<s:property value="nomClient" />
						</s:param>
					</s:url>
					<td><s:a href="%{urlTag}">
							<s:text name="delCompte" />
						</s:a></td>

					<s:url namespace="/vue" action="depotCompte" id="urlTag">
						<s:param name="rib">
							<s:property value="rib" />
						</s:param>
						<s:param name="solde">
							<s:property value="solde" />
						</s:param>
						<s:param name="name">
							<s:property value="nomClient" />
						</s:param>
						<s:param name="cin">
							<s:property value="cin" />
						</s:param>
					</s:url>
					<td><s:a href="%{urlTag}">
							<s:text name="depot" />
						</s:a></td>

					<s:url namespace="/vue" action="retraitCompte" id="urlTag">
						<s:param name="rib">
							<s:property value="rib" />
						</s:param>
						<s:param name="solde">
							<s:property value="solde" />
						</s:param>
						<s:param name="name">
							<s:property value="nomClient" />
						</s:param>
						<s:param name="cin">
							<s:property value="cin" />
						</s:param>
					</s:url>
					<td><s:a href="%{urlTag}">
							<s:text name="retrait" />
						</s:a></td>
				</tr>
			</s:iterator>
		</table>
		<BR>
		<s:url namespace="/vue" action="listClients" id="urlTag"></s:url>
		<s:a href="%{urlTag}">
			<s:text name="listClients" />
		</s:a>
	</s:div>
</body>
</html>