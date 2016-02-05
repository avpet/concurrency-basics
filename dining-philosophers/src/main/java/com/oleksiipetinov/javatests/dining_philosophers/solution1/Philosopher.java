package com.oleksiipetinov.javatests.dining_philosophers.solution1;

import java.util.Random;

public class Philosopher implements Runnable {

    private final Configuration _configuration;
    private final Random randomise = new Random();
    private final Chopstick _leftChopstick;
    private final Chopstick _rightChopstick;
    private final String _name;
    private State _state;

    private boolean hadThoughts = false;
    private boolean hadFood = false;

    /* Enumeration class that holds
    * information about the possible
    * Philosopher's states
    */
    public enum State {
        EATING, THINKING, WAITING
    }

    /*
    * Main constructor for the Philosopher class
    * @param name   the name of the Philosopher
    * @param leftChopstick  the chopstick that is currently on the left of the Philosopher
    * @param rightChopstick the chopstick currently on the right of the Philosopher
    *
    */
    public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick, Configuration configuration) {
        System.out.println(name +" Started");
        this._leftChopstick = leftChopstick;
        this._rightChopstick = rightChopstick;
        this._name = name;
        this._configuration = configuration;
    }

    /*
    * The method eat that uses two chopsticks. It blockes the two Chopstick
    * objects so they could not be changed then it changes their state
    * as well as the state of the philosopher
    * At the end of the method, the chopsticks' state is reverted and
    * the Philosopher goes into the Thinking state
    */
    private void eat() throws InterruptedException {

        synchronized(_leftChopstick){
            while(_leftChopstick.isUsed() || _rightChopstick.isUsed())
                try{
                    this.setPhilosopherState(Philosopher.State.WAITING);
                    _leftChopstick.wait();
                }catch (InterruptedException ignored){}
            synchronized(_rightChopstick) {
                try{
                    Thread.sleep(1);
                    _leftChopstick.setUsed(true);
                    _rightChopstick.setUsed(true);
                    this.setPhilosopherState(Philosopher.State.EATING);
                    hadFood = true;
                    Thread.sleep(randomise.nextInt(_configuration.maxEatingTime));
                }
                finally {
                    _leftChopstick.setUsed(false);
                    _rightChopstick.setUsed(false);
                    _leftChopstick.notify();
                    _rightChopstick.notify();
                }
            }
        }

        think();
    }

    /*
    * This method only changes the state
    * of the Philosopher to Thinking
    */
    private void think() throws InterruptedException{
        this.setPhilosopherState(Philosopher.State.THINKING);
        hadThoughts = true;
        Thread.sleep(randomise.nextInt(_configuration.maxThinkingTime));
    }

    /*
    * Set the current state of the Philosopher
    */
    private void setPhilosopherState(State state){
        this._state = state;
        System.out.println(System.currentTimeMillis() +" : "+ _state +", "+ _name+";");
    }

    /*
    * Get the current state of the Philosopher
    */
    public State getPhilosopherState(){
        return _state;
    }

    /*
    * The method is invoked with the start of the thread
    * and runs the eat function for 10 times
    */
    public void run(){
        for(int i =0; i < _configuration.numberOfRounds;i++) {
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Succesfully finished: " +_name);
    }

    boolean hadThoughts() { return hadThoughts;}

    boolean hadFood() { return hadFood; }
}