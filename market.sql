/*
Navicat MySQL Data Transfer

Source Server         : inymtern
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : taobao

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-05-10 21:37:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goodinfo`
-- ----------------------------
DROP TABLE IF EXISTS `goodinfo`;
CREATE TABLE `goodinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT NULL,
  `gcount` int DEFAULT NULL,
  `gprice` double DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  `sales` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gname` (`gname`),
  KEY `gprice` (`gprice`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodinfo
-- ----------------------------
INSERT INTO `goodinfo` VALUES ('55', 'nnn', '100', '100', '', '0');
INSERT INTO `goodinfo` VALUES ('57', 'vvv', '89', '100', '', '0');
INSERT INTO `goodinfo` VALUES ('58', 'ccc', '100', '100', '', '0');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`username`,`password`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('8', 'sdf', '123');
INSERT INTO `userinfo` VALUES ('9', 'cvbvn', 'gfdf');
INSERT INTO `userinfo` VALUES ('10', 'qwe', '345');
INSERT INTO `userinfo` VALUES ('13', 'rtyryrt', 'rtyrtyrty');
INSERT INTO `userinfo` VALUES ('14', 'cvgbdf', 'dfgdg');
INSERT INTO `userinfo` VALUES ('15', 'asdas', '123');
INSERT INTO `userinfo` VALUES ('16', 'vbnvbn', 'vbnvbn');
INSERT INTO `userinfo` VALUES ('17', 'asdasdasd', 'qwezx');
INSERT INTO `userinfo` VALUES ('18', 'cvbcxzc', 'xzvcx');
INSERT INTO `userinfo` VALUES ('19', 'fghfgh', 'fgh');
INSERT INTO `userinfo` VALUES ('20', 'ertwa', 'asd');
INSERT INTO `userinfo` VALUES ('21', 'fgddf', 'dfg');
INSERT INTO `userinfo` VALUES ('22', 'yui', 'yui');
INSERT INTO `userinfo` VALUES ('23', 'sfgsd', 'sdf');
INSERT INTO `userinfo` VALUES ('24', 'dfsgdfg', 'sdf');
INSERT INTO `userinfo` VALUES ('25', 'gdfgdf', 'sdf');
INSERT INTO `userinfo` VALUES ('26', 'asdad', 'sdf');
INSERT INTO `userinfo` VALUES ('27', 'fghffh', 'sdf');
INSERT INTO `userinfo` VALUES ('28', 'cvbcvb', 'sdf');
INSERT INTO `userinfo` VALUES ('29', 'zxc', 'sdf');
INSERT INTO `userinfo` VALUES ('30', 'rty', 'sdf');
INSERT INTO `userinfo` VALUES ('31', 'rtyrty', 'sdf');
INSERT INTO `userinfo` VALUES ('32', 'rfhf', 'sdf');
INSERT INTO `userinfo` VALUES ('33', 'ghjgh', 'sdf');
INSERT INTO `userinfo` VALUES ('34', 'cvhcv', 'sdf');
INSERT INTO `userinfo` VALUES ('35', 'uioio', 'sdf');
INSERT INTO `userinfo` VALUES ('36', 'hjkh', 'sdf');
INSERT INTO `userinfo` VALUES ('37', 'drtd', 'sdf');
INSERT INTO `userinfo` VALUES ('38', 'xcxv', 'sdf');
INSERT INTO `userinfo` VALUES ('39', 'werre', 'sdf');
INSERT INTO `userinfo` VALUES ('40', '1fdgdf', '1sd');
INSERT INTO `userinfo` VALUES ('41', 'xiaomao', '123456');
INSERT INTO `userinfo` VALUES ('42', '123', '123');
INSERT INTO `userinfo` VALUES ('43', '345', '345');
INSERT INTO `userinfo` VALUES ('44', 'vbn', 'vbn');

-- ----------------------------
-- Table structure for `userorder`
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `goodname` varchar(255) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `gprice` double(255,0) DEFAULT NULL,
  `tprice` double(255,0) DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goodname` (`goodname`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('21', '123', 'mmm', '100', '100', '10010', '2021-4-29 22:54');
INSERT INTO `userorder` VALUES ('22', '123', 'bbb', '100', '100', '10010', '2021-4-29 22:56');
INSERT INTO `userorder` VALUES ('23', '123', 'vvv', '1', '100', '100', '2021-5-10 21:01');
INSERT INTO `userorder` VALUES ('24', '123', 'vvv', '1', '100', '110', '2021-5-10 21:05');
