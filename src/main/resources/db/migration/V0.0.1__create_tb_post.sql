CREATE TABLE post (
id              BIGINT          NOT NULL       AUTO_INCREMENT,
created_at      DATETIME(6),
updated_at      DATETIME(6),
title           VARCHAR(255)    NOT NULL,
content         VARCHAR(2000)   NOT NULL,
member_id       BIGINT          NOT NULL,
PRIMARY KEY (id)
)