<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        fieldset{
            width: 600px;
            margin:0 auto;
        }
    </style>
</head>
<body>
<form:form method="post" commandName="user" action="loginServlet">

    <fieldset >
        <table>
            <tr>
                <td><form:label path="email">Email :</form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssStyle="color: red"/></td>
            </tr>

            <tr>
                <td><form:label path="password">Password :</form:label></td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password" cssStyle="color: red"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                    <td><a href="/registration">Register</a></td>
                </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>