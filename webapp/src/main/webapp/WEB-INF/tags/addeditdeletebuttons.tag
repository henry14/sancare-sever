
<%@ tag body-content="empty"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute type="java.lang.String" name="name" required="true"%>
<%@ attribute type="java.lang.String" name="url" required="true"%>
<%@ attribute type="java.lang.String" name="parentId" required="false"%>

<%@ attribute type="java.lang.String" name="child1" required="false"%>
<%@ attribute type="java.lang.String" name="child1Url" required="false"%>

<c:choose>

	<c:when test="${not empty parentId }">

		<c:if test="${add2 }">
			<a id="lnkAdd${name }" href="${baseUrl}/${url}/add2/${parentId}" class="uiButton spacedRight blackText">Add 2</a>
		</c:if>

		<a id="lnkAdd${name }" href="${baseUrl}/${url}/add/${parentId}" class="uiButton">Add</a>
		<a id="lnkUpdate${name }" href="${baseUrl}/${url}/edit/" class="uiButton">Edit</a>
		<a id="lnkDelete${name }" href="${baseUrl}/${url}/delete/${parentId}/" class="uiButton redText">Delete</a>
	</c:when>
	<c:otherwise>
		
		<c:if test="${add2 }">
			<a id="lnkAdd${name }" href="${baseUrl}/${url}/add2" class="uiButton spacedRight blackText">Add 2</a>
		</c:if>

		<a id="lnkAdd${name }" href="${baseUrl}/${url}/add" class="uiButton">Add</a>
		<a id="lnkUpdate${name }" href="${baseUrl}/${url}/edit/" class="uiButton">Edit</a>
		<a id="lnkDelete${name }" href="${baseUrl}/${url}/delete/" class="uiButton redText">Delete</a>
	</c:otherwise>
</c:choose>
<c:if test="${not empty child1 && not empty child1Url }">
	<a id="lnkChild1Of${name }" href="${baseUrl}/${child1Url}/view/" class="uiButton spaced">${child1 }</a>

	<%-- <c:if test="${not empty printViewAll1 and printViewAll1 }">
		<a id="lnkViewAllChild1Of${name }" href="${baseUrl}/${child1Url}/view" class="uiButton blackText">View-All ${child1 }</a>
	</c:if> --%>
</c:if>

