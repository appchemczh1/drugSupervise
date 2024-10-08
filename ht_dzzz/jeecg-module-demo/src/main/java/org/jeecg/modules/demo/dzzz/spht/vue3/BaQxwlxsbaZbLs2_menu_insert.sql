-- 注意：该页面对应的前台目录为views/dzzz.spht文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024080102373170310', NULL, 'ba_qxwlxsba_zb_ls2', '/dzzz.spht/baQxwlxsbaZbLs2List', 'dzzz.spht/BaQxwlxsbaZbLs2List', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373170311', '2024080102373170310', '添加ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373180312', '2024080102373170310', '编辑ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373180313', '2024080102373170310', '删除ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373180314', '2024080102373170310', '批量删除ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373180315', '2024080102373170310', '导出excel_ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102373180316', '2024080102373170310', '导入excel_ba_qxwlxsba_zb_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:ba_qxwlxsba_zb_ls2:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:37:31', NULL, NULL, 0, 0, '1', 0);