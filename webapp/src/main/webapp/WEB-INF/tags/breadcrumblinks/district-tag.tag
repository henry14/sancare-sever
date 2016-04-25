<%@ tag body-content="empty"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ attribute type="java.lang.String" name="name" required="false"%>
<%@ attribute type="java.lang.String" name="parentId" required="false"%>
<%@ attribute type="java.lang.Boolean" name="isForm" required="false"%>

<%@ attribute type="com.smsmedia.co.ug.model.Complaint" name="complaint" required="false"%>
<%@ attribute type="com.smsmedia.co.ug.model.Update" name="update" required="false"%>
<%@ attribute type="com.smsmedia.co.ug.model.Region" name="region" required="false"%>
<%@ attribute type="com.smsmedia.co.ug.model.District" name="district" required="false"%>

<div id="breadcrumbs" style="margin: 5px; width: 100%;">

	<a href="${baseUrl }/">Umeme</a>
	<span class="arrow-right"></span>

	<c:if	test="${name eq 'complaint' }">

		<a href="${baseUrl }/complaint/view">Complaint</a>
		<span class="arrow-right"></span>
	</c:if>
	
	<c:if	test="${name eq 'update' }">

		<a href="${baseUrl }/update/view">Update</a>
		<span class="arrow-right"></span>
	</c:if>
	
	<c:if	test="${name eq 'region' || name eq 'district' }">

		<a href="${baseUrl }/region/view">Region</a>
		<span class="arrow-right"></span>
		
		<c:if test="${name eq 'district' }">

			<a href="${baseUrl }/district/view/${parentId}">District</a>
			<span class="arrow-right"></span>
		</c:if>
	</c:if>

	<c:if test="${isForm }">
		<b>Form</b>
	</c:if>

</div>