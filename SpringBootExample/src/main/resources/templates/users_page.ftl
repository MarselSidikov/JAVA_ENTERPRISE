<#ftl encoding='UTF-8'>

<head>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Возраст</th>
        <th>Цвет</th>
    </tr>
<#list model.users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.color}</td>
    </tr>
</#list>
</table>
<form action="/users" method="post">
    <input type="text" name="name" placeholder="Имя">
    <input type="text" name="age" placeholder="Возраст">
    <input type="text" name="color" placeholder="Цвет">
    <input type="submit">
</form>
</body>