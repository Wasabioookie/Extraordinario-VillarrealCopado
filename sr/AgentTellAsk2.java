package clips.agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;

public class AgentTellAsk2 extends Agent{
	private Environment env;
	
	protected void setup(){
		env = new Environment();
		addBehaviour(new TellBehaviourMarket());
		addBehaviour(new AskBehaviourMarket());
		addBehaviour(new TellBehaviourMarket2());
		addBehaviour(new TellBehaviourPersons());
		addBehaviour(new AskBehaviourPersons());
		addBehaviour(new TellBehaviourProdcust());
		addBehaviour(new AskBehaviourProdcust());
	}
	private class TellBehaviourMarket extends Behaviour{
	    boolean tellDone = false;
	    public void action(){
	    	try{
		    System.out.println(" Market \n");
		    
		    env.eval("(clear)");
		    env.eval("(load challenge2/market/templates.clp)");
		    env.eval("(load challenge2/market/facts.clp)");
		    env.eval("(reset)");
		    
		    
		    tellDone = true;
		}catch(Exception e){}
	    }
	    public boolean done(){
	    	if(tellDone)
		    return true;
		else
		    return false;
	    }
	}
	private class AskBehaviourMarket extends Behaviour{
	    boolean askDone = false;
	    public void action(){
	    	try{
		    System.out.println(" ask:");
		    //env.eval("(facts)");
		    
		    System.out.println("Que clientes no han comprado nada? \n");
		    env.build("(defrule cust-not-buying (customer (customer-id ?id) (name ?name)) (not (order (order-number ?order) (customer-id ?id))) => (printout t ?name \" no ha comprado... nada!\" crlf))");
		    //env.eval("(reset)");
		    //env.eval("(facts)");
		    //env.eval("(run)");
		    //System.out.println("\n ask \n");
		    
		    askDone = true;
		}catch(Exception e){}
	    }
	    public boolean done(){
	    	return askDone;
	    }
	}
	private class TellBehaviourMarket2 extends Behaviour{
	    boolean tellDone = false;
	    public void action(){
	    	try{
		    System.out.println(" tell:");
		    env.eval("(run)");
		    
		    
		    tellDone = true;
		}catch(Exception e){}
	    }
	    public boolean done(){
	    	if(tellDone)
		    return true;
		else
		    return false;
	    }
	}
	
	
	
	private class TellBehaviourPersons extends Behaviour{
	    boolean tellDone = false;
	    public void action(){
	    	try{
		    System.out.println("\n Persons \n");
		    env.eval("(clear)");
		    env.eval("(load challenge2/persons/load-persons.clp)");
		    env.eval("(load challenge2/persons/load-persons-rules.clp)");
		    env.eval("(reset)");
		    
		    
		    tellDone = true;
		}catch(Exception e){}
	    }
	    public boolean done(){
	    	return tellDone;
	    }
	}
	private class AskBehaviourPersons extends Behaviour{
	    boolean askDone = false;
	    public void action(){
	    	try{
		    System.out.println("\n Person ask \n");
		    
		    env.eval("(run)");
		    
		    askDone = true;
		}catch(Exception e){}
	    }
		
	    
	    public boolean done(){
		if(askDone)
		    return true;
		else
		    return false;
	    }
	}
	
	
	private class TellBehaviourProdcust extends Behaviour{
	    boolean tellDone = false;
	    public void action(){
	    	try{
		    System.out.println("\n Product cost \n");
		    env.eval("(clear)");
		    env.eval("(load challenge2/prodcust/load-prod-cust.clp)");
		    env.eval("(load challenge2/prodcust/load-prodcust-rules.clp)");
		    env.eval("(reset)");
		    
		    
		    tellDone = true;
		}catch(Exception e){}
	    }
	    public boolean done(){
	    	return tellDone;
	    }
	}
	private class AskBehaviourProdcust extends Behaviour{
	    boolean askDone = false;
	    public void action(){
	    	try{
		    System.out.println("\n Product cost ask \n");
		    
		    env.eval("(run)");
		    
		    askDone = true;
		}catch(Exception e){}
	    }
		
	    
	    public boolean done(){
		if(askDone)
		    return true;
		else
		    return false;
	    }
	    public int onEnd(){
		myAgent.doDelete();
		return super.onEnd();
	    }
	}
}