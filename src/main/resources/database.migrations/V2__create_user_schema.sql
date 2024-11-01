-- Таблица и последовательность для location_info
CREATE SEQUENCE IF NOT EXISTS "user".location_info_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS "user".location_info (
    id INT8 NOT NULL DEFAULT nextval('"user".location_info_id_seq'),
    location_id INT8 NOT NULL,
    porch VARCHAR(16) NOT NULL,
    porch_code VARCHAR(64),
    floor VARCHAR(8) NOT NULL,
    flat VARCHAR(8) NOT NULL,
    description VARCHAR(256),
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_location
        FOREIGN KEY (location_id)
            REFERENCES dictionary.location (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE "user".location_info IS 'Информация о местоположении пользователя';
COMMENT ON COLUMN "user".location_info.id IS 'Уникальный идентификатор информации о местоположении';
COMMENT ON COLUMN "user".location_info.location_id IS 'Ссылка на идентификатор местоположения';
COMMENT ON COLUMN "user".location_info.porch IS 'Подъезд';
COMMENT ON COLUMN "user".location_info.porch_code IS 'Код домофона';
COMMENT ON COLUMN "user".location_info.floor IS 'Этаж';
COMMENT ON COLUMN "user".location_info.flat IS 'Номер квартиры';
COMMENT ON COLUMN "user".location_info.description IS 'Описание местоположения';
COMMENT ON COLUMN "user".location_info.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN "user".location_info.updated_at IS 'Дата и время последнего обновления записи';

-- Таблица и последовательность для user
CREATE SEQUENCE IF NOT EXISTS "user".user_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS "user"."user" (
    id INT8 NOT NULL DEFAULT nextval('"user".user_id_seq'),
    username VARCHAR(255) UNIQUE,
    rating DECIMAL(3, 2) DEFAULT 0,
    telegram_id INT8,
    telegram_chat_id INT8,
    location_info_id INT8 NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_location_info
        FOREIGN KEY (location_info_id)
            REFERENCES "user".location_info (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE "user"."user" IS 'Информация о пользователях, зарегистрированных в системе';
COMMENT ON COLUMN "user"."user".id IS 'Уникальный идентификатор пользователя';
COMMENT ON COLUMN "user"."user".username IS 'Имя пользователя в системе (уникальное)';
COMMENT ON COLUMN "user"."user".telegram_id IS 'Telegram ID пользователя';
COMMENT ON COLUMN "user"."user".telegram_chat_id IS 'Идентификатор чата пользователя в Telegram';
COMMENT ON COLUMN "user"."user".location_info_id IS 'ID адресной информации пользователя';
COMMENT ON COLUMN "user"."user".created_at IS 'Дата и время создания записи пользователя';
COMMENT ON COLUMN "user"."user".updated_at IS 'Дата и время последнего обновления информации о пользователе';
