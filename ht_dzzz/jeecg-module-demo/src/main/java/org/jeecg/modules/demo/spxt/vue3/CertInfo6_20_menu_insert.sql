-- 注意：该页面对应的前台目录为views/spxt文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024062004548730500', NULL, 'cert_info6_20', '/spxt/certInfo6_20List', 'spxt/CertInfo6_20List', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548730501', '2024062004548730500', '添加cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548730502', '2024062004548730500', '编辑cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548730503', '2024062004548730500', '删除cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548730504', '2024062004548730500', '批量删除cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548740505', '2024062004548730500', '导出excel_cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062004548740506', '2024062004548730500', '导入excel_cert_info6_20', NULL, NULL, 0, NULL, NULL, 2, 'spxt:cert_info6_20:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-20 16:54:50', NULL, NULL, 0, 0, '1', 0);