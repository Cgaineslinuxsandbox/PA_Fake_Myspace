<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>User Info</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="userInfo">
	<h1>${user.name }</h1>
	<img alt="User image" src="${user.image_url }">
	<form:form method="POST" enctype="multipart/form-data" action="/IDK where this goes" modelAttribute="user" >
	<input type="file" name="pic" accept=" image/png, image/jpeg" class="form-control-file" id="inlineFormInput">
	<button>Upload a Pic</button>
	</form:form>
	
	
	<h4>${user.gender }</h4>
	<h4>${user.location }</h4>
	<h4>${user.age }</h4>
</div>


<div class="userBlurb">
	<h3>${user.name }'s blurbs</h3>
	
	<h4>About me</h4>		
	<h5>${user.blurb.about }</h5>
	
	<h4>Who I'd like to meet</h4>
	<h5>${user.blurb.meet }</h5>
</div>


<div class="userFriends">
	<h4>${user.name }'s Friend Space</h4>
	<h5>${user.name } has ${user.friend.size() } friends</h5>
	
	<c:forEach items="${top8 }" var="topFrnd">
	<h5>${topFrnd.oneUser.name }</h5>
	<img alt="top8 image" src="${topFrnd.oneUser.image_url }">
	</c:forEach>
	
	<a href="/">View All ${user.name } Friends</a>
</div>


<div class="comment">
	<h3>Comments</h3>
	<form:form method="POST" action="/main/${user.id}/postComment" modelAttribute="commentb">
		<form:label path="content">Comment: </form:label>
		<form:errors path="content"/>
		<form:textarea path="content" placeholder="Enter your comment"/>
		
		<%-- <form:input type="hidden" value="${creator.id}" path="creator"/> --%>
		<button>Submit</button>
	</form:form>
	
	
	
</div>


</body>
</html>
