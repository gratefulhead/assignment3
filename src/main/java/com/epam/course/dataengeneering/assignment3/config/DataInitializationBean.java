package com.epam.course.dataengeneering.assignment3.config;

import com.epam.course.dataengeneering.assignment3.service.DataInitializationService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DataInitializationBean implements InitializingBean {

    @Autowired
    private DataInitializationService dataInitializationService;

    @Override
    public void afterPropertiesSet() {
        dataInitializationService.process();
    }
}
