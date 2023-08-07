CREATE TABLE `tenant` (
  `id` varchar(255) PRIMARY KEY COMMENT '租客id',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `sex` ENUM ('male', 'female') NOT NULL COMMENT '性别',
  `age` varchar(255) NOT NULL COMMENT '年龄',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `cid` varchar(255) NOT NULL COMMENT '身份证id',
  `cid_photo` varchar(255) NOT NULL COMMENT '身份证照片',
  `status` ENUM ('check_in', 'check_out', 'not_signed') DEFAULT "not_signed" COMMENT '租房状态'
);

CREATE TABLE `room` (
  `id` int PRIMARY KEY COMMENT '房号',
  `tid` varchar(255) NOT NULL DEFAULT "0" COMMENT '租客id',
  `rent` double NOT NULL DEFAULT 0 COMMENT '房租',
  `status` ENUM ('not_available', 'vacancy', 'maintaining') DEFAULT "not_available"
);

CREATE TABLE `receipt` (
  `id` int PRIMARY KEY COMMENT '收据id',
  `rid` int NOT NULL COMMENT '租客id',
  `cleaning_charge` double NOT NULL DEFAULT 0 COMMENT '清洁费',
  `television_charge` double NOT NULL DEFAULT 0 COMMENT '电视费',
  `network_charge` double NOT NULL DEFAULT 0 COMMENT '网费',
  `property_charge` double NOT NULL DEFAULT 0 COMMENT '物业费',
  `public_electricity_charge` double NOT NULL DEFAULT 0 COMMENT '公共电费',
  `balance_time` datetime NOT NULL DEFAULT (now()) COMMENT '结算日',
  `uid` varchar(255) COMMENT '用户id'
);

CREATE TABLE `water_balance` (
  `id` int PRIMARY KEY,
  `rid` int COMMENT '房号',
  `meter` double COMMENT '水表',
  `used` double COMMENT '实用',
  `price` double COMMENT '单价',
  `charge` double COMMENT '费用',
  `balance_time` datetime DEFAULT (now()) COMMENT '结算日'
);

CREATE TABLE `electricity_balance` (
  `id` int PRIMARY KEY,
  `rid` int COMMENT '房号',
  `meter` double COMMENT '水表',
  `used` double COMMENT '实用',
  `price` double COMMENT '单价',
  `charge` double COMMENT '费用',
  `balance_time` datetime DEFAULT (now()) COMMENT '结算日'
);

CREATE TABLE `contract` (
  `id` varchar(255) PRIMARY KEY COMMENT '合同id',
  `tid` varchar(255) NOT NULL COMMENT '租客id',
  `rid` integer NOT NULL COMMENT '房号',
  `start_time` datetime DEFAULT (now()),
  `end_time` datetime DEFAULT (now()),
  `update_time` datetime COMMENT '创建时间'
);

CREATE INDEX `index_users` ON `tenant` (`id`, `name`, `sex`, `age`, `cid`);

CREATE INDEX `index_room` ON `room` (`id`, `tid`);

ALTER TABLE `water_balance` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);

ALTER TABLE `electricity_balance` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);

ALTER TABLE `room` ADD FOREIGN KEY (`tid`) REFERENCES `tenant` (`id`);

ALTER TABLE `receipt` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);

ALTER TABLE `contract` ADD FOREIGN KEY (`tid`) REFERENCES `tenant` (`id`);

ALTER TABLE `contract` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);
