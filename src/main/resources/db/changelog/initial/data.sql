INSERT INTO users (user_name, email, password, phone_number, avatar, age, account_type)
VALUES
    ('Gitler', 'employer@example.com', 'employerpassword', '1234567890', 'employer_avatar.jpg', 35, 'employer'),
    ('Puma', 'applicant@example.com', 'applicantpassword', '0987654321', 'applicant_avatar.jpg', 28, 'applicant');


INSERT INTO resumes (name, salary, is_active,  applicant_id, category_id)
VALUES
    ('Java Разработчик', 1000.0, TRUE,  2, 1),
    ('Java_Backend_разработчик', 1200.0, TRUE,  2, 2);




INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id)
VALUES
    ('Вакансия Java Разработчика', 'Ищем опытного Java разработчика для нашей команды.',
     1, 1000.0, 2, 5, TRUE, 1),

    ('Вакансия Data Scientist', 'Ищем Data Scientist с опытом работы в машинном обучении.',
     2, 1200.0, 3, 6, TRUE, 1);


INSERT INTO categories (name, parent_id)
VALUES
    ('Разработка ПО', NULL),
    ('Дизайн', NULL),
    ('Java Разработчик', 1),
    ('UI/UX Дизайнер', 2);
