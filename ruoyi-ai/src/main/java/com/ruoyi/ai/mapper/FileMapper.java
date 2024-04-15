package com.ruoyi.ai.mapper;

import java.util.List;
import com.ruoyi.ai.domain.File;

/**
 * fileMapper接口
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public interface FileMapper 
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
     * 删除file
     * 
     * @param id file主键
     * @return 结果
     */
    public int deleteFileById(Long id);

    /**
     * 批量删除file
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFileByIds(Long[] ids);
}
