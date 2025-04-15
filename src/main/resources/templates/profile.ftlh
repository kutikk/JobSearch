<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
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
        .name {
            margin-top: 10px;
        }
        .createResume {
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
            <#if profile.avatar??>
                <img src="/uploads/${profile.avatar}" alt="Аватар" class="avatar shadow">
            </#if>
        </div>

        <div class="col-md-3">
            <h4 class="name">${profile.user_name}</h4>
            <p>Возраст: ${profile.age} лет</p>
            <a href="/profile/update" class="btn btn-success">Редактировать</a>
        </div>

        <div class="col-md-6">
            <div class="button-group">
                <#if profile.account_type == "applicant">
                    <a href="/resumes/new" class="btn btn-outline-danger createResume">
                        <i class="bi bi-plus-lg"></i> Создать резюме
                    </a>
                    <a href="/responses" class="btn btn-outline-secondary position-relative createResume">
                        Отклики
                        <span class="badge bg-danger rounded-pill notification-badge">5</span>
                    </a>
                <#elseif profile.account_type == "employer">
                    <a href="/vacancies/new" class="btn btn-outline-primary createResume">
                        <i class="bi bi-plus-lg"></i> Создать вакансию
                    </a>
                </#if>
            </div>
        </div>
    </div>

    <hr>

    <#if profile.account_type == "applicant">
        <h3>Мои резюме</h3>
        <#if profile.resumes?? && profile.resumes?has_content>
            <#list profile.resumes as resume>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${resume.name}</h5>
                        <p class="card-text text-muted">Обновлено: ${resume.update_time}</p>
                        <a href="/resume/update/${resume.id}" class="btn btn-primary">Обновить</a>
                        <a href="/resumes/edit/${resume.id}" class="btn btn-success">Редактировать</a>
                    </div>
                </div>
            </#list>
        <#else>
            <p>У вас пока нет резюме.</p>
        </#if>

    <#elseif profile.account_type == "employer">
        <h3>Мои вакансии</h3>
        <#if profile.vacancies?? && profile.vacancies?has_content>
            <#list profile.vacancies as vacancy>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${vacancy.title}</h5>
                        <p class="card-text text-muted">Опубликовано: ${vacancy.posted_at}</p>
                        <a href="/vacancies/edit/${vacancy.id}" class="btn btn-success">Редактировать</a>
                    </div>
                </div>
            </#list>
        <#else>
            <p>У вас пока нет вакансий.</p>
        </#if>
    </#if>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
