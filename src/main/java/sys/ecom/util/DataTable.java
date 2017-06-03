package sys.ecom.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debashis Paul on 6/3/2017.
 */
public class DataTable {
    private List data;
    private List options;
    private List files;
    private List<Column> columns;
    private String draw="1";
    private String recordsTotal="57";
    private String recordsFiltered="57";

    public DataTable(List data, List options, List files, List<Column> columns) {
        this.data = data;
        this.options = options;
        this.files = files;
        this.columns = columns;
    }

    public <T>DataTable(List<T> data, List options, List files,Class t) {
        this.data = data;
        this.options = options;
        this.files = files;

        List<Column> columns = new ArrayList<Column>();
        for (Field field : t.getDeclaredFields()) {
            Column column = new Column(field.getName(), field.getName());
            columns.add(column);
        }
        this.columns = columns;
    }

    public DataTable() {
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }

    public List getFiles() {
        return files;
    }

    public void setFiles(List files) {
        this.files = files;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public class Column {
        private String title;
        private String data;

        public Column(String title, String data) {
            this.title = title;
            this.data = data;
        }

        public Column() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
