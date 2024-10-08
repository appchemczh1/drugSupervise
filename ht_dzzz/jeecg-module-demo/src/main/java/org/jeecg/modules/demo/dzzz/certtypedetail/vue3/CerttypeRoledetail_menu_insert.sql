-- 注意：该页面对应的前台目录为views/dzzz.certtypedetail文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024042609138240360', NULL, '证照类型权限详细描述', '/dzzz.certtypedetail/certtypeRoledetailList', 'dzzz.certtypedetail/CerttypeRoledetailList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250361', '2024042609138240360', '添加证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250362', '2024042609138240360', '编辑证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250363', '2024042609138240360', '删除证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250364', '2024042609138240360', '批量删除证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250365', '2024042609138240360', '导出excel_证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042609138250366', '2024042609138240360', '导入excel_证照类型权限详细描述', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certtypedetail:certtype_roledetail:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-26 09:13:36', NULL, NULL, 0, 0, '1', 0);