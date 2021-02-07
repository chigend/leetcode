package add_two_polynomials_represented_as_linked_lists;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.PolyNode;
import tool.PolyNodePrinter;
import tool.PolyNodeTestCaseTransformer;

public class Solution2 {

    public static void main(String[] args) {
        PolyNode poly1 = constructPolyNodeFromFile("poly1");
        PolyNode poly2 = constructPolyNodeFromFile("poly2");
        PolyNode polyNode = addPoly(poly1, poly2);
        PolyNodePrinter.print(polyNode);
    }

    public static PolyNode constructPolyNodeFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/yejinbiao/downloads/".concat(fileName)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PolyNodeTestCaseTransformer.transform(sb.toString());
    }


    public static PolyNode addPoly(PolyNode poly1, PolyNode poly2) {

        if (poly1 == null) {
            return poly2;
        }
        if (poly2 == null) {
            return poly1;
        }

        if (poly1.power == poly2.power) {
            poly1.coefficient += poly2.coefficient;
            PolyNode next = addPoly(poly1.next, poly2.next);
            if (poly1.coefficient != 0) {
                poly1.next = next;
                return poly1;
            } else {
                return next;
            }
        } else if (poly1.power < poly2.power) {
            poly2.next = addPoly(poly1, poly2.next);
            return poly2;
        } else {
            poly1.next = addPoly(poly1.next, poly2);
            return poly1;
        }

    }
}
