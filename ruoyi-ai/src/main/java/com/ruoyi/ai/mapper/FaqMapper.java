package com.ruoyi.ai.mapper;

import java.util.List;
import com.ruoyi.ai.domain.Faq;

/**
 * FAQ管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface FaqMapper 
{
    /**
     * 查询FAQ管理
     * 
     * @param id FAQ管理主键
     * @return FAQ管理
     */
    public Faq selectFaqById(Long id);

    /**
     * 查询FAQ管理
     *
     * @param question FAQ管理主键
     * @return FAQ管理
     */
    public Faq selectFaqByQuestion(String question);

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
     * 删除FAQ管理
     * 
     * @param id FAQ管理主键
     * @return 结果
     */
    public int deleteFaqById(Long id);

    /**
     * 批量删除FAQ管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFaqByIds(Long[] ids);
}
