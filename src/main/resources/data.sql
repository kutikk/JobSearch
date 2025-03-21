CREATE TABLE IF NOT EXISTS categories
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    parentId INT          NULL,
    CONSTRAINT fk_parentId FOREIGN KEY (parentId) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50),
    email       VARCHAR(50) UNIQUE,
    password    VARCHAR(50),
    phoneNumber VARCHAR(20),
    avatar      VARCHAR(50),
    age         INT,
    accountType VARCHAR(30),
    resumeId    INT NULL,
    CONSTRAINT fk_resumeId FOREIGN KEY (resumeId) REFERENCES resumes (id)
);

CREATE TABLE IF NOT EXISTS resumes
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    category_id  INT          NULL,
    salary       FLOAT        NOT NULL,
    is_active    BOOLEAN   DEFAULT TRUE,
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    applicant_id INT          NULL,
    CONSTRAINT fk_applicant_id FOREIGN KEY (applicant_id) REFERENCES users (id),
    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS vacancies
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  TEXT,
    category_id  INT          NULL,
    salary       FLOAT,
    exp_from     INT,
    exp_to       INT,
    is_active    BOOLEAN   DEFAULT TRUE,
    author_id    INT          NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES users (id),
    CONSTRAINT fk_vacancies_category_id FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS responded_applicants
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    resume_id    INT NOT NULL,
    vacancy_id   INT NOT NULL,
    confirmation BOOLEAN,
    FOREIGN KEY (resume_id) REFERENCES resumes (id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancies (id)
);
DELETE FROM responded_applicants
WHERE resume_id BETWEEN 58 AND 61;

--Поздно понял что нужно было удалить INSERT INTO после одного раза, из-за этого много записей на базе.


