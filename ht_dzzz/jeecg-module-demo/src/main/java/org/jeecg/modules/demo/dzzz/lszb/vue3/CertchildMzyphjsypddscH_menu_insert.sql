-- 注意：该页面对应的前台目录为views/dzzz.lszb文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024070304145850350', NULL, 'certchild_mzyphjsypddsc_h', '/dzzz.lszb/certchildMzyphjsypddscHList', 'dzzz.lszb/CertchildMzyphjsypddscHList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850351', '2024070304145850350', '添加certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850352', '2024070304145850350', '编辑certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850353', '2024070304145850350', '删除certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850354', '2024070304145850350', '批量删除certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850355', '2024070304145850350', '导出excel_certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304145850356', '2024070304145850350', '导入excel_certchild_mzyphjsypddsc_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchild_mzyphjsypddsc_h:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:14:35', NULL, NULL, 0, 0, '1', 0);