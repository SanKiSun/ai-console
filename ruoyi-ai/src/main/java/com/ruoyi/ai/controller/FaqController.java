package com.ruoyi.ai.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.ServletUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.ai.domain.Faq;
import com.ruoyi.ai.service.IFaqService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * FAQ管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/ai/faq")
public class FaqController extends BaseController
{
    @Autowired
    private IFaqService faqService;

    /**
     * 查询FAQ管理列表
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:list')")
    @GetMapping("/list")
    public TableDataInfo list(Faq faq)
    {
        startPage();
        List<Faq> list = faqService.selectFaqList(faq);
        return getDataTable(list);
    }

    /**
     * 导出FAQ管理列表
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:export')")
    @Log(title = "FAQ管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Faq faq)
    {
        List<Faq> list = faqService.selectFaqList(faq);
        ExcelUtil<Faq> util = new ExcelUtil<Faq>(Faq.class);
        util.exportExcel(response, list, "FAQ管理数据");
    }

    /**
     * 获取FAQ管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(faqService.selectFaqById(id));
    }

    /**
     * 新增FAQ管理
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:add')")
    @Log(title = "FAQ管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Faq faq)
    {
        faq.setCreated(new Date());
        return toAjax(faqService.insertFaq(faq));
    }

    /**
     * 批量新增FAQ管理
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:add_list')")
    @Log(title = "FAQ管理", businessType = BusinessType.INSERT)
    @PostMapping("/add_list")
    public AjaxResult add_list(@RequestBody List<Faq> faqs)
    {
        for(Faq faq: faqs){
            faq.setCreated(new Date());
            faqService.insertFaq(faq);
        }
        return toAjax(faqs.size());
    }

    /**
     * 修改FAQ管理
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:edit')")
    @Log(title = "FAQ管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Faq faq)
    {
        return toAjax(faqService.updateFaq(faq));
    }

    /**
     * 删除FAQ管理
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:remove')")
    @Log(title = "FAQ管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(faqService.deleteFaqByIds(ids));
    }

    /**
     * 导入FAQ管理列表
     */
    @PreAuthorize("@ss.hasPermi('ai:faq:remove')")
    @Log(title = "FAQ管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Faq> util = new ExcelUtil<Faq>(Faq.class);
        List<Faq> faqList = util.importExcel(file.getInputStream());
        String message = faqService.importFaq(faqList, updateSupport);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<Faq> util = new ExcelUtil<Faq>(Faq.class);
        return util.importTemplateExcel("FAQ数据");
    }
}
