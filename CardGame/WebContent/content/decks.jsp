<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<html>
	<head>
		<title>The CardGame</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css media="screen">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<div id="main">
			<div id="logo">
				<h1>THE CARDGAME</h1>
			</div>
			<div id="text">
				<h2>Deck bauen</h2>
				<div id="cards">
					<!-- Background-Color stellt den Tribe dar -->
					<div id="card" style="background-color: rgba(21,71,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,46, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(46,21,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(71,46,21, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,46, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(46,21,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(71,46,21, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,46, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(46,21,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(71,46,21, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,71, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
					<div id="card" style="background-color: rgba(21,71,46, 1);">
						<img id="cardPic" />ATK: XXXX<br>DEF: XXXX
					</div>
				</div>
				<div id="lowerPart">
					<div id="decks">
						<div id="card" style="background-color: rgba(30,10,0, 1);">
							<img id="cardPic" />
							<input type="text" id="deckNameField" placeholder="Deck1"></input>
						</div>
						<div id="card" style="background-color: rgba(30,10,0, 1);">
							<img id="cardPic" />
							<input type="text" id="deckNameField" placeholder="Deck2"></input>
						</div>
						<div id="card" style="background-color: rgba(30,10,0, 1);">
							<img id="cardPic" />
							<input type="text" id="deckNameField" placeholder="Deck3"></input>
						</div>
						<div id="card" style="background-color: rgba(30,10,0, 1);">
							<img id="cardPic" />
							<input type="text" id="deckNameField" placeholder="Deck4"></input>
						</div>
						<div id="card" style="background-color: rgba(30,10,0, 1);">
							<img id="cardPic" />
							<input type="text" id="deckNameField" placeholder="Deck5"></input>
						</div>
					</div>
					<div id="deckButtons">
						<button id="dButton" style="margin-bottom: 30px" name="save">Speichern</button>
						<br><button id="dButton" name="delete">Löschen</button>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>