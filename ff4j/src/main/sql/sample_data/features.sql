-- simple feature toggle
INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION)
VALUES ('sample_enable', true, 'sample enabled feature');;

INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION)
VALUES ('sample_disable', false, 'sample disabled feature');;

-- date based feature toggle
insert into FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, STRATEGY, EXPRESSION)
values ('past_feature', true, 'past time based feature', 'org.ff4j.strategy.time.ReleaseDateFlipStrategy',
        CONCAT('releaseDate=', DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 MONTH), '%Y-%m-%d-00:00')));;

insert into FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, STRATEGY, EXPRESSION)
values ('past_disabled', false, 'past time based feature', 'org.ff4j.strategy.time.ReleaseDateFlipStrategy',
        CONCAT('releaseDate=', DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 MONTH), '%Y-%m-%d-00:00')));;

insert into FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, STRATEGY, EXPRESSION)
values ('future_feature', true, 'future time based feature', 'org.ff4j.strategy.time.ReleaseDateFlipStrategy',
        CONCAT('releaseDate=', DATE_FORMAT(DATE_ADD(NOW(), INTERVAL 1 MONTH), '%Y-%m-%d-00:00')));;

-- group feature toggle
SET @group_name = 'group_1';;

INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, GROUPNAME)
VALUES ('sample_gp1_enable', true, 'sample enabled feature for group 1', @group_name);;

INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, GROUPNAME)
VALUES ('sample_gp1_disable', false, 'sample enabled feature for group 1', @group_name);;

SET @group_name = 'group_2';;

INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, GROUPNAME)
VALUES ('sample_gp2_enable', true, 'sample enabled feature for group 1', @group_name);;

INSERT INTO FF4J_FEATURES
(FEAT_UID, ENABLE, DESCRIPTION, GROUPNAME)
VALUES ('sample_gp2_disable', false, 'sample enabled feature for group 1', @group_name);;

