package com.ruoyi.ai.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.ai.service.IAiService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ai.mapper.FaqMapper;
import com.ruoyi.ai.domain.Faq;
import com.ruoyi.ai.service.IFaqService;

import javax.validation.Validator;

/**
 * FAQ管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class FaqServiceImpl implements IFaqService {
    private static final Logger log = LoggerFactory.getLogger(FaqServiceImpl.class);
    private static final String scene_user_id = "ruoyi";

    @Autowired
    private FaqMapper faqMapper;

    @Autowired
    protected IAiService aiService;

    @Autowired
    protected Validator validator;

    /**
     * 查询FAQ管理
     *
     * @param id FAQ管理主键
     * @return FAQ管理
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public Faq selectFaqById(Long id) {
        return faqMapper.selectFaqById(id);
    }

    /**
     * 查询FAQ管理列表
     *
     * @param faq FAQ管理
     * @return FAQ管理
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Faq> selectFaqList(Faq faq) {
        return faqMapper.selectFaqList(faq);
    }

    /**
     * 新增FAQ管理
     *
     * @param faq FAQ管理
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertFaq(Faq faq) {
        Map param = new HashMap<String, Object>();
        Map faqMap = new HashMap<>();
        faqMap.put("question", faq.getQuestion());
        faqMap.put("answer", faq.getAnswer());

        param.put("session_id", faq.getSessionId());
        param.put("scene_user_id", scene_user_id);
        param.put("faq", faqMap);
        try {
            JSONObject result = aiService.add_faq(param);
            if (Integer.parseInt(result.get("status").toString()) == 1) {
                log.error("新增FAQ 异常 === {}", result.get("err_msg"));
                return 0;
            }
            log.info("新增FAQ 结果 === {}", result.toString());
        } catch (Exception e) {
            log.error("新增FAQ 异常 === {}", e.getMessage());
            return 0;
        }
        return 1;
    }

    /**
     * 修改FAQ管理
     *
     * @param faq FAQ管理
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int updateFaq(Faq faq) {
        Map param = new HashMap<String, Object>();
        Map faqMap = new HashMap<>();
        faqMap.put("id", faq.getId());
        faqMap.put("question", faq.getQuestion());
        faqMap.put("answer", faq.getAnswer());

        param.put("session_id", faq.getSessionId());
        param.put("scene_user_id", scene_user_id);
        param.put("faq", faqMap);
        try {
            JSONObject result = aiService.update_faq(param);
            if (Integer.parseInt(result.get("status").toString()) == 1) {
                log.error("修改FAQ 异常 === {}", result.get("err_msg"));
                return 0;
            }
            log.info("修改FAQ 结果 === {}", result.toString());
        } catch (Exception e) {
            log.error("修改FAQ 异常 === {}", e.getMessage());
            return 0;
        }
        return 1;
    }

    /**
     * 批量删除FAQ管理
     *
     * @param ids 需要删除的FAQ管理主键
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteFaqByIds(Long[] ids) {
        Map param = new HashMap<String, Object>();

        param.put("faq_ids", ids);
        try {
            JSONObject result = aiService.delete_faq_batch(param);
            if (Integer.parseInt(result.get("status").toString()) == 1) {
                log.error("批量删除FAQ 异常 === {}", result.get("err_msg"));
                return 0;
            }
            log.info("批量删除FAQ 结果 === {}", result.toString());
        } catch (Exception e) {
            log.error("批量删除FAQ 异常 === {}", e.getMessage());
            return 0;
        }
        return 1;
    }

    /**
     * 删除FAQ管理信息
     *
     * @param id FAQ管理主键
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteFaqById(Long id) {
        Map param = new HashMap<String, Object>();

        param.put("faq_id", id);
        try {
            JSONObject result = aiService.delete_faq(param);
            if (Integer.parseInt(result.get("status").toString()) == 1) {
                log.error("删除FAQ 异常 === {}", result.get("err_msg"));
                return 0;
            }
            log.info("删除FAQ 结果 === {}", result.toString());
        } catch (Exception e) {
            log.error("删除FAQ 异常 === {}", e.getMessage());
            return 0;
        }
        return 1;
    }


    /**
     * 导入FAQ数据
     *
     * @param faqList         FAQ数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public String importFaq(List<Faq> faqList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(faqList) || faqList.size() == 0) {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Faq faq : faqList) {
            try {
                // 验证是否存在这个问题
                Faq f = faqMapper.selectFaqByQuestion(faq.getQuestion());
                if (StringUtils.isNull(f)) {
                    BeanValidators.validateWithException(validator, faq);

                    Map param = new HashMap<String, Object>();
                    Map faqMap = new HashMap<>();
                    faqMap.put("question", faq.getQuestion());
                    faqMap.put("answer", faq.getAnswer());

                    param.put("session_id", faq.getSessionId());
                    param.put("scene_user_id", scene_user_id);
                    param.put("faq", faqMap);
                    try {
                        JSONObject result = aiService.add_faq(param);
                        if (Integer.parseInt(result.get("status").toString()) == 1) {
                            failureNum++;
                            String msg = "<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 导入失败：";
                            failureMsg.append(msg + result.get("err_msg"));
                            log.error(msg, result.get("err_msg"));
                        }
                    } catch (Exception e) {
                        failureNum++;
                        String msg = "<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 导入失败：";
                        failureMsg.append(msg + e.getMessage());
                        log.error(msg, e);
                    }
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、问题 " + faq.getQuestion() + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, faq);
                    Map param = new HashMap<String, Object>();
                    Map faqMap = new HashMap<>();
                    faqMap.put("id", f.getId());
                    faqMap.put("question", faq.getQuestion());
                    faqMap.put("answer", faq.getAnswer());

                    param.put("session_id", faq.getSessionId());
                    param.put("scene_user_id", scene_user_id);
                    param.put("faq", faqMap);
                    try {
                        JSONObject result = aiService.update_faq(param);
                        if (Integer.parseInt(result.get("status").toString()) == 1) {
                            failureNum++;
                            String msg = "<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 导入失败：";
                            failureMsg.append(msg + result.get("err_msg"));
                            log.error(msg, result.get("err_msg"));
                        }
                    } catch (Exception e) {
                        failureNum++;
                        String msg = "<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 导入失败：";
                        failureMsg.append(msg + e.getMessage());
                        log.error(msg, e);
                    }
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、问题" + faq.getQuestion() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、问题 " + faq.getQuestion() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
