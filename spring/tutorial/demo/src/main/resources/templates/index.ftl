<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>

<button id="mybtn">get cities</button>

<div>
    <ul id="output">

    </ul>
</div>

<script>
        $('#mybtn').click(function () {

            $.getJSON('getCities', function (data) {

                $("ul#output > li").remove();

                $.each(data, function (key, value) {
                    $("#output").append('<li>' + value['name'] + " " + value['population'] + '</li>');
                });
            });
        });
    </script>
</body>
</html>