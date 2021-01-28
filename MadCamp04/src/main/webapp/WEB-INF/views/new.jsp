<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Register</title>

<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign Up</h3>
					</div>
					<div class="panel-body">
						<form role="form" method='post' action='/new'>
							<fieldset>
								<div class="form-group">
      								<input class="form-control" placeholder="userid"
										name="userid" type="text" autofocus>
      							</div>
    							
								<div class="form-group">
									<input class="form-control" placeholder="username"
										name="userName" type="text" autofocus>
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="password"
										name="userpw" type="text" autofocus>
								</div>
    						
        						<button type="submit" class="btn btn-lg btn-success btn-block">Sign Up</button>
        						<a href="/customLogin" class="btn btn-lg btn-register btn-block">Cancel</a>
        					</fieldset>
        					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
		
  <!-- <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      Username
      <label class="control-label"  for="userid">Userid</label>
      <div class="controls">
        <input type="text" id="username" name="userid" placeholder="" class="input-xlarge">
        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
      </div>
    </div>
 
    <div class="control-group">
      Password
      <label class="control-label" for="userid">Username</label>
      <div class="controls">
        <input type="password" id="password" name="userName" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
 
    <div class="control-group">
      Password
      <label class="control-label"  for="password_confirm">Password</label>
      <div class="controls">
        <input type="password" id="password_confirm" name="userpw" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
    </div>
 
    <div class="control-group">
      Button
      <div class="controls">
        <button type="submit" class="btn btn-success">Register</button>
      </div>
    </div>
  </fieldset> -->
</form>
</body>
</html>