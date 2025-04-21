<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <style>
        .avatar {
            width: 270px;
            height: 270px;
            object-fit: cover;
            border-radius: 50%;
            border: 5px solid #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .notification-badge {
            position: absolute;
            top: -5px;
            right: -5px;
            transform: translate(50%, -50%);
            font-size: 0.8rem;
        }

        .name {
            margin-top: 10px;
            font-weight: 600;
            font-size: 1.25rem;
        }

        .createResume {
            width: 170px;
            height: 170px;
            font-size: 1.1rem;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 15px;
            transition: transform 0.3s ease;
        }

        .createResume:hover {
            transform: translateY(-5px);
        }

        .button-group {
            display: flex;
            gap: 15px;
            align-items: center;
            justify-content: center;
            margin-top: 15px;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-body {
            padding: 1.5rem;
        }

        .card-title {
            font-weight: 600;
            font-size: 1.2rem;
        }

        .card-text {
            font-size: 0.9rem;
        }
    </style>
</head>
<body class="bg-light">

<div class="container my-5">

    <div class="row g-3 align-items-center mb-4">
        <div class="col-md-3 text-center">
            <#if profile.avatar??>
                <img src="/uploads/${profile.avatar}" alt="Аватар" class="avatar shadow-lg">
            </#if>
        </div>

        <div class="col-md-3">
            <h4 class="name">${profile.user_name}</h4>
            <p>Возраст: ${profile.age} лет</p>
            <a href="/profile/update" class="btn btn-success">Редактировать</a>
        </div>

        <div class="col-md-6">
            <div class="button-group">
                <#if profile.account_type == "APPLICANT">
                    <a href="/resumes/new" class="btn btn-outline-danger createResume">
                        <i class="bi bi-plus-lg"></i> Создать резюме
                    </a>
                    <a href="/responses" class="btn btn-outline-secondary position-relative createResume">
                        Отклики
                        <span class="badge bg-danger rounded-pill notification-badge">5</span>
                    </a>
                <#elseif profile.account_type == "EMPLOYER">
                    <a href="/vacancies/new" class="btn btn-outline-primary createResume">
                        <i class="bi bi-plus-lg"></i> Создать вакансию
                    </a>
                </#if>
                <#if profile.account_type == "EMPLOYER">
                <a href="/resumes" class="btn btn-outline-primary createResume">
                    <i class="bi bi-list"></i> Посмотреть активные резюме
                </a>
                </#if>
            </div>
        </div>
    </div>

    <hr>
    <#if profile.account_type == "APPLICANT">
        <h3>Мои резюме</h3>
        <#if profile.resumes?? && profile.resumes.content?has_content>

            <#list profile.resumes.content as resume>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${resume.name}</h5>
                        <p class="card-text text-muted">Обновлено: ${resume.update_time}</p>
                        <a href="/resume/update/${resume.id}" class="btn btn-primary">Обновить</a>
                        <a href="/resumes/edit/${resume.id}" class="btn btn-success">Редактировать</a>
                    </div>
                </div>
            </#list>

            <div class="d-flex justify-content-between align-items-center mt-3">
                <div class="text-muted">
                    Страница ${currentPage + 1} из ${profile.resumes.totalPages}
                </div>
                <div class="btn-group">
                    <#if currentPage gt 0>
                        <a href="/profile?page=${currentPage - 1}&size=${pageSize}" class="btn btn-outline-primary">
                            <i class="bi bi-arrow-left"></i> Назад
                        </a>
                    </#if>
                    <#if (currentPage + 1) lt profile.resumes.totalPages>
                        <a href="/profile?page=${currentPage + 1}&size=${pageSize}" class="btn btn-outline-primary">
                            Вперёд <i class="bi bi-arrow-right"></i>
                        </a>
                    </#if>
                </div>
            </div>
        <#else>
            <p>У вас пока нет резюме.</p>
        </#if>
    </#if>

    <#if profile.account_type == "EMPLOYER">
        <h3>Мои вакансии</h3>
        <#if profile.vacancies?? && profile.vacancies.content?has_content>
            <#list profile.vacancies.content as vacancy>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${vacancy.name}</h5>
                        <p class="card-text text-muted">Опубликовано: ${vacancy.created_date}</p>
                        <a href="/vacancies/update/${vacancy.id}" class="btn btn-success">Редактировать</a>
                    </div>
                </div>
            </#list>

            <div class="d-flex justify-content-between align-items-center mt-3">
                <div class="text-muted">
                    Страница ${currentPage + 1} из ${profile.vacancies.totalPages}
                </div>
                <div class="btn-group">
                    <#if currentPage gt 0>
                        <a href="/profile?page=${currentPage - 1}&size=${pageSize}" class="btn btn-outline-primary">
                            <i class="bi bi-arrow-left"></i> Назад
                        </a>
                    </#if>
                    <#if (currentPage + 1) lt profile.vacancies.totalPages>
                        <a href="/profile?page=${currentPage + 1}&size=${pageSize}" class="btn btn-outline-primary">
                            Вперёд <i class="bi bi-arrow-right"></i>
                        </a>
                    </#if>
                </div>
            </div>
        <#else>
            <p>У вас пока нет вакансий.</p>
        </#if>
    </#if>



</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
