-- 注意：该页面对应的前台目录为views/dzzz.wgz文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024062704515240570', NULL, 'zs_ywxxb', '/dzzz.wgz/zsYwxxbList', 'dzzz.wgz/ZsYwxxbList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240571', '2024062704515240570', '添加zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240572', '2024062704515240570', '编辑zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240573', '2024062704515240570', '删除zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240574', '2024062704515240570', '批量删除zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240575', '2024062704515240570', '导出excel_zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024062704515240576', '2024062704515240570', '导入excel_zs_ywxxb', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.wgz:zs_ywxxb:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-27 16:51:57', NULL, NULL, 0, 0, '1', 0);