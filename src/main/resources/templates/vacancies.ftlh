<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вакансии</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Список вакансий</h2>

    <#list vacancies as vacancy>
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">${vacancy.name}</h5>
                <p class="card-text"><strong>Зарплата:</strong> ${vacancy.salary} сом</p>
                <p class="card-text"><strong>Дата публикации:</strong> ${vacancy.created_date}</p>
                <a href="/profile/${vacancy.author_id}" class="btn btn-primary">Профиль компании</a>
            </div>
        </div>
    </#list>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
