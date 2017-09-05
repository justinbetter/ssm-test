package com.jus2lab.demo.ioc.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService{

    @Autowired
    private InjectionServiceDao dao;

    public void save(String string) {
        System.out.println("from InJectionServiceImal: "+string);
        dao.save(string);
    }
}
