create TABLE IF NOT EXISTS users
(
    id       BIGINT CONSTRAINT user_pk PRIMARY KEY,
    name     VARCHAR(512) NOT NULL UNIQUE,
    password VARCHAR(32)  NOT NULL
);

comment on table users is 'Users';

create sequence IF NOT EXISTS users_id_seq START with 1;

create TABLE IF NOT EXISTS events
(
    id      BIGINT PRIMARY KEY,
    name    VARCHAR(512) NOT NULL,
    date    DATE         NOT NULL,
    user_id BIGINT       NOT NULL CONSTRAINT events_users_fk REFERENCES users (id)
);

comment on table events is 'Events';

create sequence IF NOT EXISTS events_id_seq START with 1;
