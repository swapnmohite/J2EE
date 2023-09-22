<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title></title>
    <style type="text/css">
   		 body{
				margin:0;
				padding:0;
				box-sizing: border-box;
			}
        
        @media screen and (max-width: 768px) {
            
            li {
                float: none;
                display: block;
                text-align: center;
            }
            ul {
                text-align: center;
                background-color: #333;
                padding: 0;
            }
            li a {
                display: inline-block;
                margin: 5px;
                padding: 10px 15px;
                text-decoration: none;
                color: white;
                background-color: #9999;
                border-radius: 5px;
            }
            li a:hover {
                background-color: ;
            }
        }

        /* Styles for larger screens */
        @media screen and (min-width: 769px) {
            fieldset {
                margin: 15px 520px;
                text-align: center;
            }
            ul {
                list-style-type: none;
                background-color: black;
                overflow: hidden;
                background-color: #333;
                margin: 0;
                padding: 0;
            }
            li {
                float: right;
            }
            li a {
                display: block;
                margin: 0px;
                padding: 15px;
                color: white;
                text-decoration: none;
            }
            li a:hover {
                background-color: #111;
            }
        }
    </style>
</head>
<body>
    <ul>
        <li><a href="./logout">Logout</a></li>
        <li><a href="./search">Search Car</a></li>
        <li><a href="./add">Add Car</a></li>
        <li><a href="./update">Update Car</a></li>
        <li><a href="./remove">Remove Car</a></li>
        <li><a href="./home">Home</a></li>
    </ul>
</body>
</html>
