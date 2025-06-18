package de.bcxp.challenge.common;

import java.util.List;

public interface DataLoader<T> {
        List<T> loadData(String filePath) throws Exception;
}

