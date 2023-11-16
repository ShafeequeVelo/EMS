<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  background: rgb(130, 106, 251);
}
.container {
  position: relative;
  max-width: 700px;
  width: 100%;
  background: #fff;
  padding: 25px;
  border-radius: 8px;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}
.container header {
  font-size: 1.5rem;
  color: #333;
  font-weight: 500;
  text-align: center;
}
.container .form {
  margin-top: 30px;
}
.form .input-box {
  width: 100%;
  margin-top: 20px;
}
.input-box label {
  color: #333;
}
.form :where(.input-box input, .select-box) {
  position: relative;
  height: 50px;
  width: 100%;
  outline: none;
  font-size: 1rem;
  color: #707070;
  margin-top: 8px;
  border: 1px solid #ddd;
  border-radius: 6px;
  padding: 0 15px;
}
.input-box input:focus {
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
}
.form .column {
  display: flex;
  column-gap: 15px;
}

.select-box  {
  height: 100%;
  width: 100%;
  outline: none;
  color: #707070;
  font-size: 1rem;
}


</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="container">
<div class="input-box address">
         <div class="input-box">
				<label>Address1</label>
				 <input type="text" name="address1" 
					placeholder="Enter your address1" required />
			</div>
			<div class="input-box">
				<label>Address2</label> <input type="text" name="address2" 
					placeholder="Enter your address2" required />
			</div>
			<div class="input-box">
				<label>Address3</label> <input type="text" name="address3" 
					placeholder="Enter your address3" required />
			</div>
			 <div class="select-box">
				<label>Country</label> <select name="country" id="country" required>
					<option value="">Select Country</option>
			</select>
			</div>
			 <div class="select-box">
				<label>State</label> <select name="state" id="state" required>
					<option value="">Select State</option>
			</select>
			</div>
			 <div class="select-box">
				<label>City</label> <select name="city" id="city" required>
					<option value="">Select City</option>
			</select>
			</div>
			<div class="input-box">
				<label>Zipcode</label> <input type="text" name="zipcode" 
					placeholder="Enter full name" oninput="this.value = this.value.replace(/[^0-9.]/g, '')"
				maxlength="6" required />
			</div>
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
          
       
      </form>
    </section>

</body>
</html>