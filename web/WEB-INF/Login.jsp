<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <main>
            <h1>Login</h1>
            <form method="POST" action="login">
                <table>
                    <tr>
                        <td><label>Username:</label></td>
                        <td><input type="text" name="username" value=""/></td>
                    </tr>
                    <tr>
                        <td><label>Password:</label></td>
                        <td><input type="text" name="password" value=""/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="loginButton" value="Login"/></td>
                    </tr>
                </table>
            </form>
            <p>${errorMsg}</p>
        </main>
    </body>
</html>
