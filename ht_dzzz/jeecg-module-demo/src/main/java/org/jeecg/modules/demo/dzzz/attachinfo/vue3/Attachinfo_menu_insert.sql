-- 注意：该页面对应的前台目录为views/dzzz.attachinfo文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024040703471010060', NULL, '附件储存表', '/dzzz.attachinfo/attachinfoList', 'dzzz.attachinfo/AttachinfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010061', '2024040703471010060', '添加附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010062', '2024040703471010060', '编辑附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010063', '2024040703471010060', '删除附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010064', '2024040703471010060', '批量删除附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010065', '2024040703471010060', '导出excel_附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024040703471010066', '2024040703471010060', '导入excel_附件储存表', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.attachinfo:attachinfo:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-07 15:47:06', NULL, NULL, 0, 0, '1', 0);