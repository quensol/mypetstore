<%@ include file="../common/IncludeTop.jsp"%>

${sessionScope.messageAccount}

<style>
	.okTips{
		color:green;
	}
	.errorTips{
		color:red;
	}
</style>

<script>
	// var xhr;
	// function  checkUserName(){
	// 	var username = document.getElementById("username").value;
	// 	// alert(username);
	// 	// console.log("aa");
	// 	xhr = new XMLHttpRequest();
	// 	xhr.onreadystatechange = fun1;
	// 	xhr.open("GET","usernameExist?username="+username,true);
	// 	xhr.send(null);
	// }
	// function  fun1(){
	// 	if(xhr.readyState === 4){
	// 		if(xhr.status === 200){
	// 			var tips = document.getElementById("usernameTips");
	// 			var responseInfo = xhr.responseText;
	//
	//
	// 			if(responseInfo == 'Exist'){
	// 				tips.className = 'errorTips';
	// 				tips.innerText = "Invalid";
	// 				console.log('Exist')
	// 			}else if(responseInfo == 'Not Exist'){
	// 				tips.className = 'okTips';
	// 				tips.innerText = "Available";
	// 				console.log('Not Exist')
	// 			}
	// 		}
	// 	}
	// }
	//Jquery写法
	$(function(){
		$('#username').on('blur',function(){
			$.ajax({
				type     :"GET",
				url      :"usernameExist?username="+this.value,
				success  :function (data){
					console.log(data);
					if(data.msg == 'Exist'){
						$('#usernameTips').attr("class",'errorTips').text("Invalid");
					}else if(data.msg == 'Not Exist'){
						$('#usernameTips').attr("class",'okTips').text("Available");
					}
				}
			})
		})
	})
</script>

<div id="Catalog">
	<form action="newAccount" method="post">
		<h3>User Information</h3>

		<table>
			<tr>
				<td>User ID:</td>
				<td>
					<input id="username" type="text" name="username"/>
					<span id="usernameTips"></span>
				</td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td><input type="text" name="repeatedPassword" /></td>
			</tr>
			<tr>
				<td>VerificationCode:</td>
				<td>
					<input type="text" name="vCode" size="5" maxlength="4"/>
					<a href="newAccount"><img border="0" src="verificationCode" name="checkcode"></a>
				</td>
			</tr>
		</table>

		<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="newAccount" value="Save Account Information" />
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>