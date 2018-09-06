package util.excel.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注该类为excel实体类，并确定字段所在的行数
 * @author lujie
 * @date 2018-9-1
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelSheet {
    int value();
    int initRow() default 0;
}
