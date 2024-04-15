package com.ruoyi.ai.service;

import java.util.List;
import com.ruoyi.ai.domain.File;

/**
 * fileService接口
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public interface IFileService 
{
    /**
     * 查询file
     * 
     * @param id file主键
     * @return file
     */
    public File selectFileById(Long id);

    /**
     * 查询file列表
     * 
     * @param file file
     * @return file集合
     */
    public List<File> selectFileList(File file);

    /**
     * 新增file
     * 
     * @param file file
     * @return 结果
     */
    public int insertFile(File file);

    /**
     * 修改file
     * 
     * @param file file
     * @return 结果
     */
    public int updateFile(File file);

    /**
     * 批量删除file
     * 
     * @param ids 需要删除的file主键集合
     * @return 结果
     */
    public int deleteFileByIds(Long[] ids);

    /**
     * 删除file信息
     * 
     * @param id file主键
     * @return 结果
     */
    public int deleteFileById(Long id);
}
