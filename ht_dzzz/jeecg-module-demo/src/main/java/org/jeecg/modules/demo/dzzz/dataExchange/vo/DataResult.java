package org.jeecg.modules.demo.dzzz.dataExchange.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;

import java.io.Serializable;

@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class DataResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    @JsonIgnore
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String msg = "";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T data;

    public DataResult() {
    }

    /**
     * 兼容VUE3版token失效不跳转登录页面
     * @param code
     * @param msg
     */
    public DataResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DataResult<T> success(String msg) {
        this.msg = msg;
        this.code = YwConstant.SUCCESS_CODE_200;
        this.success = true;
        return this;
    }

    public static<T> DataResult<T> ok() {
        DataResult<T> r = new DataResult<T>();
        r.setSuccess(true);
        r.setMsg("推送成功");
        r.setCode(YwConstant.SUCCESS_CODE_200);
        return r;
    }

    public static<T> DataResult<T> ok(String msg) {
        DataResult<T> r = new DataResult<T>();
        r.setSuccess(true);
        r.setCode(YwConstant.SUCCESS_CODE_200);
        r.setData((T) msg);
        r.setMsg(msg);
        return r;
    }

    public static<T> DataResult<T> ok(T data) {
        DataResult<T> r = new DataResult<T>();
        r.setSuccess(true);
        r.setMsg("推送成功");
        r.setCode(YwConstant.SUCCESS_CODE_200);
        r.setData(data);
        return r;
    }

    public static<T> DataResult<T> ok(String msg, T data) {
        DataResult<T> r = new DataResult<T>();
        r.setSuccess(true);
        r.setMsg(msg);
        r.setCode(YwConstant.SUCCESS_CODE_200);
        r.setData(data);
        return r;
    }

    public static<T> DataResult<T> error(String msg, T data) {
        DataResult<T> r = new DataResult<T>();
        r.setSuccess(false);
        r.setCode(YwConstant.ERROR_CODE_300);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static<T> DataResult<T> error(String msg) {
        return error(YwConstant.ERROR_CODE_300, msg);
    }

    public static<T> DataResult<T> error500(String msg) {
        return error(YwConstant.ERROR_CODE_500, msg);
    }

    public static<T> DataResult<T> error(int code, String msg) {
        DataResult<T> r = new DataResult<T>();
        r.setCode(code);
        r.setMsg(msg);
        r.setSuccess(false);
        return r;
    }

}
