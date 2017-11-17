<head>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Логин</th>
        <th>Операции</th>
    </tr>
<#list model.users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.login}</td>
        <td><a href="/admin/password/temp/${user.id}">Пароль</a></td>
    </tr>
</#list>
</table>
</body>