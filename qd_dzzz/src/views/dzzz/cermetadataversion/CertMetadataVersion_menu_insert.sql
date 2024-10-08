-- 注意：该页面对应的前台目录为views/dzzz.certmatadataversion文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024032104439000320', NULL, '证书元数据版本', '/dzzz.certmatadataversion/certMetadataVersionList', 'dzzz.certmatadataversion/CertMetadataVersionList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010321', '2024032104439000320', '添加证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010322', '2024032104439000320', '编辑证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010323', '2024032104439000320', '删除证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010324', '2024032104439000320', '批量删除证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010325', '2024032104439000320', '导出excel_证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032104439010326', '2024032104439000320', '导入excel_证书元数据版本', NULL, NULL, 0, NULL, NULL, 2, 'dzzz.certmatadataversion:cert_metadata_version:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-21 16:43:32', NULL, NULL, 0, 0, '1', 0);