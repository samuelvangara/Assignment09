<%-- 
    Document   : Registration
    Created on : Feb 17, 2017, 6:59:03 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foxy Corp</title>
    </head>
    <body>
        <h1> Welcome to FoxyCorp!</h1>
        <form action="RegistrationServlet" method="post">
         User ID <input type="text" title="Please enter User ID" placeholder="Please enter User ID" name="UserID" />
         Email ID <input type="email" title="Please enter the Email ID" placeholder="Please enter the Email ID" name="EmailID" />
         Phone Number <input type="tel" title="Please enter the Phone Number" placeholder="Please enter the Phone Number" name="PhoneNumber" />
        <button type="submit" class="btn">Register</button>      
        </form>
    </body>
</html>
