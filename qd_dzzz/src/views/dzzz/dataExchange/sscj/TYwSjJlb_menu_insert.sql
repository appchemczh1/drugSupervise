-- 注意：该页面对应的前台目录为views/org.jeecg.modules.demo.dzzz.data_scj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024070203154210340', NULL, 't_yw_sj_jlb', '/org.jeecg.modules.demo.dzzz.data_scj/tYwSjJlbList', 'org.jeecg.modules.demo.dzzz.data_scj/TYwSjJlbList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220341', '2024070203154210340', '添加t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220342', '2024070203154210340', '编辑t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220343', '2024070203154210340', '删除t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220344', '2024070203154210340', '批量删除t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220345', '2024070203154210340', '导出excel_t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024070203154220346', '2024070203154210340', '导入excel_t_yw_sj_jlb', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo.dzzz.data_scj:t_yw_sj_jlb:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-07-02 15:15:34', NULL, NULL, 0, 0, '1', 0);