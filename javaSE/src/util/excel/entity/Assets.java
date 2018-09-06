package util.excel.entity;



import java.io.Serializable;
import java.util.Date;

import util.excel.annocation.ExcelCell;
import util.excel.annocation.ExcelSheet;

/*@Document(collection = "assets")*/
@ExcelSheet(value = 0,initRow = 2)
public class Assets implements Serializable {

    //用户名
    @ExcelCell(colName = "用户名")
    private String userName;

    //用户所属组织
    @ExcelCell(colName = "用户所属组织")
    private String organize_user;

    //计算机名
    @ExcelCell(colName = "计算机名")
    private String computerName;


    //计算机IP
    @ExcelCell(colName = "计算机IP")
    private String computerIp;

    //计算机所属组织
    @ExcelCell(colName = "计算机所属组织")
    private String organize_com;

    //日志类型
    @ExcelCell(colName = "日志类型")
    private String logType;

    //文档名称
    @ExcelCell(colName = "文档名称")
    private String fileName;

    //文档路径
    @ExcelCell(colName = "文档路径")
    private String filePath;

    //接收时间
    @ExcelCell(colName = "接收时间")
    private Date receiveTime;

    //解密时间
    @ExcelCell(colName = "解密时间")
    private Date decryptTime;

    //是否上传解密文件
    @ExcelCell(colName = "上传解密文件")
    private String isUpload;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganize_user() {
        return organize_user;
    }

    public void setOrganize_user(String organize_user) {
        this.organize_user = organize_user;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerIp() {
        return computerIp;
    }

    public void setComputerIp(String computerIp) {
        this.computerIp = computerIp;
    }

    public String getOrganize_com() {
        return organize_com;
    }

    public void setOrganize_com(String organize_com) {
        this.organize_com = organize_com;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getDecryptTime() {
        return decryptTime;
    }

    public void setDecryptTime(Date decryptTime) {
        this.decryptTime = decryptTime;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }


    @Override
    public String toString() {
        return "AssetInfo{" +
                "userName='" + userName + '\'' +
                ", organize_user='" + organize_user + '\'' +
                ", computerName='" + computerName + '\'' +
                ", computerIp='" + computerIp + '\'' +
                ", organize_com='" + organize_com + '\'' +
                ", logType='" + logType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", receiveTime=" + receiveTime +
                ", decryptTime=" + decryptTime +
                ", isUpload='" + isUpload + '\'' +
                '}';
    }
}
