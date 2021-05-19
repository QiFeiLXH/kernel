package com.bsoft.message.bean;

import org.springframework.core.io.ByteArrayResource;

/**
 * @Auther: hy
 * @Date: 2020/7/14
 * @Description:
 */
public class EmailBasePic {
    private String contentId;
    private byte[] byteArray;
    private String contentType;

    public EmailBasePic() {
    }

    public EmailBasePic(String contentId, byte[] byteArray, String contentType) {
        this.contentId = contentId;
        this.byteArray = byteArray;
        this.contentType = contentType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
