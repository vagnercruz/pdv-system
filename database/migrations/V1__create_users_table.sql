CREATE TABLE pdv.users (

    id UUID PRIMARY KEY,

    name VARCHAR(120) NOT NULL,

    email VARCHAR(150) UNIQUE NOT NULL,

    password VARCHAR(255) NOT NULL,

    role VARCHAR(50) NOT NULL,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP

);