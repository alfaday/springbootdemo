
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `user_sex` varchar(6) NOT NULL DEFAULT '1' COMMENT '默认1：标记启用，0：标记禁用账户',
  `nick_name` varchar(30) DEFAULT '',
  `phone` varchar(255) DEFAULT '',
  `address` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs123456', 'zs123456-', '1', '张三', '13101253654', '太原');
INSERT INTO `user` VALUES ('23', 'leoshopuser1', 'leoshopuser1-', '1', '李四', '13513612345', '太原');
INSERT INTO `user` VALUES ('24', 'leoshopuser2', 'leoshopuser2-', '1', '', '', '');
INSERT INTO `user` VALUES ('25', 'leoshopuser3', 'leoshopuser3-8', '1', '', '', '');
INSERT INTO `user` VALUES ('26', 'leoshopuser4', 'leoshopuser4-', '1', '', '', '');
INSERT INTO `user` VALUES ('27', 'leoshopuser5', 'user5-', '1', '韩梅梅', '13456789916', '北京');
INSERT INTO `user` VALUES ('28', 'leoshopuser6', 'leoshopuser6-', '0', '', '', '');
INSERT INTO `user` VALUES ('29', 'leoshopuser7', 'leoshopuser7-', '0', '', '', '');
INSERT INTO `user` VALUES ('30', 'leoshopuser8', 'leoshopuser8-', '0', '', '', '');
INSERT INTO `user` VALUES ('31', 'userleoshp11', 'userleoshp11-', '1', '', '', '');
INSERT INTO `user` VALUES ('32', 'userleoshp112', 'userleoshp112-', '1', '', '', '');
INSERT INTO `user` VALUES ('33', 'userleoshp113', 'userleoshp113-', '1', '', '', '');
INSERT INTO `user` VALUES ('34', 'userleoshp1133', 'userleoshp1133-', '1', '', '', '');
INSERT INTO `user` VALUES ('35', 'userleoshp11331', '1', '1', '', '', '');
INSERT INTO `user` VALUES ('36', 'userleoshp11332', 'user5-', '1', '', '', '');
INSERT INTO `user` VALUES ('37', 'leoshopuser11', 'leoshopuser11-', '1', '', '', '');
