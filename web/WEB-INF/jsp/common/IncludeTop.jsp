
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />

    <link rel="stylesheet" href="css/mouseEventInform.css" type="text/css" media="screen" />

    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>

    <style>
        .AutoFillTipsOn{
            background-color:white;
            width:170px;
            position:absolute;
            text-align: left;
            left: 1047px;
            color: black;
            line-height: normal;
            border:1px solid gray;
        }
        .AutoFillTipsOff{
            background-color:white;
            width:170px;
            position:absolute;
            text-align: left;
            left: 1047px;
            color: black;
            line-height: normal;
        }
    </style>

</head>

<body>

<script>
    $(function(){
        $('#SearchText').keyup('blur',function(){
            $.ajax({
                type     :"GET",
                url      :"AutoFill?keyword="+this.value,
                success  :function (data){
                    for (var i = 0; i<5; i++) {
                        $('#context'+(i+1)).attr("class",'AutoFillTipsOff').text("");
                    }
                    for (var i = 0; i < data.length&&i<5; i++) {
                        $('#context'+(i+1)).attr("class",'AutoFillTipsOn').text(data[i].msg);
                    }
                }
            })
        })
    })

    function changeBackColor_mouseEnter(div){
        $(div).css("background-color","#CCCCCC");
    }
    function changeBackColor_mouseLeave(div){
        $(div).css("background-color","");
    }
    function  item_onclick(div){
        $('#SearchText').val(div.innerText);
        for (var i = 0; i<5; i++) {
            $('#context'+(i+1)).attr("class",'AutoFillTipsOff').text("");
        }
    }

</script>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <!--购物车-->
            <a href="viewCart"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
            <img align="middle" src="images/separator.gif" />
            <c:if test="${sessionScope.account == null}">
                <a href="signOnForm">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <a href="signOff">Sign Out</a>
                <!---signOff-->
            </c:if>

            <!--分隔符-->
            <c:if test="${sessionScope.account != null}">
                <img align="middle" src="images/separator.gif" />
                <a href="editAccount">My Account</a>
            </c:if>
            <img align="middle" src="images/separator.gif" />
            <!--暂未提供-->
            <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <!--搜索栏目-->
            <form action="searchProduct" method="post">
                <input id="SearchText" type="text" name="keyword" size="14" />
                <input type="submit" name="searchProducts" value="Search" />
                <div id="context1" style="top: 50px" onclick="item_onclick(this)" onmouseenter="changeBackColor_mouseEnter(this)" onmouseleave="changeBackColor_mouseLeave(this)"></div>
                <div id="context2" style="top: 70px" onclick="item_onclick(this)" onmouseenter="changeBackColor_mouseEnter(this)" onmouseleave="changeBackColor_mouseLeave(this)"></div>
                <div id="context3" style="top: 90px" onclick="item_onclick(this)" onmouseenter="changeBackColor_mouseEnter(this)" onmouseleave="changeBackColor_mouseLeave(this)"></div>
                <div id="context4" style="top: 110px" onclick="item_onclick(this)" onmouseenter="changeBackColor_mouseEnter(this)" onmouseleave="changeBackColor_mouseLeave(this)"></div>
                <div id="context5" style="top: 130px" onclick="item_onclick(this)" onmouseenter="changeBackColor_mouseEnter(this)" onmouseleave="changeBackColor_mouseLeave(this)"></div>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img src="images/sm_fish.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS"><img src="images/sm_dogs.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img src="images/sm_reptiles.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS"><img src="images/sm_cats.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
    </div>
</div>

</div id="Content">
