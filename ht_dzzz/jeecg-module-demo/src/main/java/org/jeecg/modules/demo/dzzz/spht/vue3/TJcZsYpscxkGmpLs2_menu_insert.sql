-- 注意：该页面对应的前台目录为views/dzzz.spht文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024080102366140070', NULL, 't_jc_zs_ypscxk_gmp_ls2', '/dzzz.spht/tJcZsYpscxkGmpLs2List', 'dzzz.spht/TJcZsYpscxkGmpLs2List', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140071', '2024080102366140070', '添加t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140072', '2024080102366140070', '编辑t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140073', '2024080102366140070', '删除t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140074', '2024080102366140070', '批量删除t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140075', '2024080102366140070', '导出excel_t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024080102366140076', '2024080102366140070', '导入excel_t_jc_zs_ypscxk_gmp_ls2', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.spht:t_jc_zs_ypscxk_gmp_ls2:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-08-01 14:36:07', NULL, NULL, 0, 0, '1', 0);