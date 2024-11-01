-- Таблица и последовательность для exception
CREATE SEQUENCE IF NOT EXISTS system.exception_id_seq
    INCREMENT 1
    MINVALUE  1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS system.exception (
    id INT8 DEFAULT nextval('system.exception_id_seq'),
    exception_type VARCHAR(255) NOT NULL,
    message TEXT,
    root_cause TEXT,
    class_name VARCHAR(255),
    method_name VARCHAR(255),
    stack_trace TEXT,
    created_at TIMESTAMP NOT NULL,
    request_url VARCHAR(500),
    PRIMARY KEY (id)
);

COMMENT ON TABLE system.exception IS 'Лог исключений, произошедших в системе';
COMMENT ON COLUMN system.exception.id IS 'Уникальный идентификатор записи об исключении';
COMMENT ON COLUMN system.exception.exception_type IS 'Тип исключения';
COMMENT ON COLUMN system.exception.message IS 'Сообщение исключения';
COMMENT ON COLUMN system.exception.root_cause IS 'Причина исключения';
COMMENT ON COLUMN system.exception.class_name IS 'Имя класса, вызвавшего исключение';
COMMENT ON COLUMN system.exception.method_name IS 'Имя метода, вызвавшего исключение';
COMMENT ON COLUMN system.exception.stack_trace IS 'Трассировка стека исключения';
COMMENT ON COLUMN system.exception.created_at IS 'Дата и время создания записи об исключении';
COMMENT ON COLUMN system.exception.request_url IS 'URL запроса, вызвавшего исключение';