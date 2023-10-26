 

<%@page import="com.velociter.ems.helper.GetStateCity"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>

<%@page import="com.velociter.ems.helper.GetStateCity"%>

<%

GetStateCity getCityState1= new GetStateCity();

List<String> stateList = getCityState1.getState();

%>

 

<head>

    <title></title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>

    <table align="center">

        <tr>

            <td>Address1 <span style="color:red">*</span></td>

            <td><input type="text" name="address1" required="required"></td>

        </tr>

        <tr>

            <td>Address2</td>

            <td><input type="text" name="address2"></td>

        </tr>

        <tr>

            <td>Address3</td>

            <td><input type="text" name="address3"></td>

        </tr>

        <tr>

            <td>State : <span style="color:red">*</span></td>

            <td>

                <select name="state" id="stateID" required>

                    <option value="">Select state</option>

                    <%

                    for (String showState : stateList) {

                    %>

                    <option value="<%=showState%>"><%=showState%></option>

                    <%

                    }

                    %>

                </select>

            </td>

        </tr>

 

        <!-- Add an empty dropdown for cities that will be populated via AJAX -->

        <tr>

            <td>City : <span style="color:red">*</span></td>

            <td>

                <select name="city" id="cityID" required>

                    <option value="">Select City</option>

                </select>

            </td>

        </tr>

 

        <tr>

            <td>ZipCode <span style="color:red">*</span></td>

            <td><input type="text" name="zipcode" required="required"></td>

        </tr>

        <tr>

            <td>Country <span style="color:red">*</span></td>

            <td><input type="text" name="country" required="required"></td>

        </tr>

    </table>

 

    <script type="text/javascript">

        $(document).ready(function () {

            // JavaScript code to fetch cities using AJAX

            $("#stateID").change(function () {

                console.log("State selected: " + $(this).val());

                $.ajax({

                    type: "POST",

                    url: "CityServlet", // Replace with the actual URL of your servlet

                    data: {

                        state: $(this).val() // Get the selected state

                    },

                    success: function (data) {

                        // Update the city dropdown with the received data

                        $("#cityID").html(data);

                    }

                });

            });

        });

    </script>

</body>