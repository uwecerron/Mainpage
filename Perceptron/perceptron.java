//uwe cerron

import java.util.*;

class Neuron {
    private ArrayList<Neuron> inputs;
    private float weight;
    private float threshhold;
    private boolean fired;

    public Neuron (float t) {
        threshhold = t;
        fired = false;
        inputs = new ArrayList<Neuron>();
    }

    public void connect (Neuron ... ns) {
        for (Neuron n : ns) inputs.add(n);
    }

    public void setWeight (float newWeight) {
        weight = newWeight;
    }

    public void setWeight (boolean newWeight) {
        weight = newWeight ? 1.0f : 0.0f;
    }

    public float getWeight () {
        return weight;
    }

    public float fire () {
        if (inputs.size() > 0) {
            float totalWeight = 0.0f;
            for (Neuron n : inputs) {
                n.fire();
                totalWeight += (n.isFired()) ? n.getWeight() : 0.0f;
            }
            fired = totalWeight > threshhold;
            return totalWeight;
        }
        else if (weight != 0.0f) {
            fired = weight > threshhold;
            return weight;
        }
        else {
            return 0.0f;
        }
    }

    public boolean isFired () {
        return fired;
    }
}

public class perceptron { 
		
		    public static void main (String [] args) {
		        Neuron xor = new Neuron(0.5f);
		        Neuron left = new Neuron(1.5f);
		        Neuron right = new Neuron(0.5f);
		        left.setWeight(-1.0f);
		        right.setWeight(1.0f);
		        xor.connect(left, right);

		        for (String val : args) {
		            Neuron op = new Neuron(0.0f);
		            op.setWeight(Boolean.parseBoolean(val));
		            left.connect(op);
		            right.connect(op);
		        }

		        xor.fire();

		        System.out.println("Result: " + xor.isFired());

		    }
		
		    
		 
	
	
	

}

