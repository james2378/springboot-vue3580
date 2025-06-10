package com.project.demo.controller;

import com.project.demo.entity.ClockIn;
import com.project.demo.service.ClockInService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *考勤打卡：(ClockIn)表控制层
 *
 */
@RestController
@RequestMapping("/clock_in")
public class ClockInController extends BaseController<ClockIn,ClockInService> {

    /**
     *考勤打卡对象
     */
    @Autowired
    public ClockInController(ClockInService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
