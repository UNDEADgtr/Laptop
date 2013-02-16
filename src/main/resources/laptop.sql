/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : laptop

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2013-02-16 18:58:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `laptop`
-- ----------------------------
DROP TABLE IF EXISTS `laptop`;
CREATE TABLE `laptop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cost` int(11) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `seller` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of laptop
-- ----------------------------
INSERT INTO `laptop` VALUES ('1', '610', 'ASUS', '33545', 'note_1', 'AMD', 'OffLine');
INSERT INTO `laptop` VALUES ('2', '1200', 'DELL', '45645', 'note_3', 'Intel', 'ICO');
INSERT INTO `laptop` VALUES ('3', '450', 'Samsung', '55644', 'note_5', 'AMD', 'GoodNote');
INSERT INTO `laptop` VALUES ('4', '800', 'Samsung', '26265', 'note_3', 'AMD', 'BestIT');
INSERT INTO `laptop` VALUES ('5', '720', 'Lenovo', '33552', 'note_2', 'Intel', 'iShop');
INSERT INTO `laptop` VALUES ('6', '920', 'HP', '78752', 'note_6', 'Intel', 'iShop');
INSERT INTO `laptop` VALUES ('7', '670', 'HP', '21210', 'note_1', 'Intel', 'Prof');
INSERT INTO `laptop` VALUES ('8', '890', 'Acer', '25252', 'note_4', 'Intel', 'GoodNote');
INSERT INTO `laptop` VALUES ('9', '750', 'Samsung', '25251', 'note_1', 'AMD', 'iShop');
INSERT INTO `laptop` VALUES ('10', '340', 'ASUS', '24512', 'note_4', 'Intel', 'Prof');
INSERT INTO `laptop` VALUES ('11', '700', 'Lenovo', '25004', 'note_2', 'AMD', 'BestIT');
