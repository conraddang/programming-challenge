package de.bcxp.challenge.common;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DataLoader<T> {
        List<T> loadData(String filePath) throws Exception;
        Optional<T> extractFields(Map<String, String> row);
}

