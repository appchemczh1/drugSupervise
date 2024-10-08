-- 注意：该页面对应的前台目录为views/dzzz.information文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024062410307850490', NULL, 'information', '/dzzz.information/informationList', 'dzzz.information/informationList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850491', '2024062410307850490', '添加information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850492', '2024062410307850490', '编辑information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850493', '2024062410307850490', '删除information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850494', '2024062410307850490', '批量删除information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850495', '2024062410307850490', '导出excel_information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062410307850496', '2024062410307850490', '导入excel_information', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.information:information:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-24 10:30:49', NULL, NULL, 0, 0, '1', 0);
