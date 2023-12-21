package common;

import accounting.SalaryRecord;

import java.nio.file.Path;
import java.util.List;

public interface JsonWriter {
    public void writeToFile(List<SalaryRecord> collection, Path fileName);
}
