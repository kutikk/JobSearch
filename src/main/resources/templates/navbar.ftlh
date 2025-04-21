
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-blue: #1a73e8;
            --dark-blue: #0d47a1;
            --light-blue: #e8f0fe;
            --accent-yellow: #fbbc05;
            --dark-text: #202124;
            --light-text: #5f6368;
        }

        body {
            font-family: 'Roboto', sans-serif;
            color: var(--dark-text);
            background-color: #f8f9fa;
        }

        .navbar {
            background-color: var(--primary-blue) !important;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            font-weight: 700;
            letter-spacing: 0.5px;
        }

        .nav-link {
            color: rgba(255, 255, 255, 0.9) !important;
            font-weight: 500;
            padding: 0.5rem 1rem;
            margin: 0 0.1rem;
            border-radius: 4px;
            transition: all 0.3s ease;
        }

        .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.15);
            color: white !important;
        }

        .btn-outline-light {
            border-color: white;
            color: white;
            font-weight: 500;
            transition: all 0.3s ease;
        }

        .btn-outline-light:hover {
            background-color: white;
            color: var(--primary-blue);
            transform: translateY(-1px);
        }

        .btn-warning {
            background-color: var(--accent-yellow);
            color: var(--dark-text);
            font-weight: 500;
            border: none;
            transition: all 0.3s ease;
        }

        .btn-warning:hover {
            background-color: #f9ab00;
            transform: translateY(-1px);
            box-shadow: 0 2px 8px rgba(251, 188, 5, 0.3);
        }

        .navbar-text {
            color: rgba(255, 255, 255, 0.9);
            font-weight: 500;
        }

        .container-fluid {
            padding-left: 2rem;
            padding-right: 2rem;
        }

        @media (max-width: 992px) {
            .navbar-nav {
                padding-top: 1rem;
            }

            .nav-link {
                margin: 0.2rem 0;
            }

            .navbar-nav .btn {
                margin-top: 0.5rem;
                width: 100%;
            }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark shadow-sm mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">JobSearch</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav me-auto">
                <a class="nav-link" href="/">Главная</a>
                <a class="nav-link" href="/about">О нас</a>

                <#if profile?? && profile.account_type == "EMPLOYER">
                    <a class="nav-link" href="/profile">Профиль</a>
                    <a class="nav-link" href="/resumes">Резюме</a>
                    <a class="nav-link" href="/applicant/applications">Отклики</a>
                </#if>

                <#if profile?? && profile.account_type == "APPLICANT">
                    <a class="nav-link" href="/profile">Профиль</a>
                    <a class="nav-link" href="/vacancies">Вакансии</a>
                    <a class="nav-link" href="/applicant/applications">Отклики</a>
                </#if>
            </div>

            <div class="navbar-nav">
                <#if profile??>
                    <span class="navbar-text me-3">
                        Здравствуйте, <strong>${profile.user_name}</strong>!
                    </span>
                    <a class="btn btn-outline-light" href="/login">Выйти</a>
                <#else>
                    <a class="btn btn-outline-light me-2" href="/login">Войти</a>
                    <a class="btn btn-warning" href="/auth/register">Регистрация</a>
                </#if>
            </div>
        </div>
    </div>
</nav>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

