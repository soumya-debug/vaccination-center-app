
<%@ include file="base.jsp" %>
<style>
    /* Custom styles for the dark navbar */
    .navbar-dark {
      background-color: #333; /* Customize the background color */
      color: #fff; /* Customize the text color */
    }
  </style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="<%= baseUrl %>/citizens">Citizens</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%= baseUrl %>/vaccinationcenter">Vaccination Centers</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="logout()">Logout</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Welcome, <span id="userName"></span></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <script>
    function loadUserInfo()
    {
        fetch(getBaseUrl()+"/me",{
            headers: getHeaders()
        })
        .then(response=>{
            if(response.ok)
            {
                return response.json();
            }
            throw new Error('error while accessing user info');
        })
        .then(data=>{
            document.getElementById('userName').innerText= data.name;
        })
        .catch(error=>{
            console.log(error);
        })
    }
    setTimeout(loadUserInfo, 1000);
  </script>