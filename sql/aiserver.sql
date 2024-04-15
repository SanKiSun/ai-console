/*
 Navicat Premium Data Transfer

 Source Server         : 10.8.4.38 3306
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 10.8.4.38:3306
 Source Schema         : aiserver

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 09/04/2024 11:36:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aft_label_data
-- ----------------------------
DROP TABLE IF EXISTS `aft_label_data`;
CREATE TABLE `aft_label_data`  (
  `session_id` bigint(20) NOT NULL,
  `image_file_id` bigint(20) NULL DEFAULT NULL,
  `label_file_id` bigint(20) NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `session_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for api_history
-- ----------------------------
DROP TABLE IF EXISTS `api_history`;
CREATE TABLE `api_history`  (
  `session_id` bigint(20) NULL DEFAULT NULL,
  `method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `text` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `type` enum('req','rsp','err') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1126 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for chat_message
-- ----------------------------
DROP TABLE IF EXISTS `chat_message`;
CREATE TABLE `chat_message`  (
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '会话ID',
  `type` enum('human','ai','system') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '消息类型',
  `format` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '消息格式',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '消息内容',
  `extra` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '额外内容',
  `liked` enum('default','like','unlike') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '点赞类型',
  `selected_messages` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '用户选择的历史消息id列表',
  `selected_plugins` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '用户选择的插件id列表',
  `selected_files` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '用户选择的文件id列表',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1347 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faq
-- ----------------------------
DROP TABLE IF EXISTS `faq`;
CREATE TABLE `faq`  (
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '会话ID',
  `scene_user_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '场景用户ID',
  `question` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '问题',
  `answer` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '答案',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '会话ID',
  `scene_user_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '场景用户ID',
  `filename` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件名',
  `content_type` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) NULL DEFAULT NULL COMMENT '文件大小',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 341 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for llm_history
-- ----------------------------
DROP TABLE IF EXISTS `llm_history`;
CREATE TABLE `llm_history`  (
  `session_id` bigint(20) NULL DEFAULT NULL,
  `step` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `args` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `kwargs` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22370 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for memory
-- ----------------------------
DROP TABLE IF EXISTS `memory`;
CREATE TABLE `memory`  (
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '会话ID',
  `submem` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '记忆共享范围限制',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '记忆内容',
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT '删除标志位',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 403 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for prompt_tool_message
-- ----------------------------
DROP TABLE IF EXISTS `prompt_tool_message`;
CREATE TABLE `prompt_tool_message`  (
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '会话ID',
  `type` enum('human','ai','system') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '消息类型',
  `format` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '消息格式',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '消息内容',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态标志位，True-可用，False-已过期',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `scene` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '场景',
  `sub_scene` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '子场景',
  `theme` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主题',
  `scene_user_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '场景用户ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4312 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
