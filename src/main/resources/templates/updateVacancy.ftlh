<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактирование вакансии</title>
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
                <h2 class="text-center mb-4">Редактирование вакансии</h2>

                <form action="/vacancies/update/${vacancy.id}" method="post">
                    <!-- CSRF -->
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>
                    <input type="hidden" name="id" value="${vacancy.id}"/>

                    <div class="form-section">
                        <label class="form-label">Название вакансии</label>
                        <input type="text" class="form-control" name="name" value="${vacancy.name}" required>
                    </div>

                    <div class="form-section">
                        <label class="form-label">Категория</label>
                        <select class="form-select" name="category_id" required>
                            <option value="">Выберите категорию</option>
                            <option value="1" >Разработка ПО</option>
                            <option value="2" >Java Разработчик</option>
                            <option value="3" >UI/UX Дизайнер</option>
                            <option value="4" >Финансы</option>
                        </select>
                    </div>

                    <div class="form-section">
                        <label class="form-label">Заработная плата</label>
                        <input type="number" class="form-control" name="salary" value="${vacancy.salary}" required>
                    </div>

                    <div class="form-section">
                        <label class="form-label">Описание вакансии</label>
                        <textarea class="form-control" name="description" rows="6" required>${vacancy.description}</textarea>
                    </div>

                    <div class="form-section">
                        <label class="form-label">Требуемый опыт</label>
                        <div class="experience-range">
                            <input type="number" class="form-control" name="exp_from" value="${vacancy.exp_from}" placeholder="От (лет)">
                            <input type="number" class="form-control" name="exp_to" value="${vacancy.exp_to}" placeholder="До (лет)">
                        </div>
                    </div>

                    <div class="form-section">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" name="is_active" id="isActive">
                            <label class="form-check-label" for="isActive">Активна</label>
                        </div>
                    </div>

                    <div class="form-section">
                        <button type="submit" class="btn btn-success w-100 py-2">Сохранить изменения</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
