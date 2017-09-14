<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<nav>
		<tiles:insertAttribute name="nav" />
	</nav>
	<section style="min-height: 70%;">
		<tiles:insertAttribute name="section" />
	</section>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>
