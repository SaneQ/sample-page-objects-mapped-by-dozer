package model;

import java.util.List;

public class QueryModel {

    public QueryModel(String query) {
        this.query = query;
    }

    public String query;
    public List<String> results;
}
