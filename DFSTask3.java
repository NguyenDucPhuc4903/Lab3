package lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSTask3 implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			System.out.println(current.getLabel());

			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				List<Node> children = current.getChildrenNodes();
				for (int i = children.size()-1; i >= 0; i--) {
					Node child = children.get(i);
					if(!frontier.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			System.out.println(current.getLabel());
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				current.setParent(null);
			}
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				List<Node> children = current.getChildrenNodes();
				for (int i = children.size()-1; i >= 0; i--) {
					Node child = children.get(i);
					if(!frontier.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

}
