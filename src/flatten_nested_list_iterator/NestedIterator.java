package flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午4:59
 */

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> elementData;
    private int cursor;
    public NestedIterator(List<NestedInteger> nestedList) {
        elementData = new ArrayList<>();
        processNestedList(elementData, nestedList);
    }

    private void processNestedList(List<Integer> elementData, List<NestedInteger> list ) {
        for (NestedInteger nestedInteger : list){
            if (nestedInteger.isInteger()) {
                elementData.add(nestedInteger.getInteger());
            }else {
                processNestedList(elementData, nestedInteger.getList());
            }
        };
    }


    @Override
    public boolean hasNext() {
        return cursor < elementData.size();
    }

    @Override
    public Integer next() {
        return elementData.get(cursor++);
    }
}
