<%@ tag body-content="empty"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ attribute type="java.lang.String" name="name" required="false"%>

<%@ attribute type="java.lang.Boolean" name="isForm" required="false"%>

<%@ attribute type="za.co.sanlam.model.Query" name="query" required="false"%>
<%@ attribute type="za.co.sanlam.model.Beneficiary" name="beneficiary" required="false"%>
<%@ attribute type="za.co.sanlam.model.Claim" name="statement" required="false"%>
<%@ attribute type="za.co.sanlam.model.Client" name="client" required="false"%>
<%@ attribute type="za.co.sanlam.model.Hospital" name="hospital" required="false"%>
<%@ attribute type="za.co.sanlam.model.Scheme" name="policy" required="false"%>
<%@ attribute type="za.co.sanlam.model.Tip" name="tip" required="false"%>
<%@ attribute type="za.co.sanlam.model.Town" name="town" required="false"%>
<%@ attribute type="za.co.sanlam.model.Activity" name="activity" required="false"%>
	
<%@ attribute type="za.co.sanlam.model.User" name="user"
	required="false"%>

<div id="breadcrumbs" style="margin: 5px; width: 100%;">

	<a href="${baseUrl }/">Sancare</a> <span class="arrow-right"></span>

	<c:if test="${name eq 'query' }">
		<a href="${baseUrl }/query/view">Query</a>
		<span class="arrow-right"></span>
	</c:if>

	<c:if test="${name eq 'policy' }">
		<a href="${baseUrl }/policy/view">Policy</a>
		<span class="arrow-right"></span>
	</c:if>

	<c:if test="${name eq 'statement' }">
		<a href="${baseUrl }/statement/view">Statement</a>
		<span class="arrow-right"></span>
	</c:if>

	<c:if test="${name eq 'town' || name eq 'hospital' }">
		<a href="${baseUrl }/town/view">Town</a>
		<span class="arrow-right"></span>

		<c:if test="${name eq 'hospital' }">
			<a href="${baseUrl }/hospital/view/${town.id}">Hospital</a>
			<span class="arrow-right"></span>
		</c:if>
	</c:if>

	<c:if test="${name eq 'tip' }">
		<a href="${baseUrl }/tip/view">Tip</a>
		<span class="arrow-right"></span>
	</c:if>
	
	<c:if test="${name eq 'client' || name eq 'beneficiary'}">
		<a href="${baseUrl }/client/view">Client</a>
		<span class="arrow-right"></span>
		<c:if test="${name eq 'beneficiary' }">
			<a href="${baseUrl }/beneficiary/view/${client.id}">Beneficiary</a>
			<span class="arrow-right"></span>
		</c:if>
	</c:if>
	
	<c:if test="${name eq 'user' }">
		<a href="${baseUrl }/user/view">User</a>
		<span class="arrow-right"></span>
	</c:if>

	<%-- <c:if	test="${name eq 'complaint' }">

		<a href="${baseUrl }/query/view">Complaint</a>
		<span class="arrow-right"></span>
	</c:if> --%>

	<%-- <c:if	test="${name eq 'update' }">

		<a href="${baseUrl }/update/view">Update</a>
		<span class="arrow-right"></span>
		
		<c:if test="${name eq 'affected' }">

			<a href="${baseUrl }/affected/view">Affected</a>
			<span class="arrow-right"></span>
		</c:if>
		
	</c:if> --%>

	<c:if test="${name eq 'region' || name eq 'district' }">

		<a href="${baseUrl }/region/view">Region</a>
		<span class="arrow-right"></span>

		<c:if test="${name eq 'district' }">

			<a href="${baseUrl }/district/view">District</a>
			<span class="arrow-right"></span>
		</c:if>
	</c:if>

	<c:if test="${isForm }">
		<b>Form</b>
	</c:if>

</div>