package org.spring.springboot.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.service.KtvService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class KtvServiceImpl implements KtvService {

    @Override
    public void methodSing() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            log.error("error");
        }
    }

    @Override
    public void methodDance() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            log.error("error");
        }
    }
}
