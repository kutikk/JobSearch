<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Детали резюме</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>Детали резюме</h2>
    <ul class="list-group">
        <li class="list-group-item"><strong>Имя:</strong> ${resume.name}</li>
        <li class="list-group-item"><strong>Категория:</strong> ${resume.categoryId}</li>
        <li class="list-group-item"><strong>Желаемая зарплата:</strong> ${resume.salary}</li>
        <li class="list-group-item"><strong>Активность:</strong> ${resume.is_active()?string("Да", "Нет")}</li>
        <li class="list-group-item"><strong>Дата создания:</strong> ${resume.created_date}</li>
        <li class="list-group-item"><strong>Обновлено:</strong> ${resume.update_time}</li>
        <li class="list-group-item"><strong>Кандидат ID:</strong> ${resume.applicant_id}</li>
    </ul>
    <a href="/resumes" class="btn btn-secondary mt-3">Назад к списку</a>
</div>

</body>
</html>
