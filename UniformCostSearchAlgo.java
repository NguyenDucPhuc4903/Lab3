package lab3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> fronter = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.getPathCost() > o1.getPathCost() ? -1:o2.getLabel().compareTo(o1.getLabel());
			}
			
		});
		fronter.add(root);
		List<Node> explored = new ArrayList<>();
		while (!fronter.isEmpty()) {
			Node current = fronter.poll();
			if(current.getLabel().equals(goal)) {
				explored.add(current);
				return current;
				}
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node end = edge.getEnd();
				double newPathcost = current.getPathCost()+ edge.getWeight();
				if(!fronter.contains(edge)&&!explored.contains(edge)) {
					fronter.add(end);
					end.setParent(current);
					end.setPathCost(newPathcost);
				}else if(end.getPathCost()>newPathcost) {
					end.setPathCost(newPathcost);
					end.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				current.setParent(null);
			}
			if(current.getLabel().equals(goal) && started) {
				return current;
			}else {
				List<Node> children = current.getChildrenNodes();
//				System.out.println(current.getLabel()+": "+children.size());
				for (Node child : children) {
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
