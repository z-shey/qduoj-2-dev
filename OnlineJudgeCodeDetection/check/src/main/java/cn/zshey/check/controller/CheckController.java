package cn.zshey.check.controller;

import cn.zshey.check.model.dto.CheckDTO;
import cn.zshey.check.model.dto.SimilarityResult;
import cn.zshey.check.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/check")
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;

    @PostMapping
    public SimilarityResult check(@RequestBody CheckDTO checkDTO) {
        return checkService.check(checkDTO);
    }
}
