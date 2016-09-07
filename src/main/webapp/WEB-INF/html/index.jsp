<%--
  Created by IntelliJ IDEA.
  User: sjj
  Date: 2015/10/24 0024
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.codex.model.User" %>
<%@ page import="com.codex.common.Constants" %>
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
<%
    User loginUser = (User) request.getAttribute(Constants.LOGIN_USER);
    if (loginUser == null) {
        loginUser = new User();
    }
%>

<body class="bg-1" ms-controller="index">
<!-- Wrap all page content here -->
<div id="wrap">
    <!-- Make page fluid -->
    <div class="row">
        <div class="navbar navbar-default navbar-fixed-top navbar-transparent-black mm-fixed-top" role="navigation"
             id="navbar">
            <!-- Branding -->
            <div class="navbar-header col-md-2">
                <a class="navbar-brand" href="#">
                    <strong>CODE</strong> X
                </a>
            </div>
            <!-- Branding end -->
            <!-- .nav-collapse -->
            <div class="navbar-collapse">
                <!-- Quick Actions -->
                <ul class="nav navbar-nav quick-actions">


                    <li class="dropdown divided user" id="current-user">
                        <div class="profile-photo">
                            <img src="../../img/codex/example-1.jpg" alt="">
                        </div>
                        <a class="dropdown-toggle options" data-toggle="dropdown" href="#">
                            <%=loginUser.getUserName() %> <i class="fa fa-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu arrow settings animated fadeInDown">

                            <li>

                                <h3>Backgrounds:</h3>
                                <ul id="color-schemes">
                                    <li><a href="#" class="bg-1" ms-click="setBG('bg-1')"></a></li>
                                    <li><a href="#" class="bg-2" ms-click="setBG('bg-2')"></a></li>
                                    <li><a href="#" class="bg-3" ms-click="setBG('bg-3')"></a></li>
                                    <li><a href="#" class="bg-4" ms-click="setBG('bg-4')"></a></li>
                                    <li><a href="#" class="bg-5" ms-click="setBG('bg-5')"></a></li>
                                    <li><a href="#" class="bg-6" ms-click="setBG('bg-6')"></a></li>
                                </ul>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a ms-click="logout"><i class="fa fa-power-off"></i> Logout</a>
                            </li>
                        </ul>
                    </li>

                </ul>
                <!-- /Quick Actions -->
            </div>
        </div>
        <!-- Page content -->
        <div id="content" class="col-md-12 row" style="overflow: hidden; outline: none;">
            <!-- page header -->
            <div class="pageheader">
                <h2><i class="fa fa-user" style="line-height: 46px;padding-left: 0;"></i> Profile <span>welcome to CODE X</span>
                </h2>

                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li>You are here</li>
                        <li><a href="#">CODE X</a></li>
                        <li><a href="#">Profile</a></li>
                    </ol>
                </div>


            </div>
            <!-- /page header -->
            <!-- content main container -->
            <div class="row">
                <!-- row -->
                <div class="row">
                    <!-- col 4 -->
                    <div class="col-md-6 col-md-offset-3">
                        <!-- tile -->
                        <section class="tile transparent">


                            <!-- tile header -->
                            <div class="tile-header nopadding">
                                <div class="controls">
                                    <a href="#" class="refresh"><i class="fa fa-refresh"></i></a>
                                    <a href="#" class="remove"><i class="fa fa-times"></i></a>
                                </div>
                            </div>
                            <!-- /tile header -->

                            <!-- tile widget -->
                            <div class="tile-widget color transparent-white cyan rounded-top-corners">

                                <div class="fa fa-user watermark"></div>

                                <div class="media social-feed">
                          <span class="pull-left">
                            <img src="../../img/codex/example-1.jpg" alt class="img-circle">
                          </span>

                                    <div class="media-body">
                                        <h4 class="media-heading"><strong><%=loginUser.getUserName() %>
                                        </strong>#<%=loginUser.getUserKey()%>
                                        </h4>
                                        <small><a href="#"><%=loginUser.getPhone()%>
                                        </a></small>
                                    </div>
                                </div>
                            </div>
                            <!-- /tile widget -->

                            <!-- tile body -->
                            <div class="tile-body color transparent-black rounded-bottom-corners">
                                <ul class="inline divided social-feed">
                                    <li>
                                        <h4>0</h4>
                                        Tweets
                                    </li>
                                    <li>
                                        <h4>0</h4>
                                        Following
                                    </li>
                                    <li>
                                        <h4>0</h4>
                                        Blogs
                                    </li>
                                </ul>
                            </div>
                            <!-- /tile body -->
                        </section>
                        <div class="alert alert-warning alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <strong>Warning!</strong> You have yet to activate your account!
                        </div>
                        <!-- /tile -->
                        <div class="row cards">
                            <div class="card-container col-lg-12 col-sm-12 col-sm-12">
                                <div class="card card-greensea hover">
                                    <div class="front">

                                        <div class="media">
                      <span class="pull-left">
                        <i class="fa fa-users media-object"></i>
                      </span>
                                            <div class="media-body">
                                                <small>Users</small>
                                                <h2 class="media-heading animate-number" data-value="1"
                                                    data-animation-duration="1500">1</h2>
                                            </div>
                                        </div>

                                        <div class="progress-list">
                                            <div class="details">
                                                <div class="panel-danger">Activate the account to use all functions
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="back">
                                        <a data-toggle="modal" data-target="#payModal">
                                            <i class="fa fa-dollar fa-4x"></i>
                                            <span>Active You Account</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /col 8 -->
            </div>
            <!-- /row -->
        </div>
        <!-- /content container -->
    </div>
</div>

<!-- payModal -->
<div class="modal fade" id="payModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body" style="padding: 0px; !important;">
                <div class="col-md-12">
                    <div class="tile transparent">
                        <div class="text-info well">please enter your username when you pay the bill</div>
                        <img src="../../img/codex/payment/alipay.jpg" class="col-md-6 col-md-offset-3"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Javascript -->
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/avalon.js"></script>
<script src="../../js/codex/index.js"></script>
<script>
    $(function () {
        // Initialize card flip
        $('.card.hover').hover(function () {
            $(this).addClass('flip');
        }, function () {
            $(this).removeClass('flip');
        });
    })
</script>
</body>
</html>
