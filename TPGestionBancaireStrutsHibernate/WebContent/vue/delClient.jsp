<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<title><s:text name="delClient" /></title>
</head>
<body>
	<s:div cssClass="container">
		<h2>
			<s:text name="idDelClient" />
		</h2>
		<s:form action="delClient">
			<s:textfield name="cin" label="CIN" />
			<s:div cssClass="form-group">
				<s:div cssClass="control-group">
					<s:div>
						<s:submit cssClass="btn btn-success" />
					</s:div>
				</s:div>
			</s:div>
		</s:form>
	</s:div>
</body>
</html>