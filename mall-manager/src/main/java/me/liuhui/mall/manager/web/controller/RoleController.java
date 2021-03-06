package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.RoleService;
import me.liuhui.mall.manager.service.dto.role.CreateRoleDTO;
import me.liuhui.mall.manager.service.dto.role.ListRoleDTO;
import me.liuhui.mall.manager.service.dto.role.ModifyRoleDTO;
import me.liuhui.mall.manager.service.vo.role.ListRoleVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PerCode("role:mgt")
    @GetMapping("list")
    public ResultVO<ListRoleVO> list(ListRoleDTO dto) {
        return roleService.list(dto);
    }

    @PerCode("role:add")
    @PostMapping("create")
    public ResultVO<Boolean> create(@Validated @RequestBody CreateRoleDTO dto) {
        return roleService.create(dto);
    }

    @PerCode("role:update")
    @PostMapping("modify")
    public ResultVO<Boolean> modify(@Validated @RequestBody ModifyRoleDTO dto) {
        return roleService.modify(dto);
    }

    @PerCode("role:del")
    @DeleteMapping("delete")
    public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return roleService.delete(ids);
    }

    @PerCode("role:update")
    @GetMapping("permission-ids")
    public ResultVO<Set<Long>> selectPermissionIds(@Validated @NotNull Long id) {
        return roleService.selectPermissionIds(id);
    }


}
