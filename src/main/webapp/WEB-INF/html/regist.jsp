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
  <!-- Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <link rel="stylesheet" href="../../css/font-awesome.css">
  <link rel="stylesheet" href="../../css/codex/vendor/bootstrap-checkbox.css">


  <link href="../../css/codex/minimal.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="bg-1">


<!-- Wrap all page content here -->
<div id="wrap" ms-controller="regist">
  <!-- Make page fluid -->
  <div class="row">
    <!-- Page content -->
    <div id="content" class="col-md-12 full-page login">


      <div class="inside-block">
        <img src="../../img/codex/logo-big.png" alt class="logo">
        <h1><strong>Welcome</strong> CODE X</h1>
        <h5>Join Code X</h5>

        <form id="form-signin" class="form-signin">
          <section>
            <div class="input-group">
              <input type="text" class="form-control" name="username" ms-duplex="username" placeholder="Username">
              <div class="input-group-addon"><i class="fa fa-user"></i></div>
            </div>
            <div class="input-group">
              <input type="password" class="form-control" name="password" ms-duplex="password" placeholder="Password">
              <div class="input-group-addon"><i class="fa fa-key"></i></div>
            </div>
            <div class="input-group">
              <input type="password" class="form-control" name="passwordConf" ms-duplex="passwordConf" placeholder="Confirm Password">
              <div class="input-group-addon"><i class="fa fa-key"></i></div>
            </div>
            <div class="input-group">
              <input type="text" class="form-control" name="phone" ms-duplex="phone" placeholder="Phone">
              <div class="input-group-addon"><i class="fa fa-phone"></i></div>
            </div>
          </section>
          <%--<section class="controls">--%>
            <%--<div class="checkbox check-transparent">--%>
              <%--<input type="checkbox" value="1" id="remember" checked>--%>
              <%--<label for="remember">Remember me</label>--%>
            <%--</div>--%>
            <%--&lt;%&ndash;<a href="#">Forget password?</a>&ndash;%&gt;--%>
          <%--</section>--%>
          <section class="log-in">
            <a class="btn btn-greensea" ms-click="submit">Create an account</a>
            <span>or</span>
            <a class="btn btn-slategray" href="/login">Log In</a>
          </section>
        </form>
      </div>


    </div>
    <!-- /Page content -->
  </div>
</div>

<!-- Javascript -->
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/avalon.js"></script>
<script src="../../js/codex/regist.js"></script>
</body>
</html>
