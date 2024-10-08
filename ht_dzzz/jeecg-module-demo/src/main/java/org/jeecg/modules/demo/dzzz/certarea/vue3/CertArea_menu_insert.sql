-- 注意：该页面对应的前台目录为views/dzzz.certarea文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024052910588890430', NULL, '湖北区划表', '/dzzz.certarea/certAreaList', 'dzzz.certarea/CertAreaList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588890431', '2024052910588890430', '添加湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588900432', '2024052910588890430', '编辑湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588900433', '2024052910588890430', '删除湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588900434', '2024052910588890430', '批量删除湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588900435', '2024052910588890430', '导出excel_湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024052910588900436', '2024052910588890430', '导入excel_湖北区划表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certarea:cert_area:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-29 10:58:43', NULL, NULL, 0, 0, '1', 0);