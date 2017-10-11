package employee_importance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> hashMap = new HashMap<>();
        for (Employee e : employees) {
            hashMap.put(e.id, e);
        }
        return dfs(hashMap, id);
    }

    private  int dfs(Map<Integer, Employee> hashMap, int id) {
        int importance = 0;
        List<Integer> subordinates = hashMap.get(id).subordinates;
        importance += hashMap.get(id).importance;
        for (int i = 0; i < subordinates.size(); i++) {
            importance += dfs(hashMap, subordinates.get(i));
        }
        return importance;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
