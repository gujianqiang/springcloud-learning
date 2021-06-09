package me.gu.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysDept implements Serializable {

    private Long id;
    private String deptName;
    private String dbSource;

    public SysDept(String deptName) {
        this.deptName = deptName;
    }
}
