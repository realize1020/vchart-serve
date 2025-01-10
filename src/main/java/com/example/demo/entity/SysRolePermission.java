package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author wyn
 * @since 2024-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    private String roleId;

    private String permissionId;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    private Boolean isDeleted;


}
