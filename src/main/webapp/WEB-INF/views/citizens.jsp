<!DOCTYPE html>
<html>

<head>
<title>Citizens</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<div class="container">

		<%@ include file="header.jsp"%>
		<div id="citizenEdit">
			<h2>Citizen From</h2>


			<form id="citizenEditForm">
				<input type="hidden" id="citizenId">
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="citizenName" required>
				</div>

				<div class="form-group">
					<label for="citizenCity">Citizen City:</label> <select
						class="form-control" id="citizenCity" required>
						<option value="None">None</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Jaipur">Jaipur</option>
						<option value="Bengaluru">Bengaluru</option>
						<option value="Chennai">Chennai</option>
						<option value="Kolkata">Kolkata</option>
						<option value="Visakhapatnam">Visakhapatnam</option>
						<option value="Pune">Pune</option>
						<option value="Bhubaneswar">Bhubaneswar</option>
						<option value="New Delhi">New Delhi</option>
						<option value="Noida">Noida</option>
						<option value="Gurugram">Gurugram</option>
						<option value="Chandigarh">Chandigarh</option>
						<option value="Srinagar">Srinagar</option>
						<option value="Hyderabad">Hyderabad</option>
						<!-- Add more city options as needed -->
					</select>

				</div>

				<div class="form-group">
					<label for="center">Vaccination Centers:</label> <select
						class="form-control" id="center" required>
					</select>
				</div>

				<div id="citizenOnEdit">

					<div class="form-group">
						<label for="count">Vaccination Count:</label> <select
							class="form-control" id="vaccinationCount" required>
							<option value="0">None</option>
							<option value="1">1</option>
							<option value="2">2</option>
						</select>
					</div>
					<div class="form-group">
						<label for="status">Status:</label> <label class="form-control"
							id="vaccinationStatus" required>
					</div>

				</div>
				<button type="submit" onclick="saveCitizen(event)"
					class="btn btn-primary">Submit</button>

				<br> <span id="errorList"></span>

			</form>

		</div>
		<div id="citizenView">
			<h2>View Citizen</h2>
			<div id="oneCitizen"></div>
		</div>
		<div id="citizenDetails">
			<button type="button" onclick="_newCitizen(event)"
				class="btn btn-primary">Add New Citizen</button>

			<h2>Citizen Details</h2>
			<table id="citizensTable" class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>City</th>
						<th>Vaccination Count</th>
						<th>Vaccination Status</th>
						<th>Vaccination Center</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody></tbody>
			</table>

			<div id="countRow"></div>
		</div>
	</div>

</body>

</html>