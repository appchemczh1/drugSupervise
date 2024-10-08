package org.jeecg.modules.demo.dzzz.homepage.entity;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ZsQydDto {

	private String id;
	private String zsid;
	private String fzjg;
	private String fzrq;
	private String zsbh;
	private String qymc;
	private String zslx;
	private String zslxBm;
	private String certTypeId;
	private String gzTime;
	private List<Map<String, String>> files;

}
