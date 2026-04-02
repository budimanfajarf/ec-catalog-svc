CREATE TABLE
    stores (
        id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        uuid uuid NOT NULL DEFAULT gen_random_uuid (),
        name varchar(255) NOT NULL,
        address text NULL,
        created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        deleted_at timestamp NULL
    );