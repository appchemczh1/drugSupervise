-- 注意：该页面对应的前台目录为views/dzzz.certzminfo文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024061305306260100', NULL, 'cert_zminfo', '/dzzz.certzminfo/certZminfoList', 'dzzz.certzminfo/CertZminfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260101', '2024061305306260100', '添加cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260102', '2024061305306260100', '编辑cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260103', '2024061305306260100', '删除cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260104', '2024061305306260100', '批量删除cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260105', '2024061305306260100', '导出excel_cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024061305306260106', '2024061305306260100', '导入excel_cert_zminfo', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certzminfo:cert_zminfo:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-13 17:30:10', NULL, NULL, 0, 0, '1', 0);