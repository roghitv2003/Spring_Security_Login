<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logged Out - LaunchPad</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .logout-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        .icon {
            font-size: 50px;
            margin-bottom: 15px;
        }

        h2 {
            color: #333333;
            margin-bottom: 10px;
        }

        p {
            color: #777777;
            font-size: 14px;
            margin-bottom: 25px;
        }

        .btn-login-again {
            display: inline-block;
            padding: 10px 28px;
            background-color: #4a90e2;
            color: white;
            border-radius: 6px;
            text-decoration: none;
            font-size: 14px;
        }

        .btn-login-again:hover {
            background-color: #357abd;
        }
    </style>
</head>
<body>

<div class="logout-container">
    <div class="icon">👋</div>
    <h2>You have been logged out</h2>
    <p>Thank you for using LaunchPad. See you again!</p>
    <a href="/login" class="btn-login-again">Login Again</a>
</div>

</body>
</html>