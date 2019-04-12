package cn.lyy.hp.filesystem.response;

import cn.lyy.hp.filesystem.FileSystem;
import lombok.Data;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
public class UploadURLResult extends ResponseResult {
    String pic_name;
    String url;
    String upload_time;

    public UploadURLResult(ResultCode resultCode, String url) {
        super(resultCode);
        this.url = url;
    }

    public UploadURLResult(ResultCode resultCode, String pic_name, String url, String upload_time) {
        super(resultCode);
        this.pic_name = pic_name;
        this.url = url;
        this.upload_time = upload_time;
    }
}

