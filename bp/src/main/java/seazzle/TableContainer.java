package seazzle;

import java.util.ArrayList;
import java.util.List;

public class TableContainer {
	
	private List<Voter> rows = new ArrayList<>();

    public List<Voter> getRows()
    {
        return rows;
    }
    public void setRows(List<Voter> rows)
    {
        this.rows = rows;
    }

}
