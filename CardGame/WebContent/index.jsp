<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
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
			</div>
			<div id="text">
				<h2>Willkommen, Willkommen!</h2>
				<p>Gebe hier deine Account-Daten ein, 
				<br>um das Spiel zu beginnen!</p>
				<form method="post" action="Login">
					<br><input type="text" id="textfeld" placeholder="Username" name="username"></input>
					<br><input type="password" id="textfeld" placeholder="Passwort" name="password"></input>
					<br><button id="button" name="login">Login</button>
				</form>
				<form method="post" action="Register">
					<button id="button" name="register">Registrieren</button>
				</form>
			</div>
		</div>
	</body>
</html>