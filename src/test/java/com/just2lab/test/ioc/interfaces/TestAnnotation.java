package com.just2lab.test.ioc.interfaces;

import com.jus2lab.demo.ioc.annotation.InjectionServiceImpl;
import com.just2lab.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAnnotation extends UnitTestBase {

    @Test
    public void testAnntation() {

        InjectionServiceImpl injectionServiceImpl = getBean("injectionServiceImpl");
        injectionServiceImpl.save("test strings");

    }




}
