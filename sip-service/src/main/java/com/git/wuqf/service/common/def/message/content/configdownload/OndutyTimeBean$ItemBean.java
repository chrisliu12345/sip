package com.git.wuqf.service.common.def.message.content.configdownload;


public class OndutyTimeBean$ItemBean {
    private String a;


    private String b;


    public OndutyTimeBean$ItemBean(OndutyTimeBean paramOndutyTimeBean) {
    }


    public String getBegin() {
        return this.a;
    }

    public void setBegin(String paramString) {
        this.a = paramString;
    }

    public String getEnd() {
        return this.b;
    }

    public void setEnd(String paramString) {
        this.b = paramString;
    }

    public String toString() {
        return
                "Begin\t" + this.a + "\n" + "End\t" + this.b + "\n";
    }
}
