
<%@ tag body-content="empty"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute type="java.lang.String" name="name" required="true"%>
<%@ attribute type="java.lang.String" name="url" required="true"%>
<%@ attribute type="java.lang.String" name="parentId" required="false"%>

<c:choose>

	<c:when test="${not empty parentId }">

		<c:if test="${add2 }">
			<a id="lnkAdd${name }" href="${baseUrl}/${url}/add2/${parentId}"
				class="uiButton spacedRight blackText">Add 2</a>
		</c:if>
		<%-- 		<a id="lnkChange${name }" href="${baseUrl}/${url}/edit/" class="uiButton">Change Status</a> --%>
		<a id="lnkComplaint" href="${baseUrl}/${url}/edit/" class="uiButton">Give feedback</a>
	</c:when>
	<c:otherwise>
		<a id="lnkComplaint" href="${baseUrl}/${url}/edit/" class="uiButton">Give feedback</a>
	</c:otherwise>
</c:choose>


