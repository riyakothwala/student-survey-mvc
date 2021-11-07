<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="survey.css">
<link rel="stylesheet" href="./department.css">
<title>Student Form (already filled in)</title>
</head>
<body>
    <%
    String studentId = (String) request.getAttribute("studentid");
    String username = (String) request.getAttribute("username");
    String address =  (String) request.getAttribute("address");
    String city =  (String) request.getAttribute("city");
    String state = (String) request.getAttribute("state");
    %>
	<div style="text-align: right; font-style: italic;">Riya Modi</div>
	<div class="w3-large">
		<h1>Computer Science Department</h1>
	</div>

	<h5 class="survey-form">Survey Form (previously filled in)</h5>
	<form  id="form" class=" w3-container w3-light-grey w3-text-black " >
		<div id="error"></div>
		<div>
			<strong>StudentId: <span class="required">*</span>
			</strong> <input readonly id="studentid" class="w3-text " name="studentid" autofocus
				type="text " size="25 " value=<%=studentId%> />
		</div>
		<div>
			<strong>Username: <span class="required">*</span>
			</strong> <input readonly id="username" class="w3-text " name="name" autofocus
				type="text " size="25 " placeholder="username " value=<%=username%>>
		</div>
		<div>
			<strong>Street address:</strong><br />
			<textarea readonly id="address" name="address" rows="5" cols="40"
				placeholder="address" value=<%=address%>></textarea>
		</div>
		<div>
			<strong>City:</strong> <input readonly name="city" type="text" size="25" value=<%=city%>>
		</div>
		<div>
			<strong>State:</strong> <input readonly name="state" type="text" size="25"
				placeholder="state " value=<%=state%>>

		</div>
		<div>
			<!-- <strong>Zip code:</strong> <input readonly id="zip" name="Zip " type="text "
				size="25 " placeholder="zip-code" onblur='validateZip( this.value )' /> -->
			<!-- <span id="validateZip" class="invalidzip"></span> -->

		</div>
		<div>
			<strong>Telephone number:<span class="required ">*</span></strong> <input readonly
				type="tel " id="phone " name="phone "
				placeholder="(###)-(###)-(####) " />

		</div>
		<div>
			<strong>Email:<span class="required ">*</span></strong> <input readonly
				id="email" name="email " type="email " size="25 "
				placeholder="name@domain.com " />
		</div>
		<div>
			<strong>URL:</strong> <input name="url " type="url " size="25 " readonly
				placeholder="https://www.name.com " />
		</div>
		<div>
			<strong>Date:<span class="required ">*</span></strong> <input readonly
				name="date " type="date " size="25 " placeholder="mm-dd-yyyy " />
		</div>

		<!-- checkboxes -->
		<p>
			<strong>What you liked most about the campus:</strong><br /> <label><input
				class="w3-check " name="thingsliked " type="checkbox"
				value="students " /> Students </label><br /> <label><input
				class="w3-check " name="thingsliked " type="checkbox"
				value="location " /> Location </label><br /> <label> <input
				class="w3-check " name="thingsliked " type="checkbox"
				value="campus " /> Campus
			</label><br /> <label><input class="w3-check " name="thingsliked "
				type="checkbox" value="atmosphere " /> Atmosphere </label><br /> <label><input
				class="w3-check " name="thingsliked " type="checkbox"
				value="Dorm rooms " /> Dorm rooms </label><br /> <label><input
				class="w3-check " name="thingsliked " type="checkbox"
				value="sports " /> Sports </label>
		</p>

		<!-- radio buttons  -->
		<p>
			<strong>How they became interested in the university:</strong><br />

			<label> <input id="radiobutton" class="w3-radio "
				name="interested " type="radio" value="friends " /> Friends
			</label><br /> <label><input id="radiobutton1" class="w3-radio "
				name="interested " type="radio" value="television " /> Television </label><br />

			<label><input id="radiobutton2" class="w3-radio "
				name="interested " type="radio" value="internet " /> Internet </label><br />

			<label><input id="radiobutton3" class="w3-radio "
				name="interested " type="radio" value="other " /> Other </label><br />
		</p>

		<!-- comment box -->
		<div>
			<strong>Comments: </strong></br>
			<textarea readonly class=" w3-text " class="w3-textarea " name="comments "
				rows="5 " cols="40 " placeholder="notes "></textarea>
		</div>

		<!-- graduation month and year  -->
		<div style="padding-bottom: 20px;">
			<strong for="browser ">High-school garduation:<span
				class="required ">*</span></strong> <input list="months " name="month "
				id="month " placeholder="select month ">
			<datalist id="months ">
				<option value="January "></option>
				<option value="February "></option>
				<option value="March "></option>
				<option value="April "></option>
				<option value="May "></option>
				<option value="June "></option>
				<option value="July "></option>
				<option value="August "></option>
				<option value="September "></option>
				<option value="October "></option>
				<option value="November "></option>
				<option value="December "></option>
			</datalist>
			<input style="margin-left: 10px;" class=" " type="text " name="year "
				placeholder="year " />
		</div>

		<!-- School recommendation  -->
		<div style="padding-bottom: 20px;">
			<strong> Recommend this school to other:<span
				class="required ">*</span>
			</strong> <select name="recommend" id="recommend">
				<option value="Very Likely">Very Likely</option>
				<option value="Likely">Likely</option>
				<option value="Unlikely">Unlikely</option>
			</select>
		</div>

		<div style="padding-bottom: 20px;">
			<!-- onfocusout="doCalculations()" -->
			<strong> Data: (ten comma separated numbers)</strong> 
			<input readonly id="data" class="w3-text" type="text" name="data" /> 
			<!-- <span id="dataerrors" class="invalidzip"></span> -->
		</div>

		<!-- <div style="padding-bottom: 20px;">
			<label>Maximum:</label>
			<output id="maximum" name="maximum"></output>
		</div>

		<div style="padding-bottom: 20px;">
			<label>Average:</label>
			<output id="average" name="average"></output>
		</div> -->

		<!-- submit and reset button -->
		<div style="padding-bottom: 20px;">
			<button id="submit" class=" w3-btn w3-large w3-gray" type="submit"
				name="submit" value="submit">Submit</button>
			<button id="reset" class=" w3-btn w3-large w3-gray " type="reset"
				name="reset" value="reset">Reset</button>
		</div>

		<!-- required field note  -->
		<div style="padding-bottom: 40px; font-weight: bold;">
			Note: <span class="required ">*</span> Required field
		</div>


	</form>


</body>
</html>