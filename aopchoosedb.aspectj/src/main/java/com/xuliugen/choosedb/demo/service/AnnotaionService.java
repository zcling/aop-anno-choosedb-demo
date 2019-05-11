package com.xuliugen.choosedb.demo.service;

import com.xuliugen.choosedb.demo.anno.MyAnnnotaion;

import javax.inject.Named;

/**
 * Created by zcl on 2019-05-10.
 */
@Named
public class AnnotaionService {

    @MyAnnnotaion()
    public void getAnnoMessage(String str) {
        System.out.println("获取到的str:" + str);
    }
}
