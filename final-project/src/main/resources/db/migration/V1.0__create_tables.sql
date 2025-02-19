DROP TABLE IF EXISTS orders_table;
DROP TABLE IF EXISTS cars_table;
DROP TABLE IF EXISTS users_table;

CREATE TABLE users_table
(
    user_id BIGSERIAL PRIMARY KEY ,
    user_name VARCHAR(100),
    user_email VARCHAR(100) NOT NULL UNIQUE,
    user_password VARCHAR(100) NOT NULL ,
    user_address VARCHAR(255) NOT NULL ,
    user_blocked BOOLEAN DEFAULT FALSE,
    user_role VARCHAR(50)
);

CREATE TABLE cars_table
(
    car_id BIGSERIAL PRIMARY KEY ,
    car_model VARCHAR(50),
    car_release_year VARCHAR(50),
    car_color VARCHAR(50),
    car_company VARCHAR(50)
);

CREATE TABLE orders_table
(
    order_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users_table(user_id),
    car_id BIGINT REFERENCES cars_table(car_id),
    order_date DATE,
    return_date DATE,
    car_returned BOOLEAN DEFAULT FALSE,
    rental_cost NUMERIC(7,2)
);