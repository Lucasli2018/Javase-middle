<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QQ Eamil</title>
<style type="text/css">
body {
	background: url(img/1.png) no-repeat;
	background-position: 200px 200px;
}

* {
	padding: 0;
	margin: 0;
}

.top {
	width: 1600px;
	height: 60px;
}

.footer {
	width: 1600px;
	height: 40px;
	position: absolute;
	bottom: 0px;
}

.all {
	border: 1px solid lightblue;
	width: 335px;
	height: 387px;
	position: absolute;
	top: 136px;
	right: 341px;
}

.all .first .login, .all .first .pas {
	width: 167px;
	height: 50px;
	text-align: center;
	line-height: 50px;
	display: block;
	float: left;
	background-color: lightblue;
	font-family: "微软雅黑";
	color: gray;
}

.all .second .number {
	width: 284px;
	height: 35px;
	margin-top: 33px;
	margin-left: 17px;
}

.all .second .password {
	width: 284px;
	height: 35px;
	margin-top: 15px;
	margin-left: 17px;
}

.all .second .ok {
	width: 284px;
	height: 40px;
	margin-top: 17px;
	margin-left: 17px;
	border: 0;
	background-color: cornflowerblue;
	font-size: larger;
	color: white;
	font-family: "微软雅黑";
}

.all .first {
	width: 335px;
	height: 52px;
}

.all .second {
	width: 332px;
	height: 290px;
}

.all .third {
	width: 222px;
	height: 45px;
	   line-height: 45px;
	   padding-left: 110px;
}

.all .first .login:hover {
	color: black;
}

.all .first .pas:hover {
	color: black;
}

.all .second .bnext {
	width: 20px;
	height: 20px;
	margin-top: 10px;
	margin-left: 17px;
}

.all .second .tnext {
	display: block;
	width: 100px;
	height: 15px;
	margin-left: 45px;
	margin-top: -22px;
	font-size: small;
}

.all .third span {
	font-size: smaller;
	color: blue;
	font-family: "微软雅黑";
}
</style>
</head>
<body>
	<img src="img/logo.png" class="top" />
	<div class="all">
		<div class="first">
			<span class="login">快速登录</span> <span class="pas">账号密码登录</span>
		</div>
		<div class="second">
			<input type="text" placeholder="QQ账号" class="number" /><br /> <input
				type="text"  placeholder="QQ密码"  class="password" /> <input
				type="checkbox" class="bnext" /><span class="tnext">下次自动登录</span> <input
				type="button" value="登录"  class="ok" />
		</div>
		<div class="third">
			<span>忘了密码？|</span> <span>注册新账户|</span> <span>意见反馈</span>
		</div>

	</div>
	<img src="img/footer.png" class="footer" />
</body>
</html>
