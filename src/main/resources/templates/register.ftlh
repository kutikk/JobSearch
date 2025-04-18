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
                    <form action="/auth/register" method="post" enctype="multipart/form-data" autocomplete="off">
                        <div class="mb-3">
                            <label for="name" class="form-label">Имя</label>
                            <input type="text" class="form-control" id="name" name="user_name" autocomplete="off" value="${user.user_name!}">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("user_name")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("user_name") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Почта</label>
                            <input type="email" class="form-control" id="email" name="email" autocomplete="off" value="${user.email!}">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("email")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("email") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Пароль</label>
                            <input type="password" class="form-control" id="password" name="password" autocomplete="new-password">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("password")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("password") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Телефон</label>
                            <input type="tel" class="form-control" id="phone" name="phone_number" value="${user.phone_number!}">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("phone_number")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("phone_number") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label for="avatar" class="form-label">Аватар</label>
                            <input type="file" class="form-control" id="avatar" name="avatarFile">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("avatarFile")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("avatarFile") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label for="age" class="form-label">Возраст</label>
                            <input type="number" class="form-control" id="age" name="age" value="${user.age!}">
                            <#if bindingResult?? && bindingResult.hasFieldErrors("age")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("age") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Тип аккаунта</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="account_type" id="employer" value="employer"
                                       <#if user.account_type?? && user.account_type == "employer">checked</#if>>
                                <label class="form-check-label" for="employer">Работодатель</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="account_type" id="applicant" value="applicant"
                                       <#if user.account_type?? && user.account_type == "applicant">checked</#if>>
                                <label class="form-check-label" for="applicant">Соискатель</label>
                            </div>
                            <#if bindingResult?? && bindingResult.hasFieldErrors("account_type")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("account_type") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
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
