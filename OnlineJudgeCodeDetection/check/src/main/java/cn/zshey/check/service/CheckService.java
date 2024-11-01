package cn.zshey.check.service;

import cn.zshey.check.model.dto.CheckDTO;
import cn.zshey.check.model.dto.SimilarityResult;

public interface CheckService {
    SimilarityResult check(CheckDTO checkDTO);
}
