package juego;

import java.util.List;

public class DijsktraStar {
	private int T;
	
	  public final List<T> findPath(int oldX, int oldY, int newX, int newY) {
	        openList = new LinkedList<T>();
	        closedList = new LinkedList<T>();
	        openList.add(nodes[oldX][oldY]); // add starting node to open list

	        done = false;
	        T current;
	        while (!done) {
	            current = lowestFInOpen(); // get node with lowest fCosts from openList
	            closedList.add(current); // add current node to closed list
	            openList.remove(current); // delete current node from open list

	            if ((current.getxPosition() == newX)
	                    && (current.getyPosition() == newY)) { // found goal
	                return calcPath(nodes[oldX][oldY], current);
	            }

	            // for all adjacent nodes:
	            List<T> adjacentNodes = getAdjacent(current);
	            for (int i = 0; i < adjacentNodes.size(); i++) {
	                T currentAdj = adjacentNodes.get(i);
	                if (!openList.contains(currentAdj)) { // node is not in openList
	                    currentAdj.setPrevious(current); // set current node as previous for this node
	                    currentAdj.sethCosts(nodes[newX][newY]); // set h costs of this node (estimated costs to goal)
	                    currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
	                    openList.add(currentAdj); // add node to openList
	                } else { // node is in openList
	                    if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) { // costs from current node are cheaper than previous costs
	                        currentAdj.setPrevious(current); // set current node as previous for this node
	                        currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
	                    }
	                }
	            }

	            if (openList.isEmpty()) { // no path exists
	                return new LinkedList<T>(); // return empty list
	            }
	        }
	        return null; // unreachable
	    }
}
