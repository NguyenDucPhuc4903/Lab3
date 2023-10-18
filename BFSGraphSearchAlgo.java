package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				explored.add(current);
				return current;
				}
			List<Node> children = current.getChildrenNodes();
			for (Node node : children) {
				if(!frontier.contains(node)&&!explored.contains(node)) {
					frontier.add(node);
					node.setParent(current);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		boolean check = false;
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				check = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);

				
				}else if(current.getLabel().equals(goal)&&check==true) {
					explored.add(current);
					return current;
				}
//			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node node : children) {
				if(!frontier.contains(node)&&!explored.contains(node)) {
					frontier.add(node);
					node.setParent(current);
				}
			}
		}
		return null;
	}

}
