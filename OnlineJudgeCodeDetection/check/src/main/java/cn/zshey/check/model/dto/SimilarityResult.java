package cn.zshey.check.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class SimilarityResult {
    private String status;
    private String identify;
    private Integer result;
    private String message;
    private List<String> similarity_list;
}
