CREATE TABLE country
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    continent VARCHAR(255) NOT NULL
);

CREATE TABLE author
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    country_id INT REFERENCES country (id)
);

CREATE TABLE book
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    category  VARCHAR(50)  NOT NULL,
    author_id INT REFERENCES author (id)
);

CREATE TABLE book_history
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    category  VARCHAR(50)  NOT NULL,
    author_id INT REFERENCES author (id)
);

CREATE TABLE book_copy
(
    id        SERIAL PRIMARY KEY,
    is_rented BOOLEAN DEFAULT FALSE,
    condition VARCHAR(50),
    book_id   INT REFERENCES book (id)
);

CREATE TABLE shop_users
(
    username                   VARCHAR(255) PRIMARY KEY,
    password                   VARCHAR(255) NOT NULL,
    name                       VARCHAR(255) NOT NULL,
    surname                    VARCHAR(255) NOT NULL,
    is_account_non_expired     BOOLEAN DEFAULT TRUE,
    is_account_non_locked      BOOLEAN DEFAULT TRUE,
    is_credentials_non_expired BOOLEAN DEFAULT TRUE,
    is_enabled                 BOOLEAN DEFAULT TRUE,
    role                       VARCHAR(50)  NOT NULL
);

CREATE TABLE shop_users_wish_list_books
(
    shop_users_username VARCHAR(255) REFERENCES shop_users (username),
    wish_list_books_id  INT REFERENCES book (id),
    PRIMARY KEY (shop_users_username, wish_list_books_id)
);
