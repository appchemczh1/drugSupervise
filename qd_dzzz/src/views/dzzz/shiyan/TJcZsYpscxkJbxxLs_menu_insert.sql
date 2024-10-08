-- 注意：该页面对应的前台目录为views/dzzz.shiyan2文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024070604248490080', NULL, 't_jc_zs_ypscxk_jbxx_ls', '/dzzz.shiyan2/tJcZsYpscxkJbxxLsList', 'dzzz.shiyan2/TJcZsYpscxkJbxxLsList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248490081', '2024070604248490080', '添加t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248490082', '2024070604248490080', '编辑t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248490083', '2024070604248490080', '删除t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248490084', '2024070604248490080', '批量删除t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248500085', '2024070604248490080', '导出excel_t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070604248500086', '2024070604248490080', '导入excel_t_jc_zs_ypscxk_jbxx_ls', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.shiyan2:t_jc_zs_ypscxk_jbxx_ls:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-06 16:24:08', NULL, NULL, 0, 0, '1', 0);