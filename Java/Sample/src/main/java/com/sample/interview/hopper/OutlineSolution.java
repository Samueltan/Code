package com.sample.interview.hopper;

import java.util.*;
import java.util.stream.Collectors;

class OutlineSolution
{
    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }
    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Heading> headings = new ArrayList<>();
        headings.add(parse("H1 All About Birds"));
        headings.add(parse("H2 Kinds of Birds"));
        headings.add(parse("H3 The Finch"));
        headings.add(parse("H3 The Swan"));
        headings.add(parse("H2 Habitats"));
        headings.add(parse("H3 Wetlands"));

        Node outline = toOutline(headings);
        String html = toHtml(outline);
        System.out.println(html);
    }

//    public static void main(String[] args) throws java.lang.Exception
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Heading> headings = new ArrayList<>();
//        for (String line = br.readLine(); line != null; line = br.readLine()) {
//            headings.add(parse(line));
//        }
//        Node outline = toOutline(headings);
//        String html = toHtml(outline);
//        System.out.println(html);
//    }

    private static Node toOutline(List<Heading> headings) {
        // Implement this function. Sample code below builds an
        // outline of only the first heading.

        Node root = new Node(new Heading(0, ""));
        root.children.add(new Node(headings.get(0)));

        List<Node> nodes = headings.stream()
                .map(h -> new Node(h))
                .collect(Collectors.toList());

        for(Node n : nodes) {
            Node parent = findParent(n, nodes);
            parent.children.add(n);
        }

//        nodes.add(root);



//        nodes.forEach(
//            n -> {
//                if(n.heading != null) {
//                    n.children.addAll(map.get(n.heading.weight));
//                }
//            }
//        );

        return root;
    }

    private static Node findParent(Node n, List<Node> nodes) {
        int w = n.heading.weight;
        if(w == 1) return null;
//        for(int i=nodes)
        return null;
    }

    /** Parses a line of input.
     This implementation is correct for all predefined test cases. */
    private static Heading parse(String record) {
        String[] parts = record.split(" ", 2);
        int weight = Integer.parseInt(parts[0].substring(1));
        Heading heading = new Heading(weight, parts[1].trim());
        return heading;
    }

    /** Converts a node to HTML.
     This implementation is correct for all predefined test cases. */
    private static String toHtml(Node node) {
        StringBuilder buf = new StringBuilder();
        if (!node.heading.text.isEmpty()) {
            buf.append(node.heading.text);
            buf.append("\n");
        }
        Iterator<Node> iter = node.children.iterator();
        if (iter.hasNext()) {
            buf.append("<ol>");

            while (iter.hasNext()) {
                Node child = iter.next();
                buf.append("<li>");
                buf.append(toHtml(child));
                buf.append("</li>");
                if (iter.hasNext()) {
                    buf.append("\n");
                }
            }
            buf.append("</ol>");
        }
        return buf.toString();
    }
}
