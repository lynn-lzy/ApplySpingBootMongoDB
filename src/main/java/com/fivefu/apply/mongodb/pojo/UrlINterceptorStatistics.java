package com.fivefu.apply.mongodb.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="urlINterceptorStatistics")
public class UrlINterceptorStatistics {

	@Id
	private String id;
	@Field("url")
	private String url;   //服务链接
	@Field("urlname")
	private String urlname;   //服务名称
	@Field("createtime")
	private String createtime; //入库时间
	@Field("versionprop")
    private String versionprop;
	@Field("version")
    private String version;  //版本号
	@Field("modelsprop")
	private String modelsprop;
	@Field("models")
	private String models;   //手机型号
	@Field("useridprop")
	private String useridprop;
	@Field("userid")
	private int userid;     //用户名称
	@Field("devicetokenprop")
	private String devicetokenprop;
	@Field("devicetoken")
	private String devicetoken; //设备号
	@Field("counts")
	private Integer counts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getVersionprop() {
		return versionprop;
	}
	public void setVersionprop(String versionprop) {
		this.versionprop = versionprop;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getModelsprop() {
		return modelsprop;
	}
	public void setModelsprop(String modelsprop) {
		this.modelsprop = modelsprop;
	}
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
	}
	public String getUseridprop() {
		return useridprop;
	}
	public void setUseridprop(String useridprop) {
		this.useridprop = useridprop;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDevicetokenprop() {
		return devicetokenprop;
	}
	public void setDevicetokenprop(String devicetokenprop) {
		this.devicetokenprop = devicetokenprop;
	}
	public String getDevicetoken() {
		return devicetoken;
	}
	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}
	
}
