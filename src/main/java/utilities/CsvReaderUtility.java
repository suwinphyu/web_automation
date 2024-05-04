package utilities;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CsvReaderUtility {

    public static List<Map<String,String >> read(File file) throws IOException {
        List<Map<String,String>> response = new LinkedList<>();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',').withComments();
        MappingIterator<Map<String,String>> iterator = mapper.reader(Map.class).with(schema).readValues(file);

        while (iterator.hasNext()){
            response.add(iterator.next());
        }
        return  response;
    }
}
