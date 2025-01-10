package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.R;
import com.example.demo.common.Result;
import com.example.demo.entity.SysRole;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyn
 * @since 2024-12-18
 */
@RestController
@RequestMapping("/admin/acl/role")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;

    @GetMapping("{page}/{limit}")
    public R index(@PathVariable Long page, @PathVariable Long limit, SysRole role) {
        Page<SysRole> pageParam = new Page<>(page, limit);
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(role.getRoleName())) {
            wrapper.like("role_name",role.getRoleName());
        }
        roleService.page(pageParam,wrapper);
        return R.ok().data("items", pageParam.getRecords()).data("total", pageParam.getTotal());
    }

    @PostMapping("save")
    public R save(@RequestBody SysRole role) {
        roleService.save(role);
        return R.ok();
    }
}

