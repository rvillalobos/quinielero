<%-- 
    Document   : changePassword
    Created on : 13-nov-2014, 0:20:59
    Author     : sebastiannoriegaramos
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src='function.js'></script>
        <link href='css/bootstrap.min.css' rel='stylesheet'>
        <link href='css/bootstrap-responsive.min.css' rel='stylesheet'>
    </head>
    <body>
        <%  
            Connection mysql = null;
            Statement st = null;
            Statement st2 = null;
            ResultSet rs = null;
            ResultSet rs2 = null;
            Statement update = null;
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://www.db4free.net:3306/quinielero";
            mysql = DriverManager.getConnection(url,"quinielero2014","quinielero");
            st = mysql.createStatement();
            st2 = mysql.createStatement();
            String user = request.getParameter("user");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            //Validar Usuario
            String validUser = "SELECT ID FROM login WHERE username ='"+user+"'";
            String validPass= "SELECT password FROM login WHERE username = '"+user+"'";
            rs = st.executeQuery(validUser);
            rs2 = st2.executeQuery(validPass);

            Integer id = 0;
            String  pass="";
            while(rs.next()){
                id = rs.getInt("ID");
            }
             while(rs2.next()){
                pass = rs2.getString("password");
            }

            //out.println("<h1>uno: </h1>"+ pass + "dos: " + id);
            
            if(oldPassword.equals(pass))
            {   //Si ingreso bien el viejo password
            if(id != 0){
               // out.println(id);
                update = mysql.createStatement();
                String sql = "UPDATE login SET password ='"+newPassword+"' where ID ='"+id+"'";
                update.executeUpdate(sql);
                if(update != null){
                    out.println("<div class='alert alert-warning' role='alert'>Se cambio el pass correctamente</div>");
                }
            }else{
                out.println("<div>Change my password</div>"
                +"<div>"
                +"Username<input type='text' id='user'>"
                +"</div>"
                +"<div>"
                +"Old Password<input type='text' id='oldPassword'>"
                +"</div>"
                +"<div>"
                +"New Password<input type='password' id='newPass'>"
                +"</div>"
                +"<div>"
                +"Confirm Password<input type='password' id='ConfirmPass'>"
                +"</div>"
                +"<input type='button' value='Change Password' onClick='changeNewPassword()'>"
                +"<div id='status'>Invalid User</div>");
            }
        }else{
            out.println("<div class='alert alert-warning' role='alert'>Contraseña anterior erronea</div>");
            }

        %>
    </body>
</html>
