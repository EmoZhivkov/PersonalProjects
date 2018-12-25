import java.util.*;

class Solution {

    static class LinkedNode {
        int count;
        int vertex;
        LinkedNode reference;

        LinkedNode(int incVertex) {
            vertex = incVertex;
            count = 1;
        }

        void attachTo(LinkedNode otherComponentReference) {
            reference = otherComponentReference;
            otherComponentReference.count += this.count;
        }

        LinkedNode getReference() {
            return reference;
        }
    }

    public static void main(String[] args) {
        Map<Integer, LinkedNode> linkedNodes = new HashMap<>();
        Set<LinkedNode> components = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();

        while (scanner.hasNextInt()) {
            int vertexOne = scanner.nextInt();
            int vertexTwo = scanner.nextInt();

            LinkedNode refOne = null;
            LinkedNode refTwo = null;

            if (linkedNodes.containsKey(vertexOne)) {
                refOne = linkedNodes.get(vertexOne);

                while (refOne.getReference() != null) {
                    refOne = refOne.getReference();
                }
            }

            if (linkedNodes.containsKey(vertexTwo)) {
                refTwo = linkedNodes.get(vertexTwo);

                while (refTwo.getReference() != null) {
                    refTwo = refTwo.getReference();
                }
            }

            if (refOne != null) {
                if (refTwo != null) {
                    if (refOne != refTwo) {
                        if (refOne.count <= refTwo.count) {
                            refOne.attachTo(refTwo);
                            components.remove(refOne);
                        } else {
                            refTwo.attachTo(refOne);
                            components.remove(refTwo);
                        }
                    }
                } else {
                    LinkedNode newVertex = new LinkedNode(vertexTwo);

                    newVertex.attachTo(refOne);
                    linkedNodes.put(vertexTwo, newVertex);
                }
            } else {
                if (refTwo != null) {
                    LinkedNode newVertex = new LinkedNode(vertexOne);

                    newVertex.attachTo(refTwo);
                    linkedNodes.put(vertexOne, newVertex);
                } else {
                    LinkedNode newVertOne = new LinkedNode(vertexOne);
                    LinkedNode newVertTwo = new LinkedNode(vertexTwo);

                    newVertTwo.attachTo(newVertOne);

                    components.add(newVertOne);

                    linkedNodes.put(vertexOne, newVertOne);
                    linkedNodes.put(vertexTwo, newVertTwo);
                }
            }
        }

        int smallest = Integer.MAX_VALUE;
        int largest = 0;

        for (LinkedNode vertex : components) {
            int curCount = vertex.count;

            if (curCount < smallest) {
                smallest = curCount;
            }

            if (curCount > largest) {
                largest = curCount;
            }
        }

        System.out.printf("%d %d\n", smallest, largest);
    }
}