package com;

import java.lang.Comparable;

public class Employee {
    String code = "";
    String name = "";
    int salary = 0;
    public Employee() {
    }
    public Employee(String c, String n, int s) {
        this.code = c;
        this.name = n;
        this.salary = s;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean equals(Employee emp) {
        return emp.getCode().equals(this.getCode()) &&
                emp.getName().equals(this.getName()) &&
                emp.getSalary() == this.getSalary();
    }

    @Override
    public String toString() {
        return this.code + "\t" + this.name + "\t" + this.salary;
    }
    
}
