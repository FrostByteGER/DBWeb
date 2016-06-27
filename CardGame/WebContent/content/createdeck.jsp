<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" import="de.hsb.frostbyteger.core.Card" import ="java.util.*" %>
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
				<h2>Deck bauen</h2>
				<div id="cards">
					<table>
						<tr>
							<th>Name</th>
							<th>Atk</th>
							<th>Def</th>
							<th>Mana</th>
							<th>Tribe</th>
							<th>Cost</th>
						</tr>
						<% 
							ArrayList<Card> cards = (ArrayList<Card>)request.getAttribute("cards");
							for(int i = 0; i < cards.size(); i++){
								Card c = cards.get(i);
								System.out.println(c.getName());
						%>
								<tr>
									<td><%= c.getName() %></td>
									<td><%= c.getAtk() %></td>
									<td><%= c.getDef() %></td>
									<td><%= c.getMana() %></td>
									<td><%= c.getTribe() %></td>
									<td><%= c.getCost() %></td>
								</tr>
						<% } %>
					</table>
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