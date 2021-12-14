package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.dao.mapper.UeditorMapper;
import com.test.dao.vo.Ueditor;
import com.test.service.UeditorService;
import com.test.vo.Result;
import com.test.vo.UeditorVo;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UeditorServiceImpl implements UeditorService {

    @Autowired
    private UeditorMapper ueditorMapper;

    @Override
    public Result addBody(UeditorVo ueditorVo) {
        if (StringUtils.isBlank(ueditorVo.getContentKey())) {
            return Result.error(9999, "ContentKey不能为空");
        }

        Ueditor ueditor = new Ueditor();
        BeanUtils.copyProperties(ueditorVo, ueditor);
        log.info("【UeditorServiceImpl==>addBody " + ueditor + "】");
        try {
            int i = ueditorMapper.insert(ueditor);
            if (i == 1) {
                return Result.success(null);
            }
        }catch (Exception e) {
            log.error("【UeditorServiceImpl==>addBody添加失败 】");
            e.printStackTrace();
        }
        return Result.error(9999, "添加失败");
    }

    @Override
    public Result queryContentById(String contentKey) {
        LambdaQueryWrapper<Ueditor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Ueditor::getContentKey, contentKey);
        queryWrapper.last("limit 1 ");
        Ueditor ueditor = ueditorMapper.selectOne(queryWrapper);
        if (ueditor == null) {
            return Result.error(-1, "查询数据不存在！");
        }
        return Result.success(ueditor);
    }

    @Override
    public Result queryCntentList() {
        LambdaQueryWrapper<Ueditor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Ueditor::getContent, Ueditor::getContentHtml, Ueditor::getContentKey);
        List<Ueditor> ueditors = ueditorMapper.selectList(queryWrapper);
        return Result.success(ueditors);
    }
}
