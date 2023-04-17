package clowoodive.example.designpattern.behavior;

public class StateContext {
    private State state;

    public StateContext() {
        this.state = new ReadyState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    // state에 따라 달라지는 행동
    public void stopAction() {
        this.state.stop();
    }

    public void playAction() {
        this.state.play();
    }

    // state에서 호출도 가능
    private void stopMusic() {
        System.out.println("music stop");
    }

    private void playMusic() {
        System.out.println("music play");
    }

    // 중첩 클래스
    abstract class State {
        protected StateContext stateContext;

        public State(StateContext stateContext) {
            this.stateContext = stateContext;
        }

        abstract void stop();

        abstract void play();
    }

    // 중첩 클래스
    class ReadyState extends State {
        public ReadyState(StateContext stateContext) {
            super(stateContext);
        }

        @Override
        void stop() {
            System.out.println("ready state - stop() called, already stopped");
        }

        @Override
        void play() {
            this.stateContext.changeState(new PlayState(this.stateContext));
            System.out.println("ready state - play() called, change to play state");
            this.stateContext.playMusic();
        }
    }

    // 중첩 클래스
    class PlayState extends State {
        public PlayState(StateContext stateContext) {
            super(stateContext);
        }

        @Override
        void stop() {
            this.stateContext.changeState(new ReadyState(this.stateContext));
            System.out.println("play state - stop() called, change to stp state");
            this.stateContext.stopMusic();
        }

        @Override
        void play() {
            System.out.println("play state - play() called, already playing");
        }
    }
}

