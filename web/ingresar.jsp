<%-- 
    Document   : index
    Created on : 22-nov-2017, 18:29:31
    Author     : Fran y Angie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css"/>
<html>
    <body>
<div class="wrapper">
    <form action="login" method="POST" class="form-signin">       
      <h2 class="form-signin-heading">Iniciar Sesion</h2>
      <input type="text" class="form-control" name="usr_alias" placeholder="Usuario" required="" autofocus="" />
      <br>
      <input type="password" class="form-control" name="usr_password" placeholder="Password" required=""/>      
      <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
    </form>
  </div>
    </body>
</html>