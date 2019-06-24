package cn.lyy.hp.exception;

import cn.lyy.hp.filesystem.response.ResultCode;

public class ImgException extends RuntimeException {
    //错误代码
    ResultCode resultCode;
    private String error;

    public ImgException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ImgException(String error) {
        this.error = error;
    }


    public ResultCode getResultCode() {
        return resultCode;
    }
}
