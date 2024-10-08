-- 注意：该页面对应的前台目录为views/dzzz.lszb文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024070304139880080', NULL, 'certchird_ylqxlcsyba_h', '/dzzz.lszb/certchirdYlqxlcsybaHList', 'dzzz.lszb/CertchirdYlqxlcsybaHList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880081', '2024070304139880080', '添加certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880082', '2024070304139880080', '编辑certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880083', '2024070304139880080', '删除certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880084', '2024070304139880080', '批量删除certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880085', '2024070304139880080', '导出excel_certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070304139880086', '2024070304139880080', '导入excel_certchird_ylqxlcsyba_h', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.lszb:certchird_ylqxlcsyba_h:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-03 16:13:08', NULL, NULL, 0, 0, '1', 0);