CREATE TABLE tb_user (
    id bigserial PRIMARY KEY,
    login varchar(100) NOT NULL,
    password varchar(255) NOT NULL
);
