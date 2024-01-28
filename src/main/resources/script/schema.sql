CREATE TABLE `member` (
	`member_id`	varchar(20)	NOT NULL,
	`email`	varchar(30)	NULL,
	`password`	varchar(30)	NULL,
	`member_status`	varchar(10)	NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`member_id`
);

