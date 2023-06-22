<!-- login.jsp -->

<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

    <%@ include file="base.jsp" %>
        <div class="container">
            <div class="row justify-content-center mt-5">
                <div class="col-md-4">
                    <h2 class="text-center">Login</h2>
                    <form id="loginForm">
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-success">Login</button>

                        <div id="messageList"></div>
                        <p>Register yourself: <a href="/register">Register</a></p>


                    </form>
                </div>
            </div>
        </div>

        <!-- Include JavaScript -->
        <script>
            document.getElementById("loginForm").addEventListener("submit", function (event) {
                event.preventDefault(); // Prevent form submission

                const payload = {
                    email: document.getElementById("email").value,
                    password: document.getElementById("password").value,
                }
                // Fetch POST request to /authenticate
                fetch("/authenticate", {
                    method: "POST",
                    body: JSON.stringify(payload),
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    }
                })
                    .then(function (response) {
                        if (response.ok) {
                            // Redirect to a success page or perform further actions

                            return response.json();
                        } else {

                          onLoginError();
                        }
                    })
                    .then(data=>{
    
                        localStorage.setItem("token",data.encodedToken);
                        window.location.href = getBaseUrl()+ "/vaccinationcenter";
                    })
                    .catch(function (error) {
                        // Handle network or server errors
                        onLoginError();
                        console.error("Error:", error);
                    
                    });
            });

            function onLoginError()
            {
                let errorMessage = `<div class="alert alert-warning" role="alert">Login Failed. Try again!!</div>`;
                            let messageListElement = document.getElementById('messageList');
                            messageListElement.innerHTML = errorMessage;

                            setTimeout(()=>{
                                messageListElement.innerHTML ='';
                            }, 2000)
            }
        </script>
</body>

</html>