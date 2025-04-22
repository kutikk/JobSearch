<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .auth-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 2rem;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .auth-title {
            color: #2c3e50;
            font-weight: 600;
            margin-bottom: 1.5rem;
        }

        .btn-primary {
            background-color: #3498db;
            border-color: #3498db;
            padding: 10px;
            font-weight: 500;
            transition: all 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #2980b9;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(41, 128, 185, 0.3);
        }

        .btn-secondary {
            background-color: #f8f9fa;
            color: #2c3e50;
            border: 1px solid #e0e0e0;
            padding: 10px;
            font-weight: 500;
            transition: all 0.3s ease;
            margin-top: 10px;
        }

        .btn-secondary:hover {
            background-color: #e9ecef;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            color: #2c3e50;
            border-color: #d0d0d0;
        }

        .auth-links {
            display: flex;
            justify-content: space-between;
            margin-top: 1.5rem;
        }

        .auth-link {
            color: #3498db;
            text-decoration: none;
            transition: color 0.2s;
        }

        .auth-link:hover {
            color: #2980b9;
            text-decoration: underline;
        }

        .form-control:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 0.25rem rgba(52, 152, 219, 0.25);
        }
    </style>
</head>
<body class="bg-light d-flex align-items-center min-vh-100">

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
            <div class="auth-container">
                <h3 class="auth-title text-center">Вход в аккаунт</h3>

                <#if message??>
                    <div class="alert alert-danger">${message}</div>
                </#if>

                <form action="/login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Имя пользователя</label>
                        <input type="text" class="form-control" id="username" name="username" required>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label">Пароль</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>

                    <button type="submit"  class="btn btn-primary w-100 mb-3" >Войти</button>

                    <div class="d-grid gap-2">
                        <a href="auth/register" class="btn btn-secondary">Зарегистрироваться</a>
                        <a href="/home" class="btn btn-secondary">Продолжить без входа</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>