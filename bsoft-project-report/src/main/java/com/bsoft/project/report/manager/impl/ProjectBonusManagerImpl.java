package com.bsoft.project.report.manager.impl;

import com.bsoft.project.report.entity.primary.ProjectBonusDO;
import com.bsoft.project.report.manager.ProjectBonusManager;
import com.bsoft.project.report.repository.primary.ProjectBonusRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 13:17
 * @Description:
 */
@Component
public class ProjectBonusManagerImpl implements ProjectBonusManager {
    private static final Logger logger = LoggerFactory.getLogger(ProjectBonusManagerImpl.class);
    @Autowired
    private ProjectBonusRepository projectBonusRepository;
    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProAllTotal(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProAllTotal(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProAllTotal(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProAllYear(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProAllYear(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProAllYear(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProAllMonth(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProAllMonth(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProAllMonth(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProDepTotal(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProDepTotal(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProDepTotal(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProDepYear(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProDepYear(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProDepYear(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusProDepMonth(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusProDepMonth(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusProDepMonth(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConAllTotal(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConAllTotal(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConAllTotal(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConAllYear(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConAllYear(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConAllYear(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConAllMonth(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConAllMonth(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConAllMonth(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConDepTotal(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConDepTotal(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConDepTotal(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConDepYear(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConDepYear(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConDepYear(startYear, endYear);
    }

    @Override
    public PageInfo<ProjectBonusDO> findProjectBonusConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBonusDO> list = projectBonusRepository.findProjectBonusConDepMonth(startYear, endYear);
        PageInfo<ProjectBonusDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<ProjectBonusDO> findProjectBonusConDepMonth(Integer startYear, Integer endYear) {
        return projectBonusRepository.findProjectBonusConDepMonth(startYear, endYear);
    }
}
