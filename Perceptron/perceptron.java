//a simple xor perceptron

import java.util.*;

class Node {

	private float weight;
	private float threshhold;
	private boolean Activated;
	private ArrayList<Node> inputs;

	// constructor
	public Node(float t) {
		threshhold = t;
		Activated = false;
		inputs = new ArrayList<Node>();
	}

	public void setWeight(float newWeight) {
		weight = newWeight;
	}

	public void setWeight(boolean newWeight) {
		weight = newWeight ? 1.0f : 0.0f;
	}

	public float getWeight() {
		return weight;
	}

	public void connect(Node... ns) {
		for (Node n : ns)
			inputs.add(n);
	}

	// softmax function
	/*
     * 
     * 
     */
	public int[] softmax() {
		Node Magnitude;
		int[] results = new int[inputs.size()];
		for (int i = 0; i < inputs.size(); i++) {
			Magnitude = inputs.get(i);
		}

		return results;
	}

	// fire transactions are handled here
	public float pulse() {
		if (inputs.size() > 0) {
			float totalWeight = 0.0f;
			for (Node n : inputs) {
				n.pulse();
				totalWeight += (n.isActivated()) ? n.getWeight() : 0.0f;
			}
			Activated = totalWeight > threshhold;
			return totalWeight;
		} else if (weight != 0.0f) {
			Activated = weight > threshhold;
			return weight;
		} else {
			return 0.0f;
		}
	}

	public boolean isActivated() {
		return Activated;
	}

}// end Neuron class

public class perceptron {

	public static void main(String[] args) {
		Node xor = new Node(0.5f);
		Node left = new Node(1.0f);
		Node right = new Node(0.5f);
		left.setWeight(-1.0f);
		right.setWeight(1.0f);
		xor.connect(left, right);

		for (String val : args) {
			Node op = new Node(0.0f);
			op.setWeight(Boolean.parseBoolean(val));
			left.connect(op);
			right.connect(op);
		}

		 xor.pulse();
		 
		System.out.println("Result: " + xor.isActivated());

	}// end main

}// end perceptron

