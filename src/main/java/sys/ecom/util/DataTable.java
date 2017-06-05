package sys.ecom.util;

import sys.ecom.bean.EntityManagerBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debashis Paul on 6/3/2017.
 */
public class DataTable {
    private List data;
    private List<Column> columns;
    private String draw;
    private String recordsTotal;
    private String recordsFiltered;
    private String start;
    private String length;

    public <T> DataTable(String[] length, String[] start, String[] draw, String[] col, Class t) {
        if (col == null) {
            this.length = length[0];
            this.start = start[0];
            this.draw = draw[0];

            EntityManagerBuilder builder = new EntityManagerBuilder();
            EntityManager em = builder.getEntityManager();

            Query totalCount = em.createQuery("select count(c) from " + t.getSimpleName() + " c");
            this.recordsTotal = this.recordsFiltered = String.valueOf(totalCount.getSingleResult());


            Query query = em.createQuery("select c from " + t.getSimpleName() + " c");
            query.setFirstResult(Integer.parseInt(getStart()));
            query.setMaxResults(Integer.parseInt(getLength()));
            setData(query.getResultList());
        }

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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
