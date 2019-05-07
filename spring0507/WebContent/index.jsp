<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="width: 300px; padding: 20px; margin: 20px; border: 4px dashed #ccc;">
		<form id="myform" name="myform" method="post" action="#">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="username" name="username" placeholder="请输入用户名"
						onfocus="this.placeholder=''" onblur="this.placeholder='请输入用户名'" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" id="password" name="password" placeholder="请输入密码"
						onfocus="this.placeholder=''" onblur="this.placeholder='请输入密码'" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="提交"
						onclick="doLogin('weixin');" /></td>
				</tr>
			</table>
			<input type="hidden" name="loginType" id="loginType" value="weixin" />
		</form>
		
	</div>
	<div id="errMsg" style="color: red">${errMsg}</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		function doLogin(type) {
			$.ajax({
				type : "GET",
				url : "login.do",
				data : {
					username : $("#username").val(),
					password : $("#password").val(),
					type : type
				},
				dataType : "json", //预期服务器返回的数据
				success : function(data) {
					if (data.errCode < 0) {
						alert("登录失败！")
						$("#errMsg").show().html(data.errMsg).stop(true, true)
								.fadeOut(3000);
					} else {
						//登录成功，做其他处理
						alert("恭喜你，登录成功！");
					}

				}
			});

		}
	</script>
</body>
</html>