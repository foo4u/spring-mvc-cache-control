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
		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.5.0/build/cssreset/cssreset-min.css" />
		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.5.0/build/cssfonts/cssfonts-min.css" />
		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.5.0/build/cssbase/cssbase-min.css" />
		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.5.0/build/cssgrids/grids-min.css" />
		
		<style type="text/css">
			#doc {
				font-family: Georgia;
    			margin: auto;
    			width: 960px;
    			padding-bottom: 50px;
			}
		</style>
		
	</head>
	<body id="doc">
		<div class="yui3-g">
			<div class="yui3-u-3-4">
				<h1>${pageName}</h1>
				<p>This is the "${pageName}" page.</p>	
			</div>
			<div class="yui3-u-1-4">
				<h2>Pages</h2>
				
				<ul>
					<li><a href="${homeUrl}">Home</a>
					<li><a href="${accountUrl}">Account</a>
					<li><a href="${balanceUrl}">Balances</a>
					<li><a href="${aboutUrl}">About</a>
					<li><a href="${directionsUrl}">Directions</a>
				</ul>
			</div>
		</div>
	</body>
</html>
