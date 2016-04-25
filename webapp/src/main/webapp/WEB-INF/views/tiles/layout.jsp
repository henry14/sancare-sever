<%@page import="za.co.sanlam.model.User"%>
<%@page import="za.co.sanlam.security.util.SancareSecurityUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<c:set var="baseUrl" scope="application"
	value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/custom-theme/jquery-ui-1.8.15.custom.css" />

<link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/common.css" />
<link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/sancare.css" />
<%-- <link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/mpanga-search.css" /> --%>
<link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/sancare-images.css" />

<link rel="icon" type="image/png" href="${baseUrl }/static/images/login-img.jpg" />

<script type="text/javascript" src="${baseUrl }/static/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${baseUrl }/static/js/jquery-ui-1.8.15.custom.min.js"></script>
<script type="text/javascript" src="${baseUrl }/static/js/jquery.getUrlParam.js"></script>

<script type="text/javascript" src="${baseUrl }/static/js/sancare.js"></script>
<%-- <script type="text/javascript" src="${baseUrl }/static/js/mpanga-admin.js"></script> --%>
<%-- <script type="text/javascript" src="${baseUrl }/static/js/general-json.js"></script> --%>
<%-- <script type="text/javascript" src="${baseUrl }/static/js/form-magic.js"></script> --%>

<tiles:insertAttribute name="scripts" ignore="true" />
</head>
<body>

	<p id="longResponseText" style="display: none;">${longResponseText }</p>

	<%
		User user = null;
		try {
			user = SancareSecurityUtil.getLoggedInUser();
			if (user != null) {
				application.setAttribute("loggedInUser", user);
			}
		} catch (Exception ex) {
		}
	%>
	<div class="content-side-bar">
		<div class="statusbar">
			<div class="system-logo"></div>
			<div class="sbcredentials">
				<ul>
					<li>
						<span style="color: #000; font-weight: bold; font-size: 100%;">Welcome: ${loggedInUser.username } </span>
					</li>
					<li>
						<a href="${baseUrl }/ServiceLogout" title="Logout">[ Logout ]</a>
				</ul>
				<div style="clear: both;"></div>
			</div>
			<div class="sbmessagecontainer">
				<div id="errorMsg"
					<c:choose>
						<c:when test="${not empty errorMessage}">
							class="<c:out value="ui-state-error ui-corner-all"></c:out>"	
						</c:when>
						<c:otherwise>
							class="<c:out value="ui-state-error ui-corner-all hide"></c:out>"
						</c:otherwise>
					</c:choose>>
					<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
					<strong>Alert:</strong>
					<span id="eMsg">
						<c:if test="${not empty errorMessage }">
							<c:out value="${errorMessage }"></c:out>
						</c:if>
					</span>
				</div>
				<div id="systemMsg"
					<c:choose>
						<c:when test="${not empty systemMessage}">
							class="<c:out value="ui-state-highlight ui-corner-all"></c:out>"	
						</c:when>
						<c:otherwise>
							class="<c:out value="ui-state-highlight ui-corner-all hide"></c:out>"
						</c:otherwise>
					</c:choose>>
					<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
					<strong>Hey!</strong>
					<span id="sMsg">
						<c:if test="${not empty systemMessage }">
							<c:out value="${systemMessage }"></c:out>
						</c:if>
					</span>
				</div>
			</div>
		</div>

		<div id="loader">
			<span>Loading please wait</span>
		</div>

		<c:if test="${empty hideHomeSettingsMenu or not hideHomeSettingsMenu}">
			<div class="menu-header ">
				<div class="menu-buttons ">
					<span class="home-icon"></span>
					<a href="${baseUrl }/" title="Return to front page">Home</a>
				</div>

				<div class="menu-buttons">
					<span class="setting-icon"></span>
					<a href="${baseUrl }/settings" title="View System settings">Settings</a>
				</div>
			</div>
		</c:if>

		<div id="main">

			<div id="content" style="width: 99%;">
				<%-- <h4 id="content-header">
					<tiles:insertAttribute name="pageTitle" defaultValueType="string" defaultValue="Home" />
				</h4> --%>
				<div style="clear: both">
					<tiles:insertAttribute name="body" />
				</div>
			</div>

		</div>
	</div>
</body>
</html>