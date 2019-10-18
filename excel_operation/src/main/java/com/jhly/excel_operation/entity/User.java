package com.jhly.excel_operation.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.jhly.excel_operation.utils.ExcelUtil.ExcelCell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/10/18
 * @Description:com.jhly.excel_operation.entity
 * @Version:1.0
 */

@Repository
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    //@ExcelProperty("编号")
    @ExcelCell(index = 0)
    private Integer id;
    //@ExcelProperty("姓名")
    @ExcelCell(index = 1)
    private String uname;
    //@ExcelProperty("密码")
    @ExcelCell(index = 2)
    private String upass;
    //@ExcelProperty("年龄")
    @ExcelCell(index = 3)
    private Integer age;
    //@ExcelProperty("备注")
    @ExcelCell(index = 4)
    private String remark;
    //@ExcelProperty("创建时间")
    @ExcelCell(index = 5)
    private Date createDate;
}
