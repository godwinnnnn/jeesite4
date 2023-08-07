CREATE TABLE `user` (
  `id` int PRIMARY KEY COMMENT '用户id',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `sex` varchar(255) NOT NULL COMMENT '性别',
  `age` varchar(255) NOT NULL COMMENT '年龄',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `cid` varchar(255) NOT NULL COMMENT '身份证id',
  `cid_photo` varchar(255) NOT NULL COMMENT '身份证照片',
  `status` ENUM ('check_in', 'check_out', 'not_signed') DEFAULT "not_signed" COMMENT '租房状态'
);

CREATE TABLE `room` (
  `id` int PRIMARY KEY COMMENT '房号',
  `uid` int NOT NULL DEFAULT "0" COMMENT '用户id',
  `rent` double NOT NULL DEFAULT 0 COMMENT '房租',
  `contract_starttime` datetime DEFAULT (now()),
  `contract_endtime` datetime DEFAULT (now()),
  `contract_id` varchar(255) NOT NULL,
  `status` ENUM ('not_available', 'vacancy', 'maintaining') DEFAULT "not_available"
);

CREATE TABLE `receipt` (
  `id` int PRIMARY KEY COMMENT '收据id',
  `rid` int NOT NULL COMMENT '房号id',
  `cleaning_charge` double NOT NULL DEFAULT 0 COMMENT '清洁费',
  `television_charge` double NOT NULL DEFAULT 0 COMMENT '电视费',
  `network_charge` double NOT NULL DEFAULT 0 COMMENT '网费',
  `property_charge` double NOT NULL DEFAULT 0 COMMENT '物业费',
  `public_electricity_charge` double NOT NULL DEFAULT 0 COMMENT '公共电费',
  `balance_time` datetime NOT NULL DEFAULT (now()) COMMENT '结算日',
  `receiver` varchar(255)
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

CREATE INDEX `index_users` ON `user` (`id`, `name`, `sex`, `age`, `cid`);

CREATE INDEX `index_room` ON `room` (`id`, `uid`, `contract_id`);

ALTER TABLE `water_balance` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);

ALTER TABLE `electricity_balance` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);

ALTER TABLE `room` ADD FOREIGN KEY (`uid`) REFERENCES `user` (`id`);

ALTER TABLE `receipt` ADD FOREIGN KEY (`rid`) REFERENCES `room` (`id`);
