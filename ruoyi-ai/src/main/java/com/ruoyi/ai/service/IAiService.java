package com.ruoyi.ai.service;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(url="${aiserver.url}",name="AiServer")
public interface IAiService {

    @PostMapping(value = "/api/v1/faq/add_faq")
    public JSONObject add_faq(@RequestBody Map<String,?> param);

    @PostMapping(value = "/api/v1/faq/delete_faq")
    public JSONObject delete_faq(@RequestBody Map<String,?> param);

    @PostMapping(value = "/api/v1/faq/delete_faq_batch")
    public JSONObject delete_faq_batch(@RequestBody Map<String,?> param);

    @PostMapping(value = "/api/v1/faq/update_faq")
    public JSONObject update_faq(@RequestBody Map<String,?> param);
}
