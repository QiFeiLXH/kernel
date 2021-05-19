package com.bsoft.logs.entity.primary;


import java.io.Serializable;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class SinkToRedisCountDO implements Serializable {
    private Integer menuId;
    private AtomicInteger count = new AtomicInteger();
    private HashSet<String> persons = new HashSet();

    public void setCount(Integer count) {
        this.count.set(count);
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public void add(){
        count.incrementAndGet();
    }

    public void addCount(int counts){
        count.addAndGet(counts);
    }

    public Integer getCount(){
        return count.get();
    }

    public HashSet getPersons() {
        return persons;
    }

    public void setPersons(HashSet persons) {
        this.persons = persons;
    }

    public void addPerson(String personId){
        persons.add(personId);
    }

    public void addAllPerson(HashSet<String> persons){
        persons.addAll(persons);
    }
}
