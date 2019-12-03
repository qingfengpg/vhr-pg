package com.pg.vhrpg.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 *功能描述: 雇员实体
 * @author: pg
 * @date: 2019/12/3 11:09
 * @param:
 * @return:
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * 员工编号

    */
    private Integer id;

    /**
    * 员工姓名
    */
    private String name;

    /**
    * 性别
    */
    private String gender;

    /**
    * 生日
    */
    private Date birthday;

    /**
    * 身份证号
    */
    private String idCard;

    /**
    * 婚姻状况
    */
    private String wedlock;

    /**
    * 民族
    */
    private Integer nationId;

    /**
    * 籍贯
    */
    private String nationPlace;

    /**
    * 政治面貌
    */
    private Integer politicId;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 电话
    */
    private String phone;

    /**
    * 联系地址
    */
    private String address;

    /**
    * 所属部门
    */
    private Integer departmentId;

    /**
    * 职称ID
    */
    private Integer jobLevelId;

    /**
    * 职位ID
    */
    private Integer posId;

    /**
    * 聘用形式
    */
    private String engageForm;

    /**
    * 最高学历
    */
    private String tiptopDegree;

    /**
    * 所属专业
    */
    private String specialty;

    /**
    * 毕业院校
    */
    private String school;

    /**
    * 入职日期
    */
    private Date beginDate;

    /**
    * 在职状态
    */
    private String workState;

    /**
    * 工号
    */
    private String workId;

    /**
    * 合同期限
    */
    private Double contractTerm;

    /**
    * 转正日期
    */
    private Date conversionTime;

    /**
    * 离职日期
    */
    private Date notWorkDate;

    /**
    * 合同起始日期
    */
    private Date beginContract;

    /**
    * 合同终止日期
    */
    private Date endContract;

    /**
    * 工龄
    */
    private Integer workAge;

}
