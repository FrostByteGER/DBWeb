<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" import="de.hsb.frostbyteger.core.User"%>
<html>
	<head>
		<title>The CardGame</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" media="screen">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<div id="main">
			<div id="logo">
				<h1>THE CARDGAME</h1>
				<br>
				<% User currentUser = (User)(session.getAttribute("currentSessionUser"));%>Willkommen zurück, <%= currentUser.getName()%>
			</div>
			<div id="text">
				<br><button id="buttonIngame" name="startGame">Spiel starten</button>
				<br><button id="buttonIngame" name="buildDeck">Deck bauen</button>
				<br><button id="buttonIngame" name="gotoShop">Shop</button>
				<form method="post" action="Logout">
					<br><button id="buttonIngame" name="logout">Logout</button>
				</form>
			</div>
		</div>
	</body>
</html>