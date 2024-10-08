-- 注意：该页面对应的前台目录为views/dzzz.certinfo文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024070909306550370', NULL, '电子证照源数据', '/dzzz.certinfo/certInfoList', 'dzzz.certinfo/CertInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560371', '2024070909306550370', '添加电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560372', '2024070909306550370', '编辑电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560373', '2024070909306550370', '删除电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560374', '2024070909306550370', '批量删除电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560375', '2024070909306550370', '导出excel_电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070909306560376', '2024070909306550370', '导入excel_电子证照源数据', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certinfo:cert_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-09 09:30:37', NULL, NULL, 0, 0, '1', 0);