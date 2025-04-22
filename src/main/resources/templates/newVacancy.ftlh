<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание вакансии</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .vacancy-form {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        .experience-range {
            display: flex;
            gap: 15px;
        }
        .experience-range .form-group {
            flex: 1;
        }
        .form-section {
            margin-bottom: 25px;
        }
    </style>
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <div class="vacancy-form">
                <h2 class="text-center mb-4">Создание вакансии</h2>
                <form action="/vacancies/create" method="post">
                    <div class="form-section">
                        <div class="form-group mb-3">
                            <label for="vacancyTitle" class="form-label">Название вакансии</label>
                            <input type="text" class="form-control" id="vacancyTitle" name="name" value="${vacancy.name!}" >
                            <#if bindingResult?? && bindingResult.hasFieldErrors("name")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("name") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-section">
                        <div class="form-group mb-3">
                            <label for="category" class="form-label">Категория</label>
                            <select class="form-select" id="category" name="category_id"  >
                                <option value="${vacancy.category_id!}">Выберите категорию</option>
                                <option value="1">Разработка ПО</option>
                                <option value="2">Дизайн</option>
                                <option value="3">Строительство</option>
                                <option value="4">Менеджмент</option>
                                <option value="5">Услуги</option>
                            </select>
                            <#if bindingResult?? && bindingResult.hasFieldErrors("category_id")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("category_id") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-section">
                        <div class="form-group mb-3">
                            <label for="salary" class="form-label">Заработная плата</label>
                            <input type="number" class="form-control" id="salary" name="salary" placeholder="Например: от 100 000 сом." value="${vacancy.salary!}" >
                            <#if bindingResult?? && bindingResult.hasFieldErrors("salary")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("salary") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-section">
                        <div class="form-group mb-3">
                            <label for="description" class="form-label">Описание вакансии</label>
                            <textarea class="form-control" id="description" name="description" rows="6" ></textarea>
                            <#if bindingResult?? && bindingResult.hasFieldErrors("description")>
                                <div class="text-danger">
                                    <#list bindingResult.getFieldErrors("description") as err>${err.defaultMessage}<br></#list>
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-section">
                        <label class="form-label">Требуемый опыт</label>
                        <div class="experience-range">
                            <div class="form-group">
                                <input type="number" class="form-control" id="experienceMin" name="exp_from" placeholder="От (лет)" min="0" value="${vacancy.exp_from!}">
                                <#if bindingResult?? && bindingResult.hasFieldErrors("exp_from")>
                                    <div class="text-danger">
                                        <#list bindingResult.getFieldErrors("exp_from") as err>${err.defaultMessage}<br></#list>
                                    </div>
                                </#if>
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" id="experienceMax" name="exp_to" placeholder="До (лет)" min="0" value="${vacancy.exp_to!}">
                                <#if bindingResult?? && bindingResult.hasFieldErrors("exp_to")>
                                    <div class="text-danger">
                                        <#list bindingResult.getFieldErrors("exp_to") as err>${err.defaultMessage}<br></#list>
                                    </div>
                                </#if>
                            </div>
                        </div>
                    </div>

                    <div class="form-section">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" id="isActive" name="is_active" checked>
                            <label class="form-check-label" for="isActive">Активна</label>
                        </div>
                        <#if bindingResult?? && bindingResult.hasFieldErrors("isActive")>
                            <div class="text-danger">
                                <#list bindingResult.getFieldErrors("isActive") as err>${err.defaultMessage}<br></#list>
                            </div>
                        </#if>
                    </div>

                    <div class="form-section">
                        <button type="submit" class="btn btn-primary w-100 py-2">Опубликовать вакансию</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>