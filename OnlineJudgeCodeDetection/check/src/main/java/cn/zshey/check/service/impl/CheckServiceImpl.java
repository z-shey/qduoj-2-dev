package cn.zshey.check.service.impl;

import cn.zshey.check.model.dto.CheckDTO;
import cn.zshey.check.model.dto.SimilarityResult;
import cn.zshey.check.service.CheckService;
import de.jplag.*;
import de.jplag.c.CLanguage;
import de.jplag.exceptions.ExitException;
import de.jplag.java.JavaLanguage;
import de.jplag.options.JPlagOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    @Override
    public SimilarityResult check(CheckDTO checkDTO) {
        System.out.println("相似度检测开始");

        Language language = null;
        if (checkDTO.getLanguage().equalsIgnoreCase("C")) {
            language = new CLanguage();
        } else if (checkDTO.getLanguage().equalsIgnoreCase("Java")) {
            language = new JavaLanguage();
        }

        System.out.println("checkDTO.getCode_path() --> " + checkDTO.getCode_path());
        System.out.println("checkDTO.getLibrary_path() --> " + checkDTO.getLibrary_path());

        JPlagOptions options = new JPlagOptions(
                language,
                Set.of(new File(checkDTO.getCode_path())),
                Set.of(new File(checkDTO.getLibrary_path()))
        );

        SimilarityResult similarityResult = new SimilarityResult();

        try {
            JPlagResult result = JPlag.run(options);

            int numberOfComparisons = result.getOptions().maximumNumberOfComparisons();
            List<JPlagComparison> comparisons = result.getComparisons(numberOfComparisons);

            int maximumSimilarity = 0;
            List<String> stringList = new ArrayList<>();
            for (JPlagComparison comparison : comparisons) {
                maximumSimilarity = Math.max(maximumSimilarity, (int) (comparison.similarity() * 100));
                stringList.add(comparison + " : " + comparison.similarity());
            }

            similarityResult.setStatus("success");
            similarityResult.setSimilarity_list(stringList);
            similarityResult.setResult(maximumSimilarity);
        } catch (ExitException e) {
            // error handling here
        }
        System.out.println("相似度检测完成");
        return similarityResult;
    }
}
