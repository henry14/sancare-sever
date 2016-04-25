<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>


<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags" tagdir="/WEB-INF/tags/breadcramblinks"%>

<breadcrambTags:settings name="roles" isForm="true"/>

<style>
form#role input[type="text"] {
	width: 70%;
}

</style>
<div>
	<form:form action="${baseUrl }/role/save" commandName="role">
		<form:hidden path="id" />
		<div class="splitcontentleft">
			<div class="box tabular">
				<h3>Information</h3>
				<p>
					<label>
						Name
						<span class="required">*</span>
					</label>
					<form:input id="mtxtName" path="name" cssClass="uiTextbox long"
						readonly="${ (role.name eq 'ROLE_ADMINISTRATOR') ? true: false}" />
				</p>
				<p>
					<label>
						Description
						<span class="required">*</span>
					</label>
					<form:input id="mtxtDescription" path="description" cssClass="uiTextbox long" />
					<input id="btnSaveRole" type="submit" value="Save" class="uiButton" />
				</p>

			</div>
		</div>
		<div class="splitcontentright">
			<div class="box">
				<div style="border-bottom: 1px solid #BBB;">
					<h3 style="display: inline; border-bottom: none;">
						<input type="checkbox" name="selectAll" id="selectAllCheckBoxes" paragraph_Id="permissionList"/>
						All Permissions &emsp;&emsp; Search
						<input id="txtFilterCheckBoxes" idSubString="perm" type="text" placeHolder="search permission" class="uiTextbox long">
					</h3>
				</div>
				<p id="permissionList" class="multipleCheckboxes">
					<form:checkboxes items="${permissions }" path="permissions" itemValue="id" itemLabel="name" />
				</p>
			</div>
		</div>
		<div style="clear: both"></div>
		<div></div>
	</form:form>
</div>