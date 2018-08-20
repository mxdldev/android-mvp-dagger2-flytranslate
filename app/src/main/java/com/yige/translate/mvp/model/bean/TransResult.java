package com.yige.translate.mvp.model.bean;

import java.util.List;

/**
 * Created by gxl on 2017/11/27.
 */

public class TransResult {
    private  String from;//翻译源语言
    private String to;//译文语言
    private List<TransItem> trans_result;//	MIXED LIST	翻译结果

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransItem> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TransItem> trans_result) {
        this.trans_result = trans_result;
    }
}
