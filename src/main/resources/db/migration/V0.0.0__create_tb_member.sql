CREATE TABLE member (
id          BIGINT      NOT NULL    AUTO_INCREMENT,
created_at  DATETIME(6),
updated_at  DATETIME(6),
email       VARCHAR(255) NOT NULL UNIQUE,
name        VARCHAR(255) NOT NULL,
password    VARCHAR(255) NOT NULL,
status      VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
)