<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url var="homeUrl" value="/home.do" />
<c:url var="accountUrl" value="/account.do" />
<c:url var="balanceUrl" value="/balance.do" />
<c:url var="directionsUrl" value="/directions.do" />
<c:url var="aboutUrl" value="/about.do" />
<!DOCTYPE html>
<html>
	<head>
		<title>${pageName} | Spring MVC Cache-Control Demo</title>
		<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css" rel="stylesheet" />
		<style>
			aside {
				margin-top: 20px;
			}
		</style>
	</head>
	<body id="doc">
		<div class="container-fluid">
			<div class="row-fluid">		
				<div class="span9">
					<h1>${pageName}</h1>
					<p>This is the "${pageName}" page.</p>	
				</div>
				<aside class="span3">
					<div class="well well-small">
						<ul class="nav nav-list">
							<li class="nav-header">Pages</li>
							<li><a href="${homeUrl}">Home</a>
							<li><a href="${accountUrl}">Account</a>
							<li><a href="${balanceUrl}">Balances</a>
							<li><a href="${aboutUrl}">About</a>
							<li><a href="${directionsUrl}">Directions</a>
						</ul>
					</div>
				</aside>
			</div>
		</div>
	</body>
</html>
