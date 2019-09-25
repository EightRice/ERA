package seazzle;

import java.util.ArrayList;
import java.util.List;

public class ProducerContainer
{
    private List<Producer> rows = new ArrayList<>();

    public List<Producer> getRows()
    {
        return rows;
    }
    public void setRows(List<Producer> rows)
    {
        this.rows = rows;
    }
}
