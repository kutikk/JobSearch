<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .avatar {
            width: 270px;
            height: 270px;
            object-fit: cover;
            border-radius: 15px;
        }
        .notification-badge {
            position: absolute;
            top: 0;
            right: 0;
            transform: translate(50%, -50%);
        }
        .name{
            margin-top: 10px;
        }
        .createResume{
            width: 170px;
            height: 170px;
        }
        .button-group {
            display: flex;
            gap: 15px;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body class="bg-light">

<div class="container my-5">

    <div class="row g-3 align-items-center mb-4">
        <div class="col-md-3 text-center">
            <img src="/static/images/img.png" alt="Аватар" class="avatar shadow">
        </div>

        <div class="col-md-3">
            <h4 class="name">Иванов Иван</h4>
            <p>Возраст: 30 лет</p>
            <a href="/profile/edit" class="btn btn-success">Редактировать</a>
        </div>

        <div class="col-md-6">
            <div class="button-group">
                <a href="/resume/create" class="btn btn-outline-danger createResume">
                    <i class="bi bi-plus-lg"></i> Создать резюме
                </a>
                <a href="/responses" class="btn btn-outline-secondary createResume">
                    Отклики
                    <span class="badge bg-danger rounded-pill notification-badge">5</span>
                </a>
            </div>
        </div>
    </div>

    <hr>

    <h3>Резюме </h3>
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <div class="col">
            <div class="card shadow-sm rounded-4">
                <div class="card-body">
                    <h5 class="card-title">Резюме 1</h5>
                    <p class="card-text text-muted">Обновлено: 2025-04-10</p>
                    <div class="d-flex gap-2">
                        <a href="/resume/update/1" class="btn btn-primary">Обновить</a>
                        <a href="/resume/edit/1" class="btn btn-success">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
</div>

</div>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>