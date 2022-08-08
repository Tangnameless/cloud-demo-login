/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : cloud_demo

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/08/2022 09:24:23
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1554283325957079046 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'root', '123456');
INSERT INTO `tb_user` VALUES (2, 'tangyi', '123456');
INSERT INTO `tb_user` VALUES (3, 'user', '123456');
INSERT INTO `tb_user` VALUES (4, 'test_user', '123456');
INSERT INTO `tb_user` VALUES (1554283325957079042, 'tom', '123456');
INSERT INTO `tb_user` VALUES (1554283325957079043, 'jerry', '123456');
INSERT INTO `tb_user` VALUES (1554283325957079051, 'jerry11', '123456');
INSERT INTO `tb_user` VALUES (1554283325957079052, 'tommy', '123456');
INSERT INTO `tb_user` VALUES (1554283325957079054, '注册测试', '123456');

SET FOREIGN_KEY_CHECKS = 1;
