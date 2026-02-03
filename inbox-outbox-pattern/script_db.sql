create table "order" (
    id uuid primary key,
    customer varchar(100)
);

create table outbox (
    id uuid primary key,
    aggregate_type varchar(100),
    aggregate_id uuid,
    type varchar(100),
    payload text,
    published boolean
);

create table inbox (
    id uuid primary key,
    processed_at timestamp
);

create table notification (
    id uuid primary key,
    order_id uuid,
    message varchar(255),
    created_at timestamp
);
