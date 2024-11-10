CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE products.category {
    id bigserial primary key,
    name_category varchar(100) not null
}