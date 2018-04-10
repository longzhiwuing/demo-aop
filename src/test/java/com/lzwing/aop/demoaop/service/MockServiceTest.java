package com.lzwing.aop.demoaop.service;

import com.lzwing.aop.demoaop.security.CurrentUserHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockServiceTest {

    @Autowired
    MockService mockService;

    @Test(expected = RuntimeException.class)
    public void insert() {
        CurrentUserHolder.set("tom");
        mockService.insert("test");
    }

    @Test
    public void delete() {
        CurrentUserHolder.set("admin");
        mockService.delete("test delete....");
    }
}