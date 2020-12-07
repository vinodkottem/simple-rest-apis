DROP TABLE IF EXISTS JOBS;

CREATE TABLE JOBS (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  STATUS VARCHAR(250) NOT NULL,
  UUID VARCHAR(250) NOT NULL,
  STEP VARCHAR(250),
  GOAL VARCHAR(250),
  RESULT VARCHAR(250),
  PRIMARY KEY (`id`),
);