<#ftl encoding='UTF-8'>
<head>
    <head>
        <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
</head>
<body>
<#if model.error.isPresent()>
<div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<div class="content-block">
    <form class="form-horizontal" action="/login" method="post">
        <input name="login" placeholder="Логин">
        <input name="password" placeholder="Пароль">
        <input type="submit">
    </form>
</div>
</body>