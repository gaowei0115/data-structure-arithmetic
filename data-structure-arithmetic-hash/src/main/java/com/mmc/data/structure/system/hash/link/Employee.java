package com.mmc.data.structure.system.hash.link;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-09 11:29
 * @history: (version) author date desc
 */
public class Employee {

    private String name;
    private double salary;
    private int sort;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0){
            return false;
        }
        if (sort != employee.sort){
            return false;
        }
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result;
        result = name.hashCode();
//        long temp;
//        temp = Double.doubleToLongBits(salary);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + sort;
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
