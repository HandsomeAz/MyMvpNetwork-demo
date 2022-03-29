package com.example.mymvpnetwork_master.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 19
 */
@Retention(RUNTIME) @Target(TYPE)
public @interface ViewInject {
    int mainLayoutId() default -1;
}
