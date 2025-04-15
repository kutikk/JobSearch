INSERT INTO users (user_name, email, password, phone_number, avatar, age, account_type)
VALUES
    ('Gitler', 'employer@example.com', 'employerpassword', '1234567890', 'employer_avatar.jpg', 35, 'employer'),
    ('Puma', 'applicant@example.com', 'applicantpassword', '0987654321', 'applicant_avatar.jpg', 28, 'applicant');


INSERT INTO resumes (name, salary, is_active,  applicant_id, category_id)
VALUES
    ('Тестировщик', 1200.0, TRUE,  12, 2);
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




ALTER TABLE WORK_EXPERIENCE_INFO
    ADD CONSTRAINT WORK_EXPERIENCE_INFO
        FOREIGN KEY (resume_id)
            REFERENCES resumes(id)
            ON DELETE CASCADE;


INSERT INTO users (user_name, email, password, phone_number, avatar, age, account_type,ENABLED)
VALUES
    ('admin', 'admin@example.com', 'employerpassword', '1234567890', 'employer_avatar.jpg', 35, 'employer',true),
    ('user', 'user@example.com', 'applicantpassword', '0987654321', 'applicant_avatar.jpg', 28, 'applicant',true);


INSERT INTO authorities (authority, user_id)
VALUES
    ('ADMIN', 7),
    ('USER', 8);

INSERT INTO users (user_name, email, password, phone_number, avatar, age, account_type,ENABLED)
VALUES
    ('одмун', 'user@example.com', '$2a$12$k8afISv03WZxXFCBW34vZeNsqjSJQftpLE2JRuokfrCt/wXgJcnfG', '0987654321', 'applicant_avatar.jpg', 28, 'applicant',true);

INSERT INTO authorities (authority, user_id)
VALUES
    ('ROLE_USER', 19);

SELECT user_name, password, enabled FROM users WHERE user_name = 'adminkutman';
SELECT u.user_name, a.authority
FROM users u
         JOIN authorities a ON u.ID = a.user_id
WHERE u.user_name = 'adminkutman';

DELETE FROM authorities
WHERE user_id IN (7, 8, 10, 11);

DELETE FROM resumes WHERE id = 86;
ALTER TABLE CATEGORIES ALTER COLUMN PARENT_ID SET DATA TYPE BIGINT;
ALTER TABLE RESUMES ALTER COLUMN APPLICANT_ID SET DATA TYPE BIGINT;

TRUNCATE TABLE RESUMES;
DELETE FROM USERS;
DELETE FROM work_experience_info;

