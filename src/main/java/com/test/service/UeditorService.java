package com.test.service;

import com.test.vo.Result;
import com.test.vo.UeditorVo;

public interface UeditorService {
    Result addBody(UeditorVo ueditorVo);

    Result queryContentById(String contentKey);

    Result queryCntentList();
}
