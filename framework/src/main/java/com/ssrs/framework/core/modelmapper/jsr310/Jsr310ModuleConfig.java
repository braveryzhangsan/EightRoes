package com.ssrs.framework.core.modelmapper.jsr310;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

/**
* @Description:    Config for {@link Jsr310Module}
* @Author:          ssrs
* @CreateDate:     2019/8/24 17:05
* @UpdateUser:     ssrs
* @UpdateDate:     2019/8/24 17:05
* @Version:        1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jsr310ModuleConfig {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    @Builder.Default
    private String datePattern = DEFAULT_DATE_PATTERN;
    @Builder.Default
    private String dateTimePattern = DEFAULT_DATE_TIME_PATTERN;
    @Builder.Default
    private String timePattern = DEFAULT_TIME_PATTERN;
    @Builder.Default
    private ZoneId zoneId = ZoneId.systemDefault();
}
