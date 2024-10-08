-- 注意：该页面对应的前台目录为views/dzzz.certtyperole文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024042410444110400', NULL, '证照类型权限', '/dzzz.certtyperole/certtypeRoleList', 'dzzz.certtyperole/CerttypeRoleList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120401', '2024042410444110400', '添加证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120402', '2024042410444110400', '编辑证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120403', '2024042410444110400', '删除证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120404', '2024042410444110400', '批量删除证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120405', '2024042410444110400', '导出excel_证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042410444120406', '2024042410444110400', '导入excel_证照类型权限', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtyperole:certtype_role:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-24 10:44:40', NULL, NULL, 0, 0, '1', 0);