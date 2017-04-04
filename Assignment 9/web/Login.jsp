<%-- 
    Document   : Login
    Created on : Feb 17, 2017, 8:13:07 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoxyCorp</title>
    </head>
    <body>
    
        <%
            String name ="";
            String email ="";
            String phone ="";
          name = request.getAttribute("Name").toString();
          email = request.getAttribute("Email").toString();
          phone = request.getAttribute("ph").toString();
          out.println(name); 
          out.println(email);
          out.println(phone);
   
            %>
            
            <button type="submit"  class="btn"> Yo</button>
    </body>
</html>
