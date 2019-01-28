package com.wenwen.base;

import java.io.Serializable;

import lombok.NoArgsConstructor;

/**
 * @author xiaoxinga
 * @date 2018/9/10 15:58
 * @since
 */
@SuppressWarnings("serial")
@NoArgsConstructor
public class Result<T> implements Serializable {
    private String rsMsg;
    private String rsCode;
    private T data;

    public Result(String rsCode, String rsMsg) {
        this(rsCode, rsMsg, null);
    }

    private Result(String rsCode, String rsMsg, T data) {
        this.data = data;
        this.rsCode = rsCode;
        this.rsMsg = rsMsg;
    }

    public Result(ResultEnums resultEnums) {
        this(resultEnums.rsCode, resultEnums.rsMsg, null);
    }

    public void setRsMsg(String rsMsg) {
        this.rsMsg = rsMsg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResultEnums(ResultEnums resultEnums) {
        this.rsCode = resultEnums.rsCode;
        this.rsMsg = resultEnums.rsMsg;
    }

    public void setResultEnums(ResultEnums resultEnums, T data) {
        this.rsCode = resultEnums.rsCode;
        this.rsMsg = resultEnums.rsMsg;
        this.data = data;
    }

    public String getRsMsg() {
        return rsMsg;
    }

    public String getRsCode() {
        return rsCode;
    }

    public T getData(){
        return data;
    }

    public enum ResultEnums {
        SUCCESS("操作成功", "00000"),
        Erroe("操作失败","00001"),
        SIGIN_SUCCESS("注册成功", "0000"),
        SIGIN_ERROR("注册失败", "0001"),
        SIGINED("已注册", "0002"),
        LOGON_SUCCESS("登录成功", "1000"),
        LOGON_ERROR("登录失败", "1001"),
        SEALED("账号被封", "1002"),
        WAIT_ACTIVATED("账号未激活","1003"),
        SYSTEM_ERROR("系统异常", "00002"),
        CODE_ERROR("验证码错误","2000"),
        CODE_LOSE("验证码失效","2001");
        public final String rsMsg;
        public final String rsCode;

        ResultEnums(String rsMsg, String rsCode) {
            this.rsMsg = rsMsg;
            this.rsCode = rsCode;
        }

        public static ResultEnums getResultEnumsByCode(String rsCode) {
            for (ResultEnums resultCode : ResultEnums.values()) {
                if (resultCode.rsCode.equals(rsCode)) {
                    return resultCode;
                }
            }
            return null;
        }
    }
}
