<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль компании</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .profile-card {
            transition: transform 0.3s ease;
            border-radius: 15px;
            overflow: hidden;
        }
        .profile-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
        .avatar-container {
            position: relative;
            margin-bottom: 20px;
        }
        .avatar-shadow {
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        .info-label {
            font-weight: 600;
            color: #495057;
        }
        .info-value {
            color: #6c757d;
        }
        .btn-home {
            padding: 8px 20px;
            border-radius: 50px;
            font-weight: 500;
            transition: all 0.3s;
        }
        .btn-home:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <h1 class="text-center mb-4 text-primary fw-bold">Профиль компании</h1>

            <div class="card profile-card mb-5 border-0">
                <div class="card-body p-4">
                    <div class="row align-items-center">
                        <div class="col-md-4 text-center">
                            <div class="avatar-container">
                                <#if profile.avatar??>
                                    <img src="/uploads/${profile.avatar}" alt="Аватар" class="img-fluid rounded-circle avatar-shadow" style="width: 180px; height: 180px; object-fit: cover;">
                                <#else>
                                    <img src="/uploads/default-avatar.png" alt="Аватар" class="img-fluid rounded-circle avatar-shadow" style="width: 180px; height: 180px; object-fit: cover;">
                                </#if>
                            </div>
                            <h3 class="mt-3 mb-0">${profile.user_name}</h3>
                            <p class="text-muted">${profile.account_type}</p>
                        </div>
                        <div class="col-md-8">
                            <div class="px-md-4">
                                <h4 class="mb-4 text-center text-secondary">Контактная информация</h4>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <p class="info-label">Email:</p>
                                        <p class="info-value">${profile.email}</p>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <p class="info-label">Телефон:</p>
                                        <p class="info-value">${profile.phone_number}</p>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <p class="info-label">Возраст компании:</p>
                                        <p class="info-value">${profile.age} лет</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="text-center">
                <a href="/home" class="btn btn-primary btn-home">
                    <i class="bi bi-house-door"></i> Домой
                </a>
                <a href="/vacancies" class="btn btn-outline-primary btn-home ms-2">
                    Вакансии
                </a>
            </div>
        </div>
    </div>
</div>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>