package org.jeecg.modules.demo.dzzz.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.mapper.AttachinfoMapper;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;
import org.jeecg.modules.demo.dzzz.attachinfo.service.impl.AttachinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AttachUtil {

@Autowired
IAttachinfoService iAttachinfoService;
    public   void  AddAttach(String filename,String type ,String fileurl, String zsid)
    {

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("zsid",zsid);
        queryWrapper.eq("type",type);
        queryWrapper.eq("status","1");
        List<Attachinfo> list = iAttachinfoService.list(queryWrapper);
        Attachinfo attachinfoByZSid=null;
        if(!list.isEmpty()&&list.size()>0)
        {
            attachinfoByZSid=list.get(0);
            attachinfoByZSid.setStatus("0");
            iAttachinfoService.update(attachinfoByZSid,null);
            Attachinfo attachinfo = new Attachinfo();
            attachinfo.setId(UUID.randomUUID().toString());
            attachinfo.setCreateBy("生成证照ofd");
            attachinfo.setType(type);
            attachinfo.setStatus("1");
            attachinfo.setFileName(filename);
            attachinfo.setCreateTime(new Date());
            attachinfo.setUserName("后台代码生成");
            attachinfo.setZsid(zsid);
            attachinfo.setModeUrl(fileurl);

            iAttachinfoService.save(attachinfo);
        }
        else {
            Attachinfo attachinfo = new Attachinfo();
            attachinfo.setId(UUID.randomUUID().toString());
            attachinfo.setCreateBy("生成证照ofd");
            attachinfo.setType(type);
            attachinfo.setFileName(filename);
            attachinfo.setCreateTime(new Date());
            attachinfo.setUserName("后台代码生成");
            attachinfo.setZsid(zsid);
            attachinfo.setModeUrl(fileurl);

            iAttachinfoService.save(attachinfo);
        }


    }

    public   Attachinfo getAttachinfo(String zsid,String status,String type)
    {
        IAttachinfoService iAttachinfoService=new AttachinfoServiceImpl();
        return  iAttachinfoService.findAttachinfoByZSid(zsid, type, status);

    }
}
