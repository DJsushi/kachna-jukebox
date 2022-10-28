<#--noinspection HtmlUnknownTarget-->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Jukechna</title>

    <link rel="stylesheet" href="style/main.css">
</head>
<body>

<div class="search-box">
    <div class="search-box__input">
        <svg class="search-box__icon" fill="#e1e3e6" focusable="false" xmlns="http://www.w3.org/2000/svg"
             viewBox="0 0 24 24">
            <path d="M15.5 14h-.79l-.28-.27A6.471 6.471 0 0 0 16 9.5 6.5 6.5 0 1 0 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
        </svg>
        <input class="search-box__input__text-field" aria-label="Search songs" type="text"
               placeholder="Search songs...">
    </div>
    <div class="search-box-splitter"></div>
    <div class="search-box__results">

    </div>
</div>


<script src="js/search.js"></script>
</body>
</html>