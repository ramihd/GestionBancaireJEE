<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="formulaire.modification" /></title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>
	<s:div cssClass="container">
		<h2>
			<s:text name="retrait" />
		</h2>
		<h3>
			<s:text name="soldeCourant" />
			<s:property value="solde" />
		</h3>
		<s:form action="retraitMontant">
			<s:textfield name="montant" label="%{getText('retraitMontant')}" />
			<s:hidden name="solde"/>
			<s:hidden name="rib"/>
			<s:hidden name="name" />
			<s:hidden name="cin"/>
			<s:div cssClass="control-group">
				<s:div>
					<s:submit cssClass="btn btn-success" />
				</s:div>
			</s:div>
		</s:form>
	</s:div>
</body>
</html>