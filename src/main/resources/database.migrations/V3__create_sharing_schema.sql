-- Таблица и последовательность для post
CREATE SEQUENCE IF NOT EXISTS sharing.post_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS sharing.post (
    id INT8 NOT NULL DEFAULT nextval('sharing.post_id_seq'),
    user_id INT8 NOT NULL,
    title VARCHAR(128) NOT NULL,
    description VARCHAR(512),
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES "user"."user" (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE sharing.post IS 'Посты, созданные пользователями для публикации информации о вещах';
COMMENT ON COLUMN sharing.post.id IS 'Уникальный идентификатор поста';
COMMENT ON COLUMN sharing.post.user_id IS 'ID пользователя, создавшего пост';
COMMENT ON COLUMN sharing.post.title IS 'Название поста';
COMMENT ON COLUMN sharing.post.description IS 'Описание поста';
COMMENT ON COLUMN sharing.post.created_at IS 'Дата и время создания поста';
COMMENT ON COLUMN sharing.post.updated_at IS 'Дата и время последнего обновления поста';

-- Таблица и последовательность для thing
CREATE SEQUENCE IF NOT EXISTS sharing.thing_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS sharing.thing (
    id INT8 NOT NULL DEFAULT nextval('sharing.thing_id_seq'),
    post_id INT8 NOT NULL,
    name VARCHAR(128) NOT NULL,
    description VARCHAR(512),
    price DECIMAL(9, 3) NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_post_id
        FOREIGN KEY (post_id)
            REFERENCES sharing.post (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE sharing.thing IS 'Предметы, связанные с постами, которые пользователи предлагают для обмена или продажи';
COMMENT ON COLUMN sharing.thing.id IS 'Уникальный идентификатор предмета';
COMMENT ON COLUMN sharing.thing.post_id IS 'ID поста, к которому относится предмет';
COMMENT ON COLUMN sharing.thing.name IS 'Название предмета';
COMMENT ON COLUMN sharing.thing.description IS 'Описание предмета';
COMMENT ON COLUMN sharing.thing.price IS 'Цена предмета в формате DECIMAL';
COMMENT ON COLUMN sharing.thing.created_at IS 'Дата и время создания записи о предмете';
COMMENT ON COLUMN sharing.thing.updated_at IS 'Дата и время последнего обновления записи о предмете';

-- Таблица и последовательность для thing
CREATE SEQUENCE IF NOT EXISTS sharing.payment_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS sharing.payment (
    id INT8 NOT NULL DEFAULT nextval('sharing.payment_id_seq'),
    buyer_id INT8 NOT NULL,
    thing_id INT8 NOT NULL,
    payment_status_id INT8 NOT NULL,
    created_at TIMESTAMPTZ(6) DEFAULT NOW(),
    updated_at TIMESTAMPTZ(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_buyer
        FOREIGN KEY (buyer_id)
            REFERENCES "user"."user" (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_thing
        FOREIGN KEY (thing_id)
            REFERENCES sharing.thing (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_payment_status
        FOREIGN KEY (payment_status_id)
            REFERENCES dictionary.payment_status (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE sharing.payment IS 'Информация о платежах за приобретение предметов';
COMMENT ON COLUMN sharing.payment.id IS 'Уникальный идентификатор записи о платеже';
COMMENT ON COLUMN sharing.payment.buyer_id IS 'ID пользователя-покупателя';
COMMENT ON COLUMN sharing.payment.thing_id IS 'ID предмета, за который осуществляется платеж';
COMMENT ON COLUMN sharing.payment.payment_status_id IS 'ID статуса платежа из справочника';
COMMENT ON COLUMN sharing.payment.created_at IS 'Дата и время создания записи о платеже';
COMMENT ON COLUMN sharing.payment.updated_at IS 'Дата и время последнего обновления записи о платеже';
