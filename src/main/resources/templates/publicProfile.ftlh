<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль компании</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJ1QYzP0qV3T7Gb0pFfRppbGTfReetmvvRlD5rQ68D1Ri5/kO9N5j/F6tD/6" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4 text-primary">Профиль компании: <span class="text-dark">${profile.user_name}</span></h1>
    <div class="row justify-content-center">
        <div class="col-md-4 mb-4 text-center">
            <#if profile.avatar??>
                <img src="/uploads/${profile.avatar}" alt="Аватар" class="img-fluid rounded-circle shadow-lg" style="max-width: 200px; max-height: 200px; object-fit: cover;" />
            <#else>
                <img src="/uploads/default-avatar.png" alt="Аватар" class="img-fluid rounded-circle shadow-lg" style="max-width: 200px; max-height: 200px; object-fit: cover;" />
            </#if>
        </div>
        <div class="col-md-8">
            <div class="card shadow-sm border-light rounded">
                <div class="card-body">
                    <h5 class="card-title text-center">Информация о компании</h5>
                    <p><strong>Email:</strong> <span class="text-muted">${profile.email}</span></p>
                    <p><strong>Телефон:</strong> <span class="text-muted">${profile.phone_number}</span></p>
                    <p><strong>Возраст:</strong> <span class="text-muted">${profile.age}</span></p>
                    <p><strong>Тип аккаунта:</strong> <span class="text-muted">${profile.account_type}</span></p>
                </div>
            </div>
        </div>
    </div>
    <div class="text-center mt-4">
        <a href="/vacancies" class="btn btn-primary">На главную</a>
    </div>
</div>
</body>
</html>
