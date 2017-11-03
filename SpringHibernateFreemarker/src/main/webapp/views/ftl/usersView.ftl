<div id="content">
    <table class="Users">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
    <#list model["usersModel"] as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
        </tr>
    </#list>
    </table>
</div>