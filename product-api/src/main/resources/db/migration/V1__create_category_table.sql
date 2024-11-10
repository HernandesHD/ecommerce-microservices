CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE products.category {
    id bigserial primary key,
    name varchar(100) not null
}