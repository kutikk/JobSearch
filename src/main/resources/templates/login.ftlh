<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <h3 class="text-center mb-4">Вход в аккаунт</h3>
            <#if message??>
                <div class="alert alert-danger">${message}</div>
            </#if>
            <form action="/login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Имя</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">Войти</button>
                <a href="auth/register">Зарегистрироваться</a>

            </form>
        </div>
    </div>
</div>

</body>
</html>
