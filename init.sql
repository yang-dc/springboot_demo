

CREATE TABLE IF NOT EXISTS `user_info` (
  id     BIGINT      NOT NULL AUTO_INCREMENT,
  userName   VARCHAR(64) DEFAULT NULL COMMENT '姓名',
  passWord   VARCHAR(64) DEFAULT NULL COMMENT '密码',
  age    INT         DEFAULT NULL COMMENT '年龄',
  email  VARCHAR(128) DEFAULT NULL COMMENT '邮箱',
  url  VARCHAR(128) DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


INSERT INTO user_info(userName, passWord, age, email, url) VALUES
  ('张三','123123', 20, 'zhangsan@test.com', '123123123213'),
  ('李四', '123213', 21, 'lisi@test.com', '1231231');
SELECT * FROM user_info;"

