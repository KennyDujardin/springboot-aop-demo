package org.spring.springboot.myaop;

import lombok.Data;

@Data
public class PointCut {

    private String classPattern;
    private String methodPattern;

    public PointCut(String classPattern, String methodPattern) {
        super();
        this.classPattern = classPattern;
        this.methodPattern = methodPattern;
    }
}
