package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class Record {
    private String tag;
    private String userId;
    private Date createdAt;
    private String origineId;
    private List<DataItem> datas;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrigineId() {
        return origineId;
    }

    public void setOrigineId(String origineId) {
        this.origineId = origineId;
    }

    public List<DataItem> getDatas() {
        return datas;
    }

    public void setDatas(List<DataItem> datas) {
        this.datas = datas;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
