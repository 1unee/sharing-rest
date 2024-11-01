-- Таблица и последовательность для location_type
CREATE SEQUENCE IF NOT EXISTS dictionary.location_type_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS dictionary.location_type (
    id INT8 NOT NULL DEFAULT nextval('dictionary.location_type_id_seq'),
    value VARCHAR(128) NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id)
);

COMMENT ON TABLE dictionary.location_type IS 'Типы местоположений (например, общежитие или дом)';
COMMENT ON COLUMN dictionary.location_type.id IS 'Уникальный идентификатор типа местоположения';
COMMENT ON COLUMN dictionary.location_type.value IS 'Название типа местоположения';
COMMENT ON COLUMN dictionary.location_type.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN dictionary.location_type.updated_at IS 'Дата и время последнего обновления записи';

-- Таблица и последовательность для location
CREATE SEQUENCE IF NOT EXISTS dictionary.location_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS dictionary.location (
    id INT8 NOT NULL DEFAULT nextval('dictionary.location_id_seq'),
    location_type_id INT8 NOT NULL,
    street VARCHAR(128) NOT NULL,
    building VARCHAR(8) NOT NULL,
    part VARCHAR(8),
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_location_type
        FOREIGN KEY (location_type_id)
            REFERENCES dictionary.location_type (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE dictionary.location IS 'Местоположения с информацией о типе, улице и строении';
COMMENT ON COLUMN dictionary.location.id IS 'Уникальный идентификатор местоположения';
COMMENT ON COLUMN dictionary.location.location_type_id IS 'Ссылка на тип местоположения';
COMMENT ON COLUMN dictionary.location.street IS 'Название улицы местоположения';
COMMENT ON COLUMN dictionary.location.building IS 'Номер здания';
COMMENT ON COLUMN dictionary.location.part IS 'Корпус или часть здания';
COMMENT ON COLUMN dictionary.location.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN dictionary.location.updated_at IS 'Дата и время последнего обновления записи';

-- Таблица и последовательность для thing_category
CREATE SEQUENCE IF NOT EXISTS dictionary.thing_category_id_sec
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS dictionary.thing_category (
    id INT8 NOT NULL DEFAULT nextval('dictionary.thing_category_id_sec'),
    value VARCHAR(128) NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id)
);

COMMENT ON TABLE dictionary.thing_category IS 'Категории для предметов, доступных к обмену или продаже';
COMMENT ON COLUMN dictionary.thing_category.id IS 'Уникальный идентификатор категории';
COMMENT ON COLUMN dictionary.thing_category.value IS 'Название категории';
COMMENT ON COLUMN dictionary.thing_category.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN dictionary.thing_category.updated_at IS 'Дата и время последнего обновления записи';

-- Таблица и последовательность для post_status
CREATE SEQUENCE IF NOT EXISTS dictionary.post_status_id_sec
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS dictionary.post_status (
    id INT8 NOT NULL DEFAULT nextval('dictionary.post_status_id_sec'),
    value VARCHAR(128) NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id)
);

COMMENT ON TABLE dictionary.post_status IS 'Статусы постов, указывающие на их состояние (например, активный, завершенный)';
COMMENT ON COLUMN dictionary.post_status.id IS 'Уникальный идентификатор статуса поста';
COMMENT ON COLUMN dictionary.post_status.value IS 'Название статуса поста';
COMMENT ON COLUMN dictionary.post_status.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN dictionary.post_status.updated_at IS 'Дата и время последнего обновления записи';

-- Таблица и последовательность для payment_status
CREATE SEQUENCE IF NOT EXISTS dictionary.payment_status_id_sec
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS dictionary.payment_status (
    id INT8 NOT NULL DEFAULT nextval('dictionary.payment_status_id_sec'),
    value VARCHAR(128) NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id)
);

COMMENT ON TABLE dictionary.payment_status IS 'Статусы оплаты (например, успешная, отклонена)';
COMMENT ON COLUMN dictionary.payment_status.id IS 'Уникальный идентификатор статуса оплаты';
COMMENT ON COLUMN dictionary.payment_status.value IS 'Название статуса оплаты';
COMMENT ON COLUMN dictionary.payment_status.created_at IS 'Дата и время создания записи';
COMMENT ON COLUMN dictionary.payment_status.updated_at IS 'Дата и время последнего обновления записи';