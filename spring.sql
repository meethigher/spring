/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 05/04/2021 01:57:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '白沉香', 500);
INSERT INTO `account` VALUES (2, '胡列娜', 1500);
INSERT INTO `account` VALUES (3, '小舞', 1500);
INSERT INTO `account` VALUES (5, '水冰儿', 8000);
INSERT INTO `account` VALUES (6, '水冰儿', 8000);
INSERT INTO `account` VALUES (7, '水冰儿', 8000);
INSERT INTO `account` VALUES (8, '水冰儿', 8000);
INSERT INTO `account` VALUES (9, '水冰儿', 8000);
INSERT INTO `account` VALUES (10, '水冰儿', 8000);
INSERT INTO `account` VALUES (11, '水冰儿', 8000);

SET FOREIGN_KEY_CHECKS = 1;
