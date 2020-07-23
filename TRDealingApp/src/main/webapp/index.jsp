<html>
 <head>
<meta charset="utf-8">
<title>Login Form</title>
<link rel="stylesheet" href="style.css">
</head> 
<style>
body {
	text-align: center;
}

h3 {
	text-align: center;
	font-size: 50px;
	color: white;
	background-color: black;
}
</style>
<body >


	<h3>TRANSPORTATION-DEALING-APP</h3>
<img src="C:\Users\YUSUF AGWAN\Desktop\wallpapers/admin.png">
	<table align="center" cellpadding="10">

		<form action="verifyuser">
			<tr>
				<th>Email-Id</th>
				<td><input type="text" name="email"
					placeholder="Enter Username" required="required" id="mytxt1" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					placeholder="***********" required="required" id="mytxt2" /></td>
			</tr>
			<tr>
				<th>UserType</th>
				<td><select name="utype" id="mytxt3">

						<option>Admin</option>
						<option>Transporter</option>
						<option>Customer</option>
				</select></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="LOG-IN" id="logtxt" /></td>
			</tr>
	</table>
	</form>



	<hr>

	<ul>
	<li><a href="customerentry">New-Customer-Registration</a></li>

	<li><a href="transporterentry">New-Transporter-Registration</a></li>
	</ul>


	<hr>
	<script>
		var txt1 = document.getElementById("mytxt1");
		var txt2 = document.getElementById("mytxt2");
		var txt3 = document.getElementById("mytxt3");
		var ltxt = document.getElementById("logtxt");
		function changeColorAqua(e) {
			txt1.style.backgroundColor = 'lightblue';
			txt3.style.backgroundColor = 'lightblue';
			txt3.style.backgroundColor = 'lightblue';
		}
		function changeColorWhite(e) {
			txt1.style.backgroundColor = 'white';
			txt2.style.backgroundColor = 'white';
			txt3.style.backgroundColor = 'white';
		}
		function changeColorPink(e) {
			txt1.style.backgroundColor = 'lightblue';
			txt3.style.backgroundColor = 'lightblue';
			txt3.style.backgroundColor = 'lightblue';
		}
		function changeColorWhiteL(e) {
			txt1.style.backgroundColor = 'white';
			txt2.style.backgroundColor = 'white';
			txt3.style.backgroundColor = 'white';
		}

		txt1.addEventListener("mouseover", changeColorAqua, false);
		txt1.addEventListener("mouseout", changeColorWhite, false);
		txt2.addEventListener("mouseover", changeColorAqua, false);
		txt2.addEventListener("mouseout", changeColorWhite, false);
		txt3.addEventListener("mouseover", changeColorAqua, false);
		txt3.addEventListener("mouseout", changeColorWhite, false);
		ltxt.addEventListener("mouseover", changeColorPink, false);
		ltxt.addEventListener("mouseout", changeColorWhiteL, false);
	</script>
</body>
</html>



