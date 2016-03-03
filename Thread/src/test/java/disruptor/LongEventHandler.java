package disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * Created by Fansghuai on 2016/1/27.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Event:" + event);
    }
}
