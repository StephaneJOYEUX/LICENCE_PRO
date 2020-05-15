<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Yes we are : NOUS SOMMES BIEN CONNECTES !
	<s:text name="message"></s:text>
	<br> Voici les comptes du client
	<s:iterator value="comptes">
		<br>
		<s:text name="numCompte"></s:text>
		<s:text name="solde"></s:text>
		<br>
	</s:iterator>
</body>
</html>