<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Резюме</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Список резюме</h2>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Категория</th>
            <th>Желаемая зарплата</th>
            <th>Активность</th>
            <th>Дата создания</th>
            <th>Обновлено</th>
            <th>Кандидат ID</th>
        </tr>
        </thead>
        <tbody>
        <#list resumes as resume>
            <tr>
                <td>${resume.id}</td>
                <td>${resume.name}</td>
                <td>${resume.categoryId}</td>
                <td>${resume.salary}</td>
                <td>${resume.is_active()?string("Да", "Нет")}</td>
                <td>${resume.created_date}</td>
                <td>${resume.update_time}</td>
                <td>${resume.applicant_id}</td>

            </tr>
        </#list>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>
