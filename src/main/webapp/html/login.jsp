<%--
  Created by IntelliJ IDEA.
  User: sjj
  Date: 2015/10/24 0024
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>CODE X</title>

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <!-- CSS -->
  <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
  <link rel="stylesheet" href="../css/login/reset.css">
  <link rel="stylesheet" href="../css/login/supersized.css">
  <link rel="stylesheet" href="../css/login/style.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="page-container">
  <h1>CODE X</h1>
  <form action="" method="post">
    <input type="text" name="username" class="username" placeholder="Username">
    <input type="password" name="password" class="password" placeholder="Password">
    <button type="submit">Sign In</button>
    <div class="error"><span>+</span></div>
  </form>
  <div class="connect">
    <div class="btn btn-info text-info">Create a account</div>

  </div>
</div>



<!-- Javascript -->
<script src="../js/jquery.min.js"></script>
<script src="../js/login/supersized.3.2.7.min.js"></script>
<script src="../js/login/supersized-init.js"></script>
<%--<script src="../js/scripts.js"></script>--%>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
