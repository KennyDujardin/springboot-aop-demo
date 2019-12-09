package org.spring.springboot.myaop;

import lombok.Data;

@Data
public class Aspect {

    private Advice advice;
    private PointCut pointCut;
}
