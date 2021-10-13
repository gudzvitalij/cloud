CREATE TABLE payments
(
    id       BIGSERIAL PRIMARY KEY,
    "sender_Id" BIGINT NOT NULL,
    amount   BIGINT NOT NULL,
    comment  TEXT   NOT NULL,
    card_number VARCHAR (19) NOT NULL
);