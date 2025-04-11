<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вакансии</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Список вакансий</h2>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Категория</th>
            <th>Зарплата</th>
            <th>Опыт от</th>
            <th>Опыт до</th>
            <th>Активна</th>
            <th>Автор</th>
            <th>Дата создания</th>
            <th>Обновлено</th>
        </tr>
        </thead>
        <tbody>
        <#list vacancies as vacancy>
        <tr>
            <td>${vacancy.id}</td>
            <td>${vacancy.name}</td>
            <td>${vacancy.description}</td>
            <td>${vacancy.category_id}</td>
            <td>${vacancy.salary}</td>
            <td>${vacancy.exp_from}</td>
            <td>${vacancy.exp_to}</td>
            <td>${vacancy.is_active?string("Да", "Нет")}</td>
            <td>${vacancy.author_id}</td>
            <td>${vacancy.created_date}</td>
            <td>${vacancy.update_time}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>
