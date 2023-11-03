<table style="margin-left: auto; margin-right: auto">
	<tr>
		<td>Address 1<Span style="color:red">*</Span>:</td>
		<td><input type="text" id="address1" name="address1" required></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" id="address2" name="address2"></td>
	</tr>
	<tr>
		<td>Address 3:</td>
		<td><input type="text" id="address3" name="address3"></td>
	</tr>
	<tr>
		<td>Country<Span style="color:red">*</Span>:</td>
				<td><select id="country" name="Country" style="width: 100%" required>
				<option disable selected>Select Country</option>
		</select></td>
	</tr>	<tr>
		<td>State<Span style="color:red">*</Span>:</td>
		<td><select id="state" name="State" style="width: 100%" >
				<option disable selected>Select State</option>
		</select></td>
	</tr>
	<tr>
		<td>City<Span style="color:red">*</Span>:</td>
		<td><select id="city" name="City" style="width: 100%" >
				<option disable selected>Select City</option>
		</select></td>
	</tr>
	<tr>
		<td>Zip Code<Span style="color:red">*</Span>:</td>
		<td><input type="text" id="zipcode" name="Zipcode" required></td>
	</tr>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        var countryDropdown = $("#country");
        $.get("DropdownServlet", function (data, status) {
            $.each(data, function (index, country) {
                countryDropdown.append($('<option></option>').attr('value', country.countryCode).text(country.countryName).attr('data-zipcode', country.zipcode));
            });
        });
 
        countryDropdown.change(function () {
        	
        	
        	var zipcode = $(this).find(':selected').data('zipcode');
        	var zipcodeInput = $("#zipcode");
        	zipcodeInput.val('');
        	zipcodeInput.attr('pattern', '[0-9]{' + zipcode + '}');
        	zipcodeInput.attr('maxlength', zipcode);
        	
            var countryCode = $(this).val();
            $.get("DropdownServlet", {
                countryCode: countryCode
            }, function (data, status) {
                var stateDropdown = $("#state");
                stateDropdown.empty(); // Clearing old values
                var cityDropdown = $("#city");
                cityDropdown.empty(); // Clearing old values
 
                $.each(data, function (index, state) {
                    stateDropdown.append($('<option></option>').attr('value', state.stateCode).text(state.stateName).attr('data-attribute1', state.countryCode));
                });
            });
        });
 
        var cityDropdown = $("#city");
        $("#state").change(function () {
            var stateCode = $(this).val();
            var countryCode = $(this).find(':selected').data('attribute1'); //	Access data attribute for the selected option
            $.get("DropdownServlet", {
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

