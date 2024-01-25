CREATE TABLE `member` (
                          `member_id`	varchar(20)	NOT NULL,
                          `email`	varchar(30)	NULL,
                          `password`	varchar(30)	NULL,
                          `status`	varchar(10)	NULL
                          primary key (`member_id`)
);