DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `balance` decimal(10,2) DEFAULT '0.00',
  `accountName` varchar(254) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `consumeorder`;
CREATE TABLE `consumeorder` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `outerTradeNo` varchar(50) NOT NULL,
  `innerOrderNo` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '交易金额',
  `status` tinyint(4) DEFAULT NULL,
  `timeCreated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;