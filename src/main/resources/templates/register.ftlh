<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow rounded-4">
                <div class="card-body p-4">
                    <h2 class="text-center mb-4">Регистрация</h2>
                    <form action="/register" method="post" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="name" class="form-label">Имя</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Почта</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Пароль</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Телефон</label>
                            <input type="tel" class="form-control" id="phone" name="phone" required>
                        </div>

                        <div class="mb-3">
                            <label for="avatar" class="form-label">Аватар</label>
                            <input type="file" class="form-control" id="avatar" name="avatar">
                        </div>

                        <div class="mb-3">
                            <label for="age" class="form-label">Возраст</label>
                            <input type="number" class="form-control" id="age" name="age" min="16" max="120" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Тип аккаунта</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="accountType" id="employer" value="employer" required>
                                <label class="form-check-label" for="employer">Работодатель</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="accountType" id="jobseeker" value="jobseeker">
                                <label class="form-check-label" for="jobseeker">Соискатель</label>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Зарегистрироваться</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
