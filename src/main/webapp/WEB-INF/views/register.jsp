<!DOCTYPE html>
<html>
<head>
  <title>Registration Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
</head>

<body>

  <%@ include file="base.jsp" %>
    <div class="container">
      <h2>Registration Page</h2>
      <form id="registrationForm">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="button" class="btn btn-primary" onclick="submitForm()">Register</button>

        <div id="messageList"></div>
        <p>Already have an account? <a href="/">Login</a></p>
      </form>
    </div>
</body>

</html>