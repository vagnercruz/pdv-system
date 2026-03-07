CREATE TABLE pdv.categories (

    id UUID PRIMARY KEY,

    name VARCHAR(120) NOT NULL,

    description VARCHAR(255),

    active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL

);