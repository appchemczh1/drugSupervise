-- 注意：该页面对应的前台目录为views/dzzz.czmx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024071603274350300', NULL, 't_yw_zs_czjlmx_ls_n', '/dzzz.czmx/tYwZsCzjlmxLsNList', 'dzzz.czmx/TYwZsCzjlmxLsNList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274350301', '2024071603274350300', '添加t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274350302', '2024071603274350300', '编辑t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274350303', '2024071603274350300', '删除t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274350304', '2024071603274350300', '批量删除t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274360305', '2024071603274350300', '导出excel_t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024071603274360306', '2024071603274350300', '导入excel_t_yw_zs_czjlmx_ls_n', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.czmx:t_yw_zs_czjlmx_ls_n:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-16 15:27:30', NULL, NULL, 0, 0, '1', 0);