package org.jeecg.modules.demo.dzzz.dataExchange.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Slf4j
public class ErrorUtil {

    /**
     * 数据为空或null，抛出异常
     * @param fieldValue
     * @param errorMsg
     * @throws YwException
     */
    public static void assertStringIsBlank (String fieldValue, String errorMsg) {
        if (StringUtils.isBlank(fieldValue)) {
            throw new YwException(errorMsg);
        }
    }

    /**
     * 数据为特殊字符，抛出异常
     * @param fieldValue
     * @param errorMsg
     * @throws YwException
     */
    public static void assertSpecialChar (String fieldValue, String errorMsg) {
        String regex = "[^*+-/_ ]+";
        if (!fieldValue.matches(regex)) {
            throw new YwException(errorMsg);
        }
        if (fieldValue.length() == 1 && fieldValue.contains("无")) {
            throw new YwException(errorMsg);
        }
    }

    /**
     * date不大于当前日期，抛出异常
     * @param dateStr
     * @param errorMsg
     * @throws YwException
     */
    public static void assertDateStrNotMoreThanCurrentDate (String dateStr, String errorMsg) {
        try {
//            String dateStr = DateUtils.parseDateToStr("yyyy-MM-dd", date);
            LocalDate now = LocalDate.now();
            LocalDate localDate = LocalDate.parse(dateStr);
            log.info("当前日期：{}, 发证日期：{}", now, localDate);
            if(localDate.compareTo(now) > 0) {
                throw new YwException(errorMsg);
            }
        } catch (Exception e) {
            if (errorMsg.equals(e.getMessage())) {
                throw new YwException(errorMsg);
            } else {
                throw new YwException("日期转换异常");
            }
        }
    }

    /**
     * date不小于当前日期，抛出异常
     * @param dateStr
     * @param errorMsg
     * @throws YwException
     */
    public static void assertDateStrNotLessThanCurrentDate (String dateStr, String errorMsg) {
        try {
//            String dateStr = DateUtils.parseDateToStr("yyyy-MM-dd", date);
            LocalDate now = LocalDate.now();
            LocalDate localDate = LocalDate.parse(dateStr);
            log.info("当前日期：{}, 有效期至日期：{}", now, localDate);
            if(localDate.compareTo(now) < 0) {
                throw new YwException(errorMsg);
            }
        } catch (Exception e) {
            if (errorMsg.equals(e.getMessage())) {
                throw new YwException(errorMsg);
            } else {
                throw new YwException("日期转换异常");
            }
        }
    }

    /**
     * 证书类型不存在，抛出异常
     * @param zslxList
     * @param fieldValue
     * @param errorMsg
     * @throws YwException
     */
    public static void assertZsListNotExist (List<String> zslxList, String fieldValue, String errorMsg) {
        if (!zslxList.contains(fieldValue)) {
            throw new YwException(errorMsg);
        }
    }

    /**
     * 条件失败，抛出异常
     * @param condition
     * @param errorMsg
     * @throws YwException
     */
    public static void assertFailure(boolean condition, String errorMsg) {
        if (condition) {
            throw new YwException(errorMsg);
        }
    }

}
