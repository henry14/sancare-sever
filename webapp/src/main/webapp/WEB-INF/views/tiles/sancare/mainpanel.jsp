<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<div>

    <div class="controlpanel-rows">
		<div class="controlpanel-columns">
			<a title="User Transactions" href="${baseUrl }/user/view">
				<span class="panellink complaint-icon"></span>
				<span>Human Resource</span>
			</a>
		</div>
		
		<div class="controlpanel-columns">
			<a title="Town Transactions" href="${baseUrl }/town/view">
				<span class="panellink complaint-icon"></span>
				<span>Towns</span>
			</a>
		</div>
		
		<div class="controlpanel-columns">
			<a href="${baseUrl }/client/view">
				<span class="panellink query-icon"></span>
				<span>Clients</span>
			</a>
		</div>
		
		<div class="controlpanel-columns">
			<a href="${baseUrl }/statement/view">
				<span class="panellink statement-icon"></span>
				<span>Statements</span>
			</a>
		</div>

		<div class="controlpanel-columns">
			<a href="${baseUrl }/policy/view">
				<span class="panellink policy-icon"></span>
				<span>Policies</span>
			</a>
		</div>
		
		<div class="controlpanel-columns">
			<a href="${baseUrl }/tip/view">
				<span class="panellink tip-icon"></span>
				<span>Health Tips</span>
			</a>
		</div>
		
		<div class="controlpanel-columns">
			<a href="${baseUrl }/query/view">
				<span class="panellink query-icon"></span>
				<span>Queries</span>
			</a>
		</div>
		
		
		<%-- <div class="controlpanel-columns">
			<a href="${baseUrl }/district/view">
				<span class="panellink "></span>
				<span>Districts</span>
			</a>
		</div> --%>
	</div>
</div>
