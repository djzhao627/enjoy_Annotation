package cn.djzhao.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class IntDefTest {

    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;

    @WeekDay
    private int currentDay;

    @IntDef({MONDAY, TUESDAY})
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface WeekDay {

    }

    public void setCurrentDay(@WeekDay int day) {
        currentDay = day;
    }


}
