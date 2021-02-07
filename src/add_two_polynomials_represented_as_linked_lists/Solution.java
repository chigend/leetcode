package add_two_polynomials_represented_as_linked_lists;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.PolyNode;
import tool.PolyNodePrinter;
import tool.PolyNodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        PolyNode poly1 = PolyNodeTestCaseTransformer.transform("[[1,0]]");
        PolyNode poly2 = PolyNodeTestCaseTransformer.transform("[[1,1]]");
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
        PolyNode fake = new PolyNode(-1, -1);

        PolyNode node = fake;
        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                poly1.coefficient += poly2.coefficient;
                if (poly1.coefficient != 0) {
                    node.next = poly1;
                    node = node.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (poly1.power < poly2.power) {
                node.next = poly2;
                poly2 = poly2.next;
                node = node.next;
            } else {
                node.next = poly1;
                poly1 = poly1.next;
                node = node.next;
            }
        }

        node.next = poly1 == null ? poly2 : poly1;

        return fake.next;
    }
}
