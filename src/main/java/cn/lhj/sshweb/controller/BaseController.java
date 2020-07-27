package cn.lhj.sshweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);//必须是符合日期格式，例如没有13月，32日这种，如果不符合，则报错。没有智能。
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));	
	}

}
