package com.mmc.data.structure.system.entity;

/**
 * @packageName：com.mmc.data.structure.system.entity
 * @desrciption: 排序对象
 * @author: gaowei
 * @date： 2017/12/18 21:18
 * @history: (version) author date desc
 */
public class OrderSortEntity implements Comparable<OrderSortEntity>{

    private Integer id;
    private String param;
    private String desc;

    public OrderSortEntity() {

    }

    public OrderSortEntity(Integer id, String param, String desc) {
        this.id = id;
        this.param = param;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderSortEntity{" +
                "id=" + id +
                ", param='" + param + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderSortEntity that = (OrderSortEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (param != null ? !param.equals(that.param) : that.param != null) return false;
        return desc != null ? desc.equals(that.desc) : that.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (param != null ? param.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    /**
     * 比较
     * @param o
     * @return
     */
    public int compareTo(OrderSortEntity o) {
        if (o == null) {
            return -1;
        }
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        }
        return 0;
    }
}
