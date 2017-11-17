package com.zy.study.controller;

import com.zy.study.entity.City;
import com.zy.study.entity.CityExample;
import com.zy.study.entity.TbTaxpayer;
import com.zy.study.entity.TestPojo;
import com.zy.study.mapper.CityMapper;
import com.zy.study.mapper.TbTaxpayerMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class PageController {

  @Resource
  private CityMapper cityMapper;

  @InitBinder
  public void initBinder(WebDataBinder binder) {

  }


    @RequestMapping(value = "/toPage/{page}")
    @ResponseBody
    public List<City> toPage(@PathVariable(value = "page") String page, TestPojo testPojo, Map map) {


      List<City> cities = cityMapper.selectByExample(null);

      return cities;
    }
}
