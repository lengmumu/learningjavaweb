<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>毕业留言</title>
<link href="<%=request.getContextPath() %>/alumnirecordsviews/ar.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div id="banner">
    	<img src="<%=request.getContextPath() %>/alumnirecordsviews/arbanner.jpg" />
	</div>
	<div id="content">
		<h2 class="step">在青春的日子里，遇见你们真好</h2>
		<form action="<%=request.getContextPath() %>/alumnirecordsviews/leaveRecordsv2.jsp" method="post" class="one">
			<h3>对啊，这就是我永远都想记住的你呀：</h3>
			<table class="content">
				<tr>
					<td class="left">你青春的模样：</td>
					<td>
						<label for="one"><input type="radio" name="image" id="one" value="青春活泼"/>青春活泼 </label>&nbsp;&nbsp;&nbsp;&nbsp; 
						<label for="two"><input type="radio" name="image" id="two" value="静静感伤"/>静静感伤</label>
						<label for="three"><input type="radio" name="image" id="three" value="奋斗与激情"/>奋斗与激情</label>
						<label for="four"><input type="radio" name="image" id="four" value="八面玲珑"/>八面玲珑</label>
					</td>
				</tr>
				<tr>
					<td class="left">你的邀请码：</td>
					<td><input type="text" class="right" name="invitedCode"/></td>
				</tr>
				<tr>
					<td class="left">大名：</td>
					<td><input type="text" class="right" name="name"/></td>
				</tr>
				<tr>
					<td class="left">性别：</td>
					<td>
						<label for="boy"><input type="radio" name="sex" id="boy" value="男"/>male(男） </label>&nbsp;&nbsp;&nbsp;&nbsp;
						<label for="girl"><input type="radio" name="sex" id="girl" value="女"/>female(女）</label>
						<label for="secret"><input type="radio" name="sex" id="secret" value="保密"/>保密</label>
					</td>
				</tr>
				<tr>
					<td class="left">破壳日：</td>
					<td><input type="date" class="right" name="birthday"/></td>
				</tr>
				<tr>
					<td class="left">小哥哥or小姐姐留下你联系方式呗</td>
					<td><input type="tel" maxlength="11" class="right" name="mobile"/></td>
				</tr>
				<tr>
					<td class="left">QQ/E-mail</td>
					<td><input type="email" class="right" name="email"/></td>
				</tr>
				<tr>
					<td class="left">有空去你家坐坐：</td>
					<td><input type="text" class="right" name="address"/></td>
				</tr>
				<tr>
					<td class="left">彼之爱好，可能恰巧吾也心悦之：</td>
					<td><input type="text" class="right" name="interests"/></td>
				<tr>
					<td class="left">毕业后的你向往的城市：</td>
					<td>
						<select name="yearningCity">
							<option>-请选择-</option>
							<option selected="selected">长沙</option>
							<option>北京</option>
							<option>南京</option>
							<option>上海</option>
							<option>广州</option>
							<option>深圳</option>
							<option>杭州</option>
						</select>
					</td>
				</tr>
			</table>
			<h3>我会以怎样的姿态路过你的青春呢？</h3>
			<table class="content">
				<tr>
					<td class="left">对我的映像：</td>
					<td>
						<input type="checkbox" value="热心善良" name="imageToInviter"/>热心善良&nbsp;&nbsp;&nbsp; 
						<input type="checkbox" value="活泼可爱" name="imageToInviter"/>活泼可爱&nbsp;&nbsp;&nbsp; 
						<input type="checkbox" value="温文尔雅" name="imageToInviter"/>温文尔雅&nbsp;&nbsp;&nbsp;
						<input type="checkbox" value="勤奋刻苦" name="imageToInviter"/>勤奋刻苦&nbsp;&nbsp;&nbsp;<br /> 
						<input type="checkbox" value="青春活力" name="imageToInviter"/>青春活力&nbsp;&nbsp;&nbsp; 
						<input type="checkbox" value="平易近人" name="imageToInviter"/>平易近人&nbsp;&nbsp;&nbsp;
						<input type="checkbox" value="绝对理智" name="imageToInviter"/>绝对理智&nbsp;&nbsp;&nbsp; 
						<input type="checkbox" value="高冷淡然" name="imageToInviter"/>高冷淡然
					</td>
				</tr>
				<tr>
					<td class="left">留言：</td>
					<td>
						<textarea cols="60" rows="8" name="leaveMessage" placeholder="一二两三年，匆匆又夏天。想说什么就尽管说吧"></textarea>
					</td>
				</tr>
				<tr height="30px">
					<td colspan="2" align="center">
						<input type="submit" value="有空多联系呀" class="last" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>