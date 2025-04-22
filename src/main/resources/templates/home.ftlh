
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Список вакансий</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">


    <#include "navbar.ftlh">

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h2 class="h4 mb-0">Список вакансий</h2>
                </div>

                <div class="card-body">
                    <#if vacancies?? && (vacancies?size > 0)>
                        <div class="list-group mb-4">
                            <#list vacancies as vacancy>
                                <div class="list-group-item">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">${vacancy.name}</h5>
                                        <small class="text-muted">ID: ${vacancy.id!''}</small>
                                    </div>
                                    <p class="mb-1">${vacancy.description!''}</p>
                                    <#if vacancy.salary??>
                                        <small class="text-success">Зарплата: ${vacancy.salary} сом</small>
                                    </#if>
                                </div>
                            </#list>
                        </div>
                    <#else>
                        <div class="alert alert-info">Нет доступных вакансий</div>
                    </#if>

                    <div class="d-flex justify-content-between align-items-center">
                        <div class="text-muted">
                            Страница ${currentPage + 1} из ${totalPages}
                        </div>

                        <div class="btn-group">
                            <#if currentPage gt 0>
                                <a href="/home?page=${currentPage - 1}&size=2" class="btn btn-outline-primary">
                                    <i class="bi bi-arrow-left"></i> Назад
                                </a>
                            </#if>

                            <#if (currentPage + 1) lt totalPages>
                                <a href="/home?page=${currentPage + 1}&size=2" class="btn btn-outline-primary">
                                    Вперёд <i class="bi bi-arrow-right"></i>
                                </a>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>