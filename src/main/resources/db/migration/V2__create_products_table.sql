CREATE TABLE
    products (
        id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        uuid uuid NOT NULL DEFAULT gen_random_uuid (),
        store_id bigint NOT NULL,
        name varchar(255) NOT NULL,
        price int NOT NULL,
        description text NULL,
        created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        deleted_at timestamp NULL,
        FOREIGN KEY (store_id) REFERENCES stores (id) ON DELETE CASCADE
    );