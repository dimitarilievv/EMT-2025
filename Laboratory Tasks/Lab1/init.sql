CREATE TYPE role_enum AS ENUM ('ROLE_USER', 'ROLE_HOST');
CREATE TYPE book_copy_condition_enum AS ENUM ('GOOD', 'BAD');
CREATE TYPE category_book_enum
AS ENUM ('NOVEL', 'THRILER', 'HISTORY', 'FANTASY', 'BIOGRAPHY', 'CLASSICS', 'DRAMA');

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
    country_id BIGINT,
    CONSTRAINT fk_author_country
        FOREIGN KEY (country_id)
            REFERENCES country (id)
);


CREATE TABLE book
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255)       NOT NULL,
    category  category_book_enum NOT NULL,
    author_id BIGINT,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author (id)
);

CREATE TABLE book_copy
(
    id        SERIAL PRIMARY KEY,
    isRented  BOOLEAN,
    condition book_copy_condition_enum NOT NULL,
    book_id   BIGINT,
    CONSTRAINT fk_book_copy_book FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE book_users
(
    username                   VARCHAR(255) PRIMARY KEY,
    password                   VARCHAR(255) NOT NULL,
    name                       VARCHAR(255) NOT NULL,
    surname                    VARCHAR(255) NOT NULL,
    is_account_non_expired     BOOLEAN DEFAULT TRUE,
    is_account_non_locked      BOOLEAN DEFAULT TRUE,
    is_credentials_non_expired BOOLEAN DEFAULT TRUE,
    is_enabled                 BOOLEAN DEFAULT TRUE,
    role                       role_enum    NOT NULL
);
CREATE TABLE user_wishlist_books
(
    book_users_username VARCHAR(255) NOT NULL,
    book_id             BIGINT       NOT NULL,
    PRIMARY KEY (book_users_username, book_id),
    CONSTRAINT fk_user_wishlist FOREIGN KEY (book_users_username) REFERENCES book_users (username),
    CONSTRAINT fk_book_wishlist FOREIGN KEY (book_id) REFERENCES book (id)
);
CREATE TABLE book_history
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255)       NOT NULL,
    category  category_book_enum NOT NULL,
    author_id BIGINT,
    CONSTRAINT fk_book_history_author FOREIGN KEY (author_id) REFERENCES author (id)
);
