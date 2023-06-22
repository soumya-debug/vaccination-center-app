<!DOCTYPE html>
<html>

<head>
    <title>Citizens</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <%@ include file="header.jsp" %>
        <input type="hidden" id="citizenId" value="${id}">
            <div id="citizenView">
                <h2> View Citizen</h2>
                <div id="oneCitizen"></div>
            </div>
    </div>

    <script>
        window.onload = function(event)
        {
            let id = document.getElementById("citizenId").value;
            console.log(id);
            citizenApi.edit(id, _layoutOneCitizenView)
        }
    </script>
</body>

</html>