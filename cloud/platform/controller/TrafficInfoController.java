package com.cloud.platform.controller;

import com.cloud.platform.entity.TrafficInfo;
import com.cloud.platform.entity.User;
import com.cloud.platform.service.TrafficInfoService;
import com.cloud.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TrafficInfoController {
    //注入UserService
    @Resource
    private TrafficInfoService trafficInfoService;

    @PostMapping("saveTraffic")
    public ModelAndView saveTraffic(
            @RequestParam("locationName") String locationName,
            @RequestParam("peopleNum") int peopleNum,
            @RequestParam("currentSj") String currentSj,
            ModelAndView mv){
        TrafficInfo trafficInfo =new TrafficInfo();
        trafficInfo.setLocationName(locationName);
        trafficInfo.setPeopleNum(peopleNum);
        trafficInfo.setCurrentSj(currentSj);
        trafficInfoService.save(trafficInfo);

        System.out.println("TrafficInfoController saveTraffic 方法被调用……");
        System.out.println("TrafficInfoController "+"公共地点名："+locationName+"人数："+peopleNum +"当前时间："+currentSj);
        //上传成功
        mv.setViewName("redirect:/success");
        return mv;
    }
    //处理js的post异步请求数据
    @RequestMapping(value="/getAllTraffic",method = RequestMethod.GET)
    public String index(Model model){
        List<TrafficInfo> trafficInfoList = (List<TrafficInfo>) trafficInfoService.getAll();
        model.addAttribute("trafficInfoList",trafficInfoList);
        // "index"是test.html的名，
        // "table_refresh"是index.html中需要刷新的部分标志,
        // 在标签里加入：th:fragment="table_refresh"
        return "index::table_refresh";
    }
}
