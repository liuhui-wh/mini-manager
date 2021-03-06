package me.liuhui.mall.manager.service.dto.ad.space;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyAdSpaceDTO extends CreateAdSpaceDTO {


    @NotNull
    private Long id;


}
