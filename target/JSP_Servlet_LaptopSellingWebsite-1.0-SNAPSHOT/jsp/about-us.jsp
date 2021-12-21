<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Metaverse Laptop</title>
    <link rel="icon" href="../image/logo-re.png">
    <link rel="stylesheet" href="../css/about.css">
    <link rel="stylesheet" href="../css/style.css">
    <link href="../css/responsiveIndex.css" rel="stylesheet">
    <link href="../fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div id="about-us">
    <%@include file="../layout/header.jsp"%>
    <%@include file="../layout/cart-hover.jsp"%>
    <div id="content">
        <div class="member">
            <div class="member-items">
                <div class="image-member">
                    <img src="../image/member/quocthinh.jpg" alt="" class="img">
                </div>
                <div class="name-member">
                    <h1 class="name">Lê Quốc Thịnh</h1>
                </div>
                <div class="member-role">
                    <p class="role">Leader</p>
                </div>
                <div class="link-member">
                    <a href="https://www.facebook.com/unlocker0808/" target="_blank" title="Facebook cá nhân"
                       class="link-member-items"><i class="fab fa-facebook"></i></a>
                    <a href="https://github.com/unlocker1205/BaiTapLapTrinhWeb" target="_blank" title="Github cá nhân"
                       class="link-member-items"><i class="fab fa-github"></i></a>
                    <a href="https://19130215.tk/" target="_blank" title="Link web cá nhân" class="link-member-items"><i
                            class="fas fa-link"></i></a>
                </div>
            </div>
            <div class="member-items">
                <div class="image-member">
                    <img src="../image/member/tanloc.jpg" alt="" class="img">
                </div>
                <div class="name-member">
                    <h1 class="name">Cao Huy Tấn Lộc</h1>
                </div>
                <div class="member-role">
                    <p class="role">Member</p>
                </div>
                <div class="link-member">
                    <a href="https://www.facebook.com/Ya.Tanloc" target="_blank" title="Facebook cá nhân"
                       class="link-member-items"><i class="fab fa-facebook"></i></a>
                    <a href="" target="_blank" title="Github cá nhân" class="link-member-items"><i
                            class="fab fa-github"></i></a>
                    <a href="" target="_blank" title="Link web cá nhân" class="link-member-items"><i
                            class="fas fa-link"></i></a>
                </div>
            </div>
            <div class="member-items">
                <div class="image-member">
                    <img src="../image/member/minhquan.jpg" alt="" class="img">
                </div>
                <div class="name-member">
                    <h1 class="name">Phạm Hữu Minh Quân</h1>
                </div>
                <div class="member-role">
                    <p class="role">Member</p>
                </div>
                <div class="link-member">
                    <a href="https://www.facebook.com/xalaicucphuc01" target="_blank" title="Facebook cá nhân"
                       class="link-member-items"><i class="fab fa-facebook"></i></a>
                    <a href="" target="_blank" title="Github cá nhân" class="link-member-items"><i
                            class="fab fa-github"></i></a>
                    <a href="" target="_blank" title="Link web cá nhân" class="link-member-items"><i
                            class="fas fa-link"></i></a>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../layout/footer.jsp"%>
</div>
<%@include file="../layout/login.jsp"%>
<%@include file="../layout/fogot.jsp"%>
<%@include file="../layout/register.jsp"%>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp"%>
</body>
<script src="../js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="../js/nav-responsive.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/Scroll-Indicator.js"></script>
<script src="../js/visibleCart.js"></script>
</html>