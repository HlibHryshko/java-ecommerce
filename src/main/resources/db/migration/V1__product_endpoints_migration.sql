CREATE TABLE product
(
    id         BINARY(16)   NOT NULL,
    name       VARCHAR(255) NOT NULL,
    price      DOUBLE       NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime     NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);
