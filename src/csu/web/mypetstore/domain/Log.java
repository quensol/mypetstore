package csu.web.mypetstore.domain;

public class Log {
    private String logUserId;
    private String logInfo;

    public Log(String logUserId, String logInfo) {
        this.logUserId = logUserId;
        this.logInfo = logInfo;
    }

    public Log() {
    }

    public String getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(String logUserId) {
        this.logUserId = logUserId;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }
}
