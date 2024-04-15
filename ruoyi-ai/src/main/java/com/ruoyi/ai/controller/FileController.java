package com.ruoyi.ai.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.ai.domain.File;
import com.ruoyi.ai.service.IFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * fileController
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
@RestController
@RequestMapping("/ai/file")
public class FileController extends BaseController
{
    @Autowired
    private IFileService fileService;

    /**
     * 查询file列表
     */
    @PreAuthorize("@ss.hasPermi('ai:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(File file)
    {
        startPage();
        List<File> list = fileService.selectFileList(file);
        return getDataTable(list);
    }

    /**
     * 导出file列表
     */
    @PreAuthorize("@ss.hasPermi('ai:file:export')")
    @Log(title = "file", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, File file)
    {
        List<File> list = fileService.selectFileList(file);
        ExcelUtil<File> util = new ExcelUtil<File>(File.class);
        util.exportExcel(response, list, "file数据");
    }

    /**
     * 获取file详细信息
     */
    @PreAuthorize("@ss.hasPermi('ai:file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fileService.selectFileById(id));
    }

    /**
     * 新增file
     */
    @PreAuthorize("@ss.hasPermi('ai:file:add')")
    @Log(title = "file", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody File file)
    {
        return toAjax(fileService.insertFile(file));
    }

    /**
     * 修改file
     */
    @PreAuthorize("@ss.hasPermi('ai:file:edit')")
    @Log(title = "file", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody File file)
    {
        return toAjax(fileService.updateFile(file));
    }

    /**
     * 删除file
     */
    @PreAuthorize("@ss.hasPermi('ai:file:remove')")
    @Log(title = "file", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fileService.deleteFileByIds(ids));
    }
}
