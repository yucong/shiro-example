package com.github.zhangkaitao.shiro.chapter12.service.impl;

import com.github.zhangkaitao.shiro.chapter12.dao.PermissionDao;
import com.github.zhangkaitao.shiro.chapter12.entity.Permission;
import com.github.zhangkaitao.shiro.chapter12.service.PermissionService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
