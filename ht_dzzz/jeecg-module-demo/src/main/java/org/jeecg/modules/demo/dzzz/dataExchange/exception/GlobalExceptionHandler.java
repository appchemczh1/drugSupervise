package org.jeecg.modules.demo.dzzz.dataExchange.exception;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.DataResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindException;

import java.util.List;


@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid注解抛出的异常
    //@ExceptionHandler(BindException.class)
    public DataResult bingExceptionHandler(BindException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        BindingResult bindResult = ex.getBindingResult();

        List<ObjectError> allErrors = bindResult.getAllErrors();

        for (ObjectError item : allErrors) {
            stringBuilder.append(item.getDefaultMessage())
                    .append(',');
        }
        // 删除最后一个逗号
        String errMsg = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        return DataResult.error(errMsg);
    }

    // 处理YwException异常
//    @ExceptionHandler(YwException.class)
//    public DataResult ywExceptionHandler(YwException ex) {
//        return DataResult.error(ex.getErrorMsg());
//    }

}
