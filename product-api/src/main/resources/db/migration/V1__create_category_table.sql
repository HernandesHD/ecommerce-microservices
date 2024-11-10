CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE products.category {
    id bigserial primary key,
    nome_category varchar(100) not null
}