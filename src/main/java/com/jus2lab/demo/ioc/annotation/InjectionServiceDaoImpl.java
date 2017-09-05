package com.jus2lab.demo.ioc.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionServiceDaoImpl implements InjectionServiceDao {


    public void save(String ss) {
        System.out.println("from DaoImpl:"+ss);
    }
}
