<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<head>
<title></title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	
	<table align="center">
		<tr>
			<td>Address1</td>
			<td><input type="text" name="address1" required="required"></td>
		</tr>
		<tr>
			<td>Address2</td>
			<td><input type="text" name="address2" ></td>
		</tr>
		<tr>
			<td>Address3</td>
			<td><input type="text" name="address3"></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><select name="country" id="country" required>
					<option value="">Select Country</option>
			</select></td>
		</tr>
		<tr>
			<td>State :</td>
			<td><select name="state" id="state" required>
					<option value="">Select State</option>
			</select></td>
		</tr>

		<!-- Add an empty dropdown for cities that will be populated via AJAX -->
		<tr>
			<td>City :</td>
			<td><select name="city" id="city" required>
					<option value="">Select City</option>
			</select></td>
		</tr>

		<tr>
			<td>ZipCode</td>
			<td><input type="text" name="zipcode" required="required"
				oninput="this.value = this.value.replace(/[^0-9.]/g, '')"
				maxlength="6"></td>
		</tr>
		

	</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 
	<script>
	 $(document).ready(function () {
	        var countryDropdown = $("#country");
	        $.get("CountryListServlet", function (data, status) {
	            $.each(data, function (index, country) {
	                countryDropdown.append($('<option></option>').attr('value', country.countryCode).text(country.countryName));
	            });
	        });
	        countryDropdown.change(function () {
	        	
	            var countryCode = $(this).val();
	            $.get("CountryListServlet", {
	                countryCode: countryCode
	            }, function (data, status) {
	                var stateDropdown = $("#state");
	                stateDropdown.empty(); 
	                var cityDropdown = $("#city");
	                cityDropdown.empty(); 
	 
	                $.each(data, function (index, state) {
	                    stateDropdown.append($('<option></option>').attr('value', state.stateCode).text(state.stateName).attr('data-attribute1', state.countryCode));
	                });
	            });
	        });
	        var cityDropdown = $("#city");
	        $("#state").change(function () {
	            var stateCode = $(this).val();
	            var countryCode = $(this).find(':selected').data('attribute1'); 
	            $.get("CountryListServlet", {
	            	stateCode: stateCode,
	            	countryCode: countryCode
	            }, function (data, status) {
	                cityDropdown.empty(); // Clearing old values
	                $.each(data, function (index, city) {
	                    cityDropdown.append($('<option></option>').attr('value', city.cityCode).text(city.cityName));
	                });
	            });
	        });
	    });
</script>

	
	
</body>