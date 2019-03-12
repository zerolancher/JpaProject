package com.zero.pojo;

import javax.persistence.*;

@Entity
@Table(name = "cst_customer")
public class Customer {
    /*
    *@GeneratedValue : 为主键指定生成策略
         *indentity : 主键自增(依赖于数据库:mysql,sqlserver,sqllite)
         *sequence : 使用序列生成主键值(依赖于数据库中的序列:Oracle)
               @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hehe")
               // @SequenceGenerator 序列详情配置. sequenceName=>指定序列名称  initialValue=>指定序列初始值
               @SequenceGenerator(name = "hehe",sequenceName = "seq_customer",initialValue = 1)
         table : 主键自增,依赖于表存储自增值(可以在任何数据库中使用)
               @GeneratedValue(strategy = GenerationType.TABLE,generator = "haha")
               @TableGenerator(name = "haha",
                              pkColumnName = "table_name",
                              valueColumnName = "value",
                              pkColumnValue = "customer_id",
                              initialValue = 0,
                              allocationSize = 1)
         auto : 自动三选一.
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long custId;
    @Column
    private String custName;

    @Column
    private String custSource;

    @Column
    private String custIndustry;

    @Column
    private String custLevel;

    @Column
    private String custAddress;

    @Column
    private String custPhone;

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
