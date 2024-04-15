package com.ruoyi.ai.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ai.mapper.FileMapper;
import com.ruoyi.ai.domain.File;
import com.ruoyi.ai.service.IFileService;

/**
 * fileService业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
@Service
public class FileServiceImpl implements IFileService 
{
    @Autowired
    private FileMapper fileMapper;

    /**
     * 查询file
     * 
     * @param id file主键
     * @return file
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public File selectFileById(Long id)
    {
        return fileMapper.selectFileById(id);
    }

    /**
     * 查询file列表
     * 
     * @param file file
     * @return file
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<File> selectFileList(File file)
    {
        return fileMapper.selectFileList(file);
    }

    /**
     * 新增file
     * 
     * @param file file
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertFile(File file)
    {
        return fileMapper.insertFile(file);
    }

    /**
     * 修改file
     * 
     * @param file file
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int updateFile(File file)
    {
        return fileMapper.updateFile(file);
    }

    /**
     * 批量删除file
     * 
     * @param ids 需要删除的file主键
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteFileByIds(Long[] ids)
    {
        return fileMapper.deleteFileByIds(ids);
    }

    /**
     * 删除file信息
     * 
     * @param id file主键
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteFileById(Long id)
    {
        return fileMapper.deleteFileById(id);
    }
}
