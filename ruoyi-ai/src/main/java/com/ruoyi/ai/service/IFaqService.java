package com.ruoyi.ai.service;

import java.util.List;
import com.ruoyi.ai.domain.Faq;

/**
 * FAQ管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface IFaqService 
{
    /**
     * 查询FAQ管理
     * 
     * @param id FAQ管理主键
     * @return FAQ管理
     */
    public Faq selectFaqById(Long id);

    /**
     * 查询FAQ管理列表
     * 
     * @param faq FAQ管理
     * @return FAQ管理集合
     */
    public List<Faq> selectFaqList(Faq faq);

    /**
     * 新增FAQ管理
     * 
     * @param faq FAQ管理
     * @return 结果
     */
    public int insertFaq(Faq faq);

    /**
     * 修改FAQ管理
     * 
     * @param faq FAQ管理
     * @return 结果
     */
    public int updateFaq(Faq faq);

    /**
     * 批量删除FAQ管理
     * 
     * @param ids 需要删除的FAQ管理主键集合
     * @return 结果
     */
    public int deleteFaqByIds(Long[] ids);

    /**
     * 删除FAQ管理信息
     * 
     * @param id FAQ管理主键
     * @return 结果
     */
    public int deleteFaqById(Long id);

    /**
     * 导入FAQ数据
     *
     * @param faqList FAQ数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importFaq(List<Faq> faqList, Boolean isUpdateSupport);
}
