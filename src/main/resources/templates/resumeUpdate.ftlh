<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание резюме</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        .form-section {
            position: relative;
            padding-right: 50px;
            margin-bottom: 20px;
        }
        .btn-add {
            position: absolute;
            right: 0;
            top: 50%;
            transform: translateY(-50%);
            width: 40px;
            height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .social-icon {
            width: 40px;
            text-align: center;
            color: #6c757d;
        }
        .card-form {
            border: 1px solid #dee2e6;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
            background: #fff;
        }
        .card-form h3 {
            margin-bottom: 20px;
            font-size: 1.2rem;
            color: #495057;
        }
        .contact-column {
            padding: 0 10px;
        }
        .contact-item {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .contact-item .form-control {
            flex-grow: 1;
            margin-right: 10px;
        }
        .main-form-container {
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <div class="card shadow rounded-4">
                <div class="card-body p-4">
                    <h2 class="text-center mb-4">Создание резюме</h2>
                    <form action="/resumes/edit/${resume.id}" method="post">
                        <!-- CSRF -->
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                   value="${(_csrf.token)!'csrf-token'}"/>
                        </#if>
                        <div class="mb-4">
                            <div class="form-group mb-3">
                                <label for="resumeTitle" class="form-label">Название резюме</label>
                                <input type="text" class="form-control" id="resumeTitle" name="name" value="${resume.name}" required>
                            </div>

                            <div class="form-group mb-3">
                                <label for="category" class="form-label">Категория</label>
                                <select class="form-select" id="category" name="categoryId" required>
                                    <option value="">Выберите категорию</option>
                                    <option value="Разработка ПО">Разработка ПО</option>
                                    <option value="Дизайн">Дизайн</option>
                                    <option value="Строительство">Строительство</option>
                                    <option value="Менеджмент">Менеджмент</option>
                                    <option value="Услуги">Услуги</option>
                                </select>
                            </div>


                            <div class="form-group mb-3">
                                <label for="expectedSalary" class="form-label">Ожидаемый уровень оклада</label>
                                <input type="number" class="form-control" id="expectedSalary" value="${resume.salary}" name="salary"  min="0" required>
                            </div>

                        </div>
                        <h5>О себе</h5>
                        <div class="form-section">
                            <div class="card-form">
                                <h3>Опыт работы</h3>
                                <div class="form-group mb-3">
                                    <label for="workYear" class="form-label">Год работы</label>
                                    <input type="number" class="form-control" id="workYear"  name="work_experience_info[0].years" >
                                </div>

                                <div class="form-group mb-3">
                                    <label for="companyName" class="form-label">Название компании</label>
                                    <input type="text" class="form-control" id="companyName"  name="work_experience_info[0].company_name" >
                                </div>

                                <div class="form-group mb-3">
                                    <label for="position" class="form-label">Должность</label>
                                    <input type="text" class="form-control" id="position"  name="work_experience_info[0].position" >
                                </div>

                                <div class="form-group">
                                    <label for="duties" class="form-label">Обязанности</label>
                                    <textarea class="form-control" id="duties"  name="work_experience_info[0].responsibilities" rows="3" ></textarea>
                                </div>
                            </div>
                            <button type="button" class="btn btn-outline-primary btn-add">+</button>
                        </div>

                        <div class="form-section">
                            <div class="card-form">
                                <h3>Образование</h3>
                                <div class="form-group mb-3">
                                    <label for="education" class="form-label">Образование</label>
                                    <input type="text" class="form-control" id="education"  name="education_info[0].institution" >
                                </div>

                                <div class="form-group mb-3">
                                    <label for="educationInstitution" class="form-label">Где учился</label>
                                    <input type="text" class="form-control" id="educationInstitution" name="education_info[0].program" >
                                </div>

                                <div class="form-group mb-3">
                                    <label for="start_date" class="form-label">Дата начала</label>
                                    <input type="date" class="form-control" id="start_date"  name="education_info[0].start_date" placeholder="ГГГГ-ММ-ДД">
                                </div>

                                <div class="form-group mb-3">
                                    <label for="end_date" class="form-label">Дата окончания</label>
                                    <input type="date" class="form-control" id="end_date"   name="education_info[0].end_date" placeholder="ГГГГ-ММ-ДД">
                                </div>
                            </div>
                            <button type="button" class="btn btn-outline-primary btn-add">+</button>
                        </div>

                        <div class="mb-4">
                            <h3 class="mb-3">Контакты</h3>
                            <div class="row">
                                <div class="col-md-6 contact-column">
                                    <div class="contact-item">
                                        <input type="email" class="form-control" placeholder="Email" value="example@mail.com">
                                        <div class="social-icon"><i class="fas fa-envelope"></i></div>
                                    </div>

                                    <div class="contact-item">
                                        <input type="text" class="form-control" placeholder="Телеграм" value="@username">
                                        <div class="social-icon"><i class="fab fa-telegram-plane"></i></div>
                                    </div>
                                    <div class="contact-item">
                                        <input type="tel" class="form-control" placeholder="Телефон" value="+996 999 555 555">
                                        <div class="social-icon"><i class="fas fa-phone"></i></div>
                                    </div>
                                </div>

                                <div class="col-md-6 contact-column">
                                    <div class="contact-item">
                                        <input type="url" class="form-control" placeholder="Facebook">
                                        <div class="social-icon"><i class="fab fa-facebook-f"></i></div>
                                    </div>

                                    <div class="contact-item">
                                        <input type="url" class="form-control" placeholder="LinkedIn">
                                        <div class="social-icon"><i class="fab fa-linkedin-in"></i></div>
                                    </div>


                                </div>
                            </div>
                        </div>

                        <input type="hidden" id="isActive" name="is_active" value="true">

                        <div class="mb-4">
                            <button type="button" class="btn btn-success" id="activeBtn" data-value="true">Активно</button>
                            <button type="button" class="btn btn-danger" id="inactiveBtn" data-value="false">Неактивно</button>
                        </div>

                        <button type="submit" class="btn btn-primary w-100 py-2">Опубликовать</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>